package org.example.nckh1.controller;

import org.example.nckh1.Service.TaskHistoryService;
import org.example.nckh1.model.TaskHistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller

public class History {

    private final TaskHistoryService taskHistoryService;

    @Autowired
    public History(TaskHistoryService taskHistoryService) {
        this.taskHistoryService = taskHistoryService;
    }

    @RequestMapping("/history")
    public String index(Model model) {
        List<TaskHistory> taskHistoryList = taskHistoryService.getAllTaskHistory();
        model.addAttribute("taskHistoryList", taskHistoryList);
        return "history";
    }
}
