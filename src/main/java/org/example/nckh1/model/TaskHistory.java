package org.example.nckh1.model;

import jakarta.persistence.*;


import java.util.Date;

@Entity
@Table(name = "tasks_history")
public class TaskHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskId;

    private int userId;
    private int cropId;
    private int adviceId;

    @Column(name = "task_type")
    private String taskType;

    private String status;

    @Column(name = "performed_date")
    private Date performedDate;

    @Column(name = "created_at")
    private Date createdAt;

    public TaskHistory(int taskId, int userId, int cropId, int adviceId, String taskType, String status, Date performedDate, Date createdAt) {
        this.taskId = taskId;
        this.userId = userId;
        this.cropId = cropId;
        this.adviceId = adviceId;
        this.taskType = taskType;
        this.status = status;
        this.performedDate = performedDate;
        this.createdAt = createdAt;
    }

    public TaskHistory() {
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCropId() {
        return cropId;
    }

    public void setCropId(int cropId) {
        this.cropId = cropId;
    }

    public int getAdviceId() {
        return adviceId;
    }

    public void setAdviceId(int adviceId) {
        this.adviceId = adviceId;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPerformedDate() {
        return performedDate;
    }

    public void setPerformedDate(Date performedDate) {
        this.performedDate = performedDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
