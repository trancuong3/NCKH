package org.example.nckh1.controller;

import org.example.nckh1.model.TaskHistory;
import org.example.nckh1.Service.TaskHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/history")
public class History {

    private final TaskHistoryService historyService;

    @Autowired
    public History(TaskHistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping("")
    public String index(
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
            Model model) {

        List<TaskHistory> tasks;
        if (startDate != null && endDate != null) {
            tasks = historyService.getTasksBetweenDates(startDate, endDate);
        } else {
            tasks = historyService.getAllTasks(); // Assuming this method exists
        }

        model.addAttribute("tasks", tasks);
        return "history";
    }
}
