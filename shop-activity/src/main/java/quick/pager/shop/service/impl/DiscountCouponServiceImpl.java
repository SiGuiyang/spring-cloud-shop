package quick.pager.shop.service.impl;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.sax.Excel07SaxReader;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import java.io.DataInputStream;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import quick.pager.shop.client.user.UserClient;
import quick.pager.shop.constants.RedisKeys;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.dto.activity.CouponDTO;
import quick.pager.shop.dto.user.UserInfoDTO;
import quick.pager.shop.mapper.DiscountCouponMapper;
import quick.pager.shop.model.activity.DiscountCoupon;
import quick.pager.shop.model.activity.DiscountCouponTemplate;
import quick.pager.shop.response.Response;
import quick.pager.shop.service.CouponTemplateService;
import quick.pager.shop.service.DiscountCouponService;
import quick.pager.shop.service.RedisService;
import quick.pager.shop.task.SendCouponTask;
import quick.pager.shop.utils.DateUtils;
import quick.pager.shop.utils.FileUtil;

@Service
@Slf4j
public class DiscountCouponServiceImpl extends ServiceImpl<DiscountCouponMapper, DiscountCoupon> implements DiscountCouponService {

    @Autowired
    private CouponTemplateService couponTemplateService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private UserClient userClient;

    @Override
    public Response<List<DiscountCoupon>> list(CouponDTO dto) {

        QueryWrapper<DiscountCoupon> qw = new QueryWrapper<>();
        if (!StringUtils.isEmpty(dto.getPhone())) {
            qw.eq("phone", dto.getPhone());
        }
        if (null != dto.getBeginTime() && null != dto.getEndTime()) {
            qw.ge("create_time", dto.getBeginTime());
            qw.le("create_time", dto.getEndTime());
        } else {
            qw.le("DATE_SUB(CURDATE(), INTERVAL 30 DAY)", "create_time");
        }
        return this.toPage(dto.getPage(), dto.getPageSize(), qw);
    }

    @Override
    public Response<DiscountCoupon> info(Long id) {
        return new Response<>(this.getById(id));
    }


    @Override
    public Response publish(String file, Long templateId) {

        Response response = couponTemplateService.info(templateId);

        // 选择的优惠券模板可用
        if (ResponseStatus.Code.SUCCESS == response.getCode()) {
            log.info("选择的优惠券模板可用 templateId = {}", templateId);
            DiscountCouponTemplate template = (DiscountCouponTemplate) response.getData();
            DataInputStream inputStream = null;

            try {

                inputStream = FileUtil.getRemoteFile(file);
                // 初始设置补发优惠券的大小
                List<String> phones = Lists.newArrayList();
                Excel07SaxReader reader = new Excel07SaxReader((sheetIndex, rowIndex, rowList) -> {
                    // 过滤掉标题
                    if (0 != rowIndex) {
                        phones.add(rowList.get(0).toString());
                    }
                });

                reader.read(inputStream, 0);

                if (CollectionUtils.isEmpty(phones)) {
                    log.info("excel 文件中没有用户手机号");
                    return new Response(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PUBLISH_COUPON_PHONE_IS_BLANK);
                }
                String[] phonesParam = new String[phones.size()];
                // 取出正常的用户
                Response<List<UserInfoDTO>> existsResponse = userClient.isExists(phones.toArray(phonesParam));

                List<UserInfoDTO> exists = null;
                if (ResponseStatus.Code.SUCCESS == existsResponse.getCode() && null != existsResponse.getData()) {
                    exists = existsResponse.getData();
                }


                // 正常用户的手机号
                List<String> normalPhones = Lists.newArrayList();

                List<DiscountCoupon> discountCoupons = Lists.newArrayList();

                if (!CollectionUtils.isEmpty(exists)) {
                    log.info("查询到用户");
                    // 当前补发优惠券的人数大于1000，则采用线程方式发送
                    if (exists.size() >= 1000) {
                        // 多线程执行后返回正常的插入的手机号
                        List<String> list = new ForkJoinPool(2).invoke(new SendCouponTask(exists, template, this.baseMapper));

                        // 移除发送正常的手机号码
                        phones.removeAll(list);

                    } else {

                        exists.forEach(v -> {

                            normalPhones.add(v.getPhone());

                            DiscountCoupon discountCoupon = new DiscountCoupon();
                            discountCoupon.setUserId(v.getId());
                            discountCoupon.setTemplateId(template.getId());
                            discountCoupon.setPhone(v.getPhone());
                            discountCoupon.setUsed(Boolean.FALSE);
                            discountCoupon.setCreateTime(DateUtils.now());
                            discountCoupon.setUpdateTime(DateUtils.now());
                            discountCoupon.setDeleteStatus(Boolean.FALSE);

                            discountCoupons.add(discountCoupon);

                        });

                        this.baseMapper.batchInsertSelective(discountCoupons);

                    }

                    // 移除正常的手机号
                    phones.removeAll(normalPhones);

                    // 最后得到的phones 存在的值必然是错误用户的手机号,这里的错误信息只提供参考，不打算存储在数据库中，放入redis中时效性7d
                    if (!CollectionUtils.isEmpty(phones)) {
                        log.info("存在错误的用户手机号，存在redis中，用于给运营展示");
                        redisService.set(RedisKeys.ManageKeys.SEND_COUPON_LIST + DateUtil.format(new Date(), DatePattern.PURE_DATETIME_PATTERN), JSON.toJSONString(phones), 7 * 60 * 60 * 24);
                    }
                } else {
                    log.info("未查到用户");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                IoUtil.close(inputStream);
            }
        }

        return response;
    }

}
