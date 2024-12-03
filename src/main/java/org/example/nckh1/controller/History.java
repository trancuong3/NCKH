package org.example.nckh1.controller;

import org.example.nckh1.Service.TaskHistoryService;
import org.example.nckh1.model.TaskHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

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
            @RequestParam(value = "navigate", required = false) String navigate,
            Model model) {

        Calendar calendar = Calendar.getInstance();

        // Default to the current week's Monday if startDate is null
        if (startDate == null) {
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            startDate = calendar.getTime();
        }

        // Adjust the week based on navigation (previous/next)
        if ("previous".equals(navigate)) {
            calendar.setTime(startDate);
            calendar.add(Calendar.WEEK_OF_YEAR, -1);
            startDate = calendar.getTime();
        } else if ("next".equals(navigate)) {
            calendar.setTime(startDate);
            calendar.add(Calendar.WEEK_OF_YEAR, 1);
            startDate = calendar.getTime();
        }

        // Calculate end date as Sunday of the selected week
        calendar.setTime(startDate);
        calendar.add(Calendar.DAY_OF_YEAR, 6);
        Date endDate = calendar.getTime();

        List<TaskHistory> tasks = historyService.getTasksBetweenDates(startDate, endDate);

        Map<String, List<TaskHistory>> tasksByDay = tasks.stream()
                .collect(Collectors.groupingBy(task ->
                        new SimpleDateFormat("EEEE", Locale.ENGLISH).format(task.getPerformedDate())
                ));

        List<String> timeSlots = Arrays.asList("07:00", "09:00", "13:00", "15:00", "17:00");
        List<String> weekDays = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");

        // Generate a list of dates for the week
        List<String> weekDates = new ArrayList<>();
        calendar.setTime(startDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < 7; i++) {
            weekDates.add(dateFormat.format(calendar.getTime()));
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }

        // Prepare data for navigation buttons
        calendar.setTime(startDate);
        calendar.add(Calendar.WEEK_OF_YEAR, -1);
        Date previousStartDate = calendar.getTime();

        calendar.setTime(startDate);
        calendar.add(Calendar.WEEK_OF_YEAR, 1);
        Date nextStartDate = calendar.getTime();

        model.addAttribute("tasksByDay", tasksByDay);
        model.addAttribute("timeSlots", timeSlots);
        model.addAttribute("weekDays", weekDays);
        model.addAttribute("weekDates", weekDates);
        model.addAttribute("startDate", new SimpleDateFormat("yyyy-MM-dd").format(startDate));
        model.addAttribute("previousStartDate", new SimpleDateFormat("yyyy-MM-dd").format(previousStartDate));
        model.addAttribute("nextStartDate", new SimpleDateFormat("yyyy-MM-dd").format(nextStartDate));

        return "history";
    }
}
