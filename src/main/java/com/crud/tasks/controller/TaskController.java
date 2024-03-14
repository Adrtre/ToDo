package com.crud.tasks.controller;
import com.crud.tasks.domain.Task;
import com.crud.tasks.model.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/{taskId}") //  dopytaj
    public ResponseEntity<TaskDto> getTaskById(@PathVariable("taskId") Long taskId) {
        Optional<Task> taskOptional = service.getTaskById(taskId);
        return taskOptional.map(task -> ResponseEntity.ok(taskMapper.mapToTaskDto(task)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

