package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
    @RequestMapping("/register")
    public String Register() {
        return "register";
    }

    @RequestMapping("/registration")
    public String showRegistration() {
        return "registration";
    }
}
