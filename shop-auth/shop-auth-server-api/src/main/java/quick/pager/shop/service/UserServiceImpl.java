package quick.pager.shop.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import quick.pager.shop.client.AuthClient;
import quick.pager.shop.dto.UserDTO;
import quick.pager.shop.resp.Response;

/**
 * 查询用户权限
 *
 * @author siguiyang
 * @version 3.0
 */
@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private AuthClient authClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Response<UserDTO> sysUserResponse = authClient.getSysUser(username);
        if (null == sysUserResponse || null == sysUserResponse.getData()) {
            throw new UsernameNotFoundException("用户不存在");
        }

        UserDTO sysUser = sysUserResponse.getData();

        List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
        Response<List<String>> roleResponse = authClient.getRolesBySysUserId(sysUser.getId());

        if (200 == roleResponse.getCode()) {
            grantedAuthorities = Optional.ofNullable(roleResponse.getData()).orElse(Collections.emptyList()).stream()
                    .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        }

        return new User(username, sysUser.getPassword(), grantedAuthorities);
    }


}
