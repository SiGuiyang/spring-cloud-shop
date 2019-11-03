package quick.pager.shop.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import quick.pager.shop.dto.MenuDTO;
import quick.pager.shop.dto.UserDTO;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Map<String, UserDetails> users = new ConcurrentHashMap<>();
    // 查询用户sql
    private static final String QUERY_USER_SQL = "select id, phone, username, password, avatar, create_time, delete_status from t_sys_user where phone = ?";
    // 查询用户角色sql
    private static final String QUERY_USER_ROLE_SQL = "SELECT\n" +
            "        m.id,\n" +
            "        m.name,\n" +
            "        m.sequence,\n" +
            "        m.parent_id AS parentId,\n" +
            "        m.path,\n" +
            "        m.hidden,\n" +
            "        m.component,\n" +
            "        m.redirect,\n" +
            "        m.icon,\n" +
            "        m.menu_type AS menuType,\n" +
            "        m.permission,\n" +
            "        m.permission_name AS permissionName FROM\n" +
            "        t_role_menu rm,\n" +
            "        t_menu m,\n" +
            "        t_role r,\n" +
            "        t_sys_user su,\n" +
            "        t_sys_role sr\n" +
            "    WHERE\n" +
            "        rm.menu_id = m.id\n" +
            "    AND rm.role_id = r.id\n" +
            "    AND sr.role_id = r.id\n" +
            "    AND sr.sys_user_id = su.id\n" +
            "    AND su.id = ? ORDER BY m.sequence ASC";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        String key = getKey(username);
        UserDetails result = users.get(key);
        if (null == result) {
            UserDTO userDTO = jdbcTemplate.queryForObject(QUERY_USER_SQL, new Object[]{username}, new BeanPropertyRowMapper<>(UserDTO.class));
            if (null != userDTO) {
                List<MenuDTO> menuDTOS = jdbcTemplate.query(QUERY_USER_ROLE_SQL, new BeanPropertyRowMapper<>(MenuDTO.class), userDTO.getId());

                Set<String> permissions = Optional.of(menuDTOS).orElse(Collections.emptyList()).stream().filter(menu -> !StringUtils.isEmpty(menu.getPermission())).map(MenuDTO::getPermission).collect(Collectors.toSet());

                List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();

                permissions.forEach(permission -> grantedAuthorities.add(new SimpleGrantedAuthority(permission)));
                // 生成UserDetails实现类
                result = new User(username, userDTO.getPassword(), grantedAuthorities);
            }
        }


        return result;
    }


    private String getKey(String username) {
        return username.toLowerCase();
    }


}
