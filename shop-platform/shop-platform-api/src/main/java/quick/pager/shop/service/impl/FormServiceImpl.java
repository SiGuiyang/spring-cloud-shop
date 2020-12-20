package quick.pager.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import quick.pager.shop.mapper.FieldMapper;
import quick.pager.shop.mapper.FieldPropsMapper;
import quick.pager.shop.mapper.FormMapper;
import quick.pager.shop.model.Field;
import quick.pager.shop.model.FieldProps;
import quick.pager.shop.model.Form;
import quick.pager.shop.platform.request.form.FormOtherRequest;
import quick.pager.shop.platform.request.form.FormPageRequest;
import quick.pager.shop.platform.request.form.FormSaveRequest;
import quick.pager.shop.platform.response.FieldPropsResponse;
import quick.pager.shop.platform.response.FieldResponse;
import quick.pager.shop.platform.response.FormResponse;
import quick.pager.shop.service.FormService;
import quick.pager.shop.user.response.Response;
import quick.pager.shop.utils.BeanCopier;
import quick.pager.shop.utils.DateUtils;

/**
 * @author siguiyang
 */
@Service
public class FormServiceImpl extends ServiceImpl<FormMapper, Form> implements FormService {

    @Autowired
    private FieldMapper fieldMapper;
    @Autowired
    private FieldPropsMapper fieldPropsMapper;

    @Override
    public Response<Long> create(FormSaveRequest request) {
        Form form = this.convert(request);
        form.setDeleteStatus(Boolean.FALSE);
        form.setCreateTime(DateUtils.dateTime());
        form.setUpdateTime(DateUtils.dateTime());
        this.baseMapper.insert(form);
        return Response.toResponse(form.getId());
    }

    @Override
    public Response<Long> modify(FormSaveRequest request) {
        Form form = this.convert(request);
        form.setUpdateTime(DateUtils.dateTime());
        this.baseMapper.updateById(form);
        return Response.toResponse(form.getId());
    }

    @Override
    public Response<List<FormResponse>> queryPage(FormPageRequest request) {

        LambdaQueryWrapper<Form> wrapper = new LambdaQueryWrapper<Form>()
                .eq(Form::getDeleteStatus, Boolean.FALSE);

        if (Objects.nonNull(request.getId())) {
            wrapper.eq(Form::getId, request.getId());
        }

        if (StringUtils.isNotBlank(request.getBizType())) {
            wrapper.eq(Form::getBizType, request.getBizType());
        }

        if (StringUtils.isNotBlank(request.getName())) {
            wrapper.likeRight(Form::getName, request.getName());
        }

        Response<List<Form>> page = this.toPage(request.getPage(), request.getPageSize(), wrapper);

        return Response.toResponse(page.getData().stream().map(this::convert).collect(Collectors.toList()),
                page.getTotal());
    }

    @Override
    public Response<List<FormResponse>> queryList(FormOtherRequest request) {
        LambdaQueryWrapper<Form> wrapper = new LambdaQueryWrapper<Form>()
                .eq(Form::getDeleteStatus, Boolean.FALSE);

        if (Objects.nonNull(request.getId())) {
            wrapper.eq(Form::getId, request.getId());
        }

        if (StringUtils.isNotBlank(request.getBizType())) {
            wrapper.eq(Form::getBizType, request.getBizType());
        }

        if (StringUtils.isNotBlank(request.getName())) {
            wrapper.eq(Form::getName, request.getName());
        }
        List<Form> list = this.baseMapper.selectList(wrapper);
        return Response.toResponse(list.stream().map(this::convert).collect(Collectors.toList()));
    }

    @Override
    public List<FieldResponse> get(String bizType) {

        // 查询表单模型
        Form form = this.baseMapper.selectOne(new LambdaQueryWrapper<Form>()
                .eq(Form::getBizType, bizType)
                .eq(Form::getDeleteStatus, Boolean.FALSE));
        if (Objects.isNull(form)) {
            return Collections.emptyList();
        }

        // 查询表单字段
        List<Field> fields = fieldMapper.selectList(new LambdaQueryWrapper<Field>()
                .eq(Field::getFormId, form.getId())
                .eq(Field::getDeleteStatus, Boolean.FALSE));
        if (CollectionUtils.isEmpty(fields)) {
            return Collections.emptyList();
        }

        return fields.stream().map(field -> {
            FieldResponse fieldRes = new FieldResponse();
            fieldRes.setType(field.getType());
            fieldRes.setTitle(field.getTitle());

            FieldProps fieldProps = fieldPropsMapper.selectOne(new LambdaQueryWrapper<FieldProps>()
                    .eq(FieldProps::getFieldId, field.getId())
                    .eq(FieldProps::getDeleteStatus, Boolean.FALSE));
            // 字段没有配置，则返回空
            if (Objects.isNull(fieldProps)) {
                return null;
            }

            fieldRes.setProps(BeanCopier.copy(fieldProps, new FieldPropsResponse()));
            return fieldRes;
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }

    /**
     * FormSaveRequest -> Form
     */
    private Form convert(FormSaveRequest request) {
        return BeanCopier.copy(request, new Form());
    }

    /**
     * FormSaveRequest -> Form
     */
    private FormResponse convert(Form form) {
        return BeanCopier.copy(form, new FormResponse());
    }
}
