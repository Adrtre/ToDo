package com.crud.tasks.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name")
    private String title;
    @Column(name = "description")
    private String content;


    public Task(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }


}