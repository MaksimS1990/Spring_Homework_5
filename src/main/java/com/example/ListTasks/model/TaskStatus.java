package com.example.ListTasks.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public enum TaskStatus {
    NOT_STARTED,
    IN_PROGRESS,
    COMPLETED;
}
