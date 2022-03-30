package com.todoproject.v2.Business;

import com.todoproject.v2.DataAccess.ITaskDal;
import com.todoproject.v2.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class TaskManager implements ITaskService {
    private ITaskDal taskDal;

    @Autowired
    public TaskManager(ITaskDal taskDal){
        this.taskDal=taskDal;
    }

    @Override
    @Transactional
    public List<Task> getAll() {
        return null;
    }

    @Override
    @Transactional
    public void add(Task task) {

    }

    @Override
    @Transactional
    public void delete(Task task) {

    }

    @Override
    @Transactional
    public Task getById(int id) {
        return null;
    }
}
