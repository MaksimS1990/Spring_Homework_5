package com.example.ListTasks.service;

import com.example.ListTasks.model.Tasks;
import com.example.ListTasks.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor                                         //автогенерация конструктора
public class TaskService {

    private final TaskRepository repository;

    /**
     * Получить список всех задач
     * @return возвращает список задач
     */
    public List<Tasks> getAllTasks() {
        return repository.findAll();
    }

    /**
     * получить задачу по id
     * @param id идентификатор
     * @return возвращаем найденную задачу
     */
    public Optional<Tasks> getTasksById(Long id) {
        return repository.findById(id);
    }

    /**
     * создание задачи
     * @param tasks новая задача
     * @return сохраняем новую задачу
     */
    public Tasks createBook(Tasks tasks) {
        return repository.save(tasks);
    }

    /**
     * обновление задачи
     * @param id идентификатор
     * @param tasksDetails обновленная задача
     * @return сохраняем обновленную задачу
     */
    public Tasks updateTask(Long id, Tasks tasksDetails) {
        Optional<Tasks> optionalBook = repository.findById(id);
        if (optionalBook.isPresent()) {
            Tasks tasks = optionalBook.get();
            tasks.setTitleTask(tasksDetails.getTitleTask());
            tasks.setTaskStatus(tasksDetails.getTaskStatus());
            tasks.setDateTimeCreateTask(tasksDetails.getDateTimeCreateTask());
            return repository.save(tasks);
        } else {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }

    /**
     * удаление задачи по id
     * @param id идентификатор
     */
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
