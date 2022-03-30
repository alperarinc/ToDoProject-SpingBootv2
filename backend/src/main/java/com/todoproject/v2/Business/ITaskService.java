package com.todoproject.v2.Business;

import com.todoproject.v2.entity.*;


import java.util.List;

public interface ITaskService {
    List<Task> getAll();
    void add(Task task);
    void delete(Task task);
    Task getById(int id);


}
