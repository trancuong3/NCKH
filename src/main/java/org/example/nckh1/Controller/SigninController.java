package org.example.nckh1.Controller;

import org.example.nckh1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class SigninController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            Model model) {

        if (error != null) {
            model.addAttribute("error", "Tên người dùng, mật khẩu không đúng hoặc tài khoản bị khóa");
        }

        return "login";
    }

}
