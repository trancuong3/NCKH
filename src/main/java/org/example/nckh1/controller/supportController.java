package org.example.nckh1.controller;

import org.example.nckh1.model.Weather;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/support")
public class supportController {
    @GetMapping("")
    public String index() {
        return "Home/support";
    }
}
