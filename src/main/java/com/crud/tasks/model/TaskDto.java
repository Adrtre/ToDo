package com.crud.tasks.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TaskDto {

    private Long id;
    private String title;
    private String content;
}