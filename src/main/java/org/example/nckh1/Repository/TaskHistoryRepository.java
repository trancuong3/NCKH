package org.example.nckh1.Repository;

import org.example.nckh1.model.TaskHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TaskHistoryRepository extends JpaRepository<TaskHistory, Integer> {
    List<TaskHistory> findByPerformedDateBetween(Date startDate, Date endDate);
//    public List<TaskHistory> getTasksBetweenDates(Date startDate, Date endDate);
}
