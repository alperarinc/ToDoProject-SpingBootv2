package com.todoproject.v2.Business;
import com.todoproject.v2.Entities.*;

import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface ITaskService {
    List<Task> getAll();
    void add(Task task);
    void delete(Task task);
    void update(Task task);


    Task getById(int id);
}
