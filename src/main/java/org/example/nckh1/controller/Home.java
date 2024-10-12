// src/main/java/org/example/nckh1/controller/HomeController.java

package org.example.nckh1.controller;


import org.example.nckh1.model.Weather;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/home")
public class Home {

    @GetMapping("")
    public String index(Model model) {

        String userLogin = "Nguyen Van A";
        model.addAttribute("userLogin", userLogin);
        Weather weather = new Weather("28°C", "65%", "Nắng", "15 km/h");
        model.addAttribute("weather", weather);

        return "home";
    }
}
