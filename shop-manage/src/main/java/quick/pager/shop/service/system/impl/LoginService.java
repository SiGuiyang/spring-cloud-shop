//package quick.pager.shop.manage.service.system.impl;
//
//import cn.hutool.crypto.SecureUtil;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import java.util.Objects;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import quick.pager.shop.constants.ResponseStatus;
//import quick.pager.shop.dto.BaseDTO;
//import quick.pager.shop.user.response.Response;
//import quick.pager.shop.service.IService;
//import quick.pager.shop.manage.param.LoginDTO;
//import SysUserMapper;
//import LoginResponse;
//import SysUser;
//
///**
// * 登陆服务
// *
// * @author siguiyang
// */
//@Service
//@Slf4j
//public class LoginService implements IService<LoginResponse> {
//
//    @Autowired
//    private SysUserMapper sysUserMapper;
//
//    @Override
//    public Response<LoginResponse> doService(BaseDTO dto) {
//
//        LoginDTO loginDTO = (LoginDTO) dto;
//
//        SysUser sysUser = new SysUser();
//        sysUser.setPhone(loginDTO.getPhone());
//        SysUser user = sysUserMapper.selectOne(new QueryWrapper<>(sysUser));
//
//        if (Objects.isNull(user)) {
//            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.USER_PHONE_NOT_EXISTS);
//        }
//
//        if (!SecureUtil.md5(loginDTO.getPassword()).equals(user.getPassword())) {
//            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.USER_ACCOUNT_PASSWORD_NOT_CORRECT);
//        }
//
//        Response<LoginResponse> response = new Response<>();
//        LoginResponse loginResponse = new LoginResponse();
//        loginResponse.setPhone(loginDTO.getPhone());
//        loginResponse.setUsername(user.getUsername());
//        response.setData(loginResponse);
//
//        return response;
//    }
//}
