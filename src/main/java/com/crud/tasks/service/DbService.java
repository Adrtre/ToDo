package com.crud.tasks.service;


import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbService {

    private final TaskRepository repository;

    public List<Task> getAllTasks() {
        return (List<Task>) repository.findAll();
    }
    public Optional<Task> getTaskById(Long id) {
        return repository.findById(id);
    }
    public boolean deleteTaskById(Long taskId) {
        if (repository.existsById(taskId)) {
            repository.deleteById(taskId);
            return true;
        }
        return false;
    }

}