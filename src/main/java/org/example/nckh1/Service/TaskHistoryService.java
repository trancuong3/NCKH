package org.example.nckh1.Service;

import org.example.nckh1.model.TaskHistory;
import org.example.nckh1.Repository.TaskHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskHistoryService {

    private final TaskHistoryRepository taskHistoryRepository;

    @Autowired
    public TaskHistoryService(TaskHistoryRepository taskHistoryRepository) {
        this.taskHistoryRepository = taskHistoryRepository;
    }

    // Method to get all tasks
    public List<TaskHistory> getAllTasks() {
        return taskHistoryRepository.findAll();
    }

    public List<TaskHistory> getTasksBetweenDates(Date startDate, Date endDate) {
        return taskHistoryRepository.findByPerformedDateBetween(startDate, endDate);
    }
}
