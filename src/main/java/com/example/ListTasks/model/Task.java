package com.example.ListTasks.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data                                                           // автогенерация геттеров, сеттеров, toString
@Entity                                                         // определяет сущность проекта
// @Table(name = "Tasks")                                          // явно указываем на название таблицы в БД
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)         //авто генерация ID-шника
    private Long id;
    @Column(nullable = false, length = 500)                                   // поле обязательно должно быть заполнено
    private String titleTask;
    @Column(nullable = false)                                // аннотация позволяет настраивать способ сохранения и загрузки enum-значений из базы данных при использовании JPA
    private TaskStatus taskStatus;
    @Column(name = "dateTimeCreateTask", nullable = false)
    private LocalDateTime dateTimeCreateTask;


    public Task() {
    }

    public Task(Task task) {
        if (task.getTitleTask() != null)
            this.titleTask = task.getTitleTask();
        if (task.taskStatus == null)
            this.taskStatus = TaskStatus.NOT_STARTED;
        else this.taskStatus = task.getTaskStatus();
        if (task.dateTimeCreateTask == null)
            this.dateTimeCreateTask = LocalDateTime.now();
        else this.dateTimeCreateTask = task.dateTimeCreateTask;
    }

}
