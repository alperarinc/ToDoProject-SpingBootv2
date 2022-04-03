package com.todoproject.v2.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="task")
@Getter
@Setter
public class Task {

    public Task(int id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="title")
    private String title;

    @Column(name = "text")
    private String text;

    public Task() {

    }
}
