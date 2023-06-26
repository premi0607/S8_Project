package net.javaguides.springbootbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "task_Holder")
    private String taskHolder;

    @Column(name = "task_Name")
    private String taskName;

    @Column(name = "task_Status")
    private String taskStatus;

    @Column(name = "task_Date")
    private String taskDate;

    public Task(){
         
    }
    public Task(String taskHolder, String taskName, String taskStatus, String taskDate) {
        super();
        this.taskHolder = taskHolder;
        this.taskName = taskName;
        this.taskStatus = taskStatus;
        this.taskDate = taskDate;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTaskHolder() {
        return taskHolder;
    }
    public void setTaskHolder(String taskHolder) {
        this.taskHolder = taskHolder;
    }
    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public String getTaskStatus() {
        return taskStatus;
    }
    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
    public String getTaskDate() {
        return taskDate;
    }
    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }

    
    

}
