package org.example.nckh1.Controller;

import org.example.nckh1.Model.Users;
import org.example.nckh1.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")

public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String signup(Model model) {
        model.addAttribute("user", new Users());
        return "signup";
    }

    @PostMapping("")
    public String createUser(Users user, Model model) {
        try {
            userService.registerUser(user);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "signup";
        }
        return "redirect:/login";
    }

}
