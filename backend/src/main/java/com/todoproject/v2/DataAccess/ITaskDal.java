package com.todoproject.v2.DataAccess;

import com.todoproject.v2.Entities.Task;

import java.util.List;

public interface ITaskDal {
    List<Task> getAll();
    void add(Task task);
    void delete(Task task);
    void update(Task task);
    Task getById(int id);
}
