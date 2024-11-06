package org.example.nckh1.controller.Admin.manage;

import org.example.nckh1.Service.UserService;
import org.example.nckh1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllUsers(Model model) {
        List<User> users = userService.findAllUsers();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        for (User user : users) {
            if (user.getCreatedAt() != null) {
                user.setFormattedDate(user.getCreatedAt().format(formatter));
            } else {
                user.setFormattedDate("N/A");
            }
        }
        model.addAttribute("users", users);
        return "Admin/users/users";
    }

    @GetMapping("/create")
    public String showCreateUserForm(Model model) {
        model.addAttribute("user", new User());
        return "Admin/users/create-user";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute User user) {

        user.setCreatedAt(LocalDateTime.now());
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String showEditUserForm(@PathVariable("id") long id, Model model) {
        User user = userService.findUserById(id);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        if (user.getCreatedAt() != null) {
            user.setFormattedDate(user.getCreatedAt().format(formatter));
        } else {
            user.setFormattedDate("N/A");
        }
        model.addAttribute("user", user);
        return "Admin/users/edit-user";
    }

    @PostMapping("/edit")
    public String updateUser(@ModelAttribute User user) {
        if (user.getUserId() == null) {
            throw new IllegalArgumentException("ID người dùng không được null");
        }

        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            User existingUser = userService.findUserById(user.getUserId());
            user.setPassword(existingUser.getPassword());
        }


        User existingUser = userService.findUserById(user.getUserId());
        if (user.getCreatedAt() == null) {
            user.setCreatedAt(existingUser.getCreatedAt());
        }
        userService.updateUser(user);
        return "redirect:/users";
    }
}
