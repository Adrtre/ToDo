package com.crud.tasks.domain;

public class Task {
    private Long id;
    private String title;
    private String content;


    public Task(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }


}