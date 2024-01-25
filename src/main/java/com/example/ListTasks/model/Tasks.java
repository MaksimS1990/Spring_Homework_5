package com.example.ListTasks.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data                                                           // автогенерация геттеров, сеттеров, toString
@Entity                                                         // определяет сущность проекта
@Table(name = "Tasks")                                          // явно указываем на название таблицы в БД
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)         //авто генерация ID-шника
    private Long id;
    @Column(nullable = false)                                   // поле обязательно должно быть заполнено
    private String titleTask;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)                                // аннотация позволяет настраивать способ сохранения и загрузки enum-значений из базы данных при использовании JPA
    private TaskStatus taskStatus;
    @Column(nullable = false)
    private LocalDateTime dateTimeCreateTask = LocalDateTime.now();

}
