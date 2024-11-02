package org.example.nckh1.repository;

import org.example.nckh1.model.TaskHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskHistoryRepository extends JpaRepository<TaskHistory, Integer> {
}
