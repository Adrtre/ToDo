package com.crud.tasks.controller;
import com.crud.tasks.domain.Task;
import com.crud.tasks.model.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final DbService service;
    private final TaskMapper taskMapper;

    @GetMapping
    public List<TaskDto> getTasks() {
        List<TaskDto> tasks = taskMapper.mapToTaskDtoList(service.getAllTasks());
        return tasks;
    }
    @GetMapping("/{taskId}") //  <--- to ta linijka zapmiętja wysłane na adora
    public ResponseEntity<TaskDto> getTaskById(@PathVariable("taskId") Long taskId) {
        Optional<Task> taskOptional = service.getTaskById(taskId);
        return taskOptional.map(task -> ResponseEntity.ok(taskMapper.mapToTaskDto(task)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {
        boolean deleted = service.deleteTaskById(taskId);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}

