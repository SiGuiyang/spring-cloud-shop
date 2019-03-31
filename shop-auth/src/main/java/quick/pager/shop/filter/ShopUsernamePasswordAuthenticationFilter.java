package quick.pager.shop.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import quick.pager.shop.dto.UserDTO;

/**
 * 重写UsernamePasswordAuthenticationFilter#attemptAuthentication 方法，支持json方式登陆
 *
 * @author siguiyang
 */
public class ShopUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        if (MediaType.APPLICATION_JSON_UTF8_VALUE.equals(request.getContentType())
                || MediaType.APPLICATION_JSON_VALUE.equals(request.getContentType())) {

            ObjectMapper mapper = new ObjectMapper();
            try (InputStream is = request.getInputStream()) {
                UserDTO userDTO = mapper.readValue(is, UserDTO.class);
                UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                        userDTO.getUsername(), userDTO.getPassword());
                this.setDetails(request, authRequest);
                return this.getAuthenticationManager().authenticate(authRequest);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        } else {

            return super.attemptAuthentication(request, response);
        }
    }


}
