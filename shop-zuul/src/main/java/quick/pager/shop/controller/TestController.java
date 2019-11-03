package quick.pager.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping("/admin/test")
    @ResponseBody
    public String test() {
        return "SUCCESS";
    }

    @GetMapping("/")
    @ResponseBody
    public String index(){
        return "index";
    }

    @GetMapping("/home/test")
    @ResponseBody
    public String home(){
        return "home";
    }
}
