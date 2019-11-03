package quick.pager.shop.controller;

import java.security.Principal;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("authorizationRequest")
public class ZuulAuthController {

    @RequestMapping("/oauth/confirm_access")
    public String getAccessConfirmation(Map<String, Object> model, HttpServletRequest request) {
        // 获取用户名
        String userName = ((UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal())
                .getUsername();
        model.put("userName", userName);

        request.setAttribute("authorize", model);
        request.setAttribute("username", userName);
        return "authorize";
    }


    @GetMapping("/callback")
    @ResponseBody
    public Object callback(Principal principal, @RequestParam String code) {

        System.out.println(code);

        return "success";
    }

    @RequestMapping("/oauth/principal")
    @ResponseBody
    public Principal getPrincipal(Principal principal) {
        return principal;
    }

}
