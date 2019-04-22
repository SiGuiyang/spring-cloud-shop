package quick.pager.shop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import quick.pager.shop.client.AuthClient;
import quick.pager.shop.resp.Response;
import quick.pager.shop.dto.UserDTO;


@Service
public class UserService implements UserDetailsService {

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
        Response<Set<String>> roleResponse = authClient.getRolesBySysUserId(sysUser.getId());
        Set<String> permissions = roleResponse.getData();
        permissions.forEach(permission -> grantedAuthorities.add(new SimpleGrantedAuthority(permission)));

        return new User(username, sysUser.getPassword(), grantedAuthorities);
    }


}
