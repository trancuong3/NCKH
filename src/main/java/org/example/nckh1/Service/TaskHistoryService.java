package org.example.nckh1.Service;

import org.example.nckh1.model.TaskHistory;
import org.example.nckh1.repository.TaskHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskHistoryService {

    private final TaskHistoryRepository taskHistoryRepository;

    @Autowired
    public TaskHistoryService(TaskHistoryRepository taskHistoryRepository) {
        this.taskHistoryRepository = taskHistoryRepository;
    }

    public List<TaskHistory> getAllTaskHistory() {
        return taskHistoryRepository.findAll();
    }
}
