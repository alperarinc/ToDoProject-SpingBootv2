package com.todoproject.v2.Business;

import com.todoproject.v2.DataAccess.ITaskDal;
import com.todoproject.v2.Entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class TaskManager implements ITaskService {

    private ITaskDal taskDal;

    @Autowired
    public TaskManager(ITaskDal taskDal) {

        this.taskDal = taskDal;
    }

    @Override
    @Transactional
    public List<Task> getAll() {

        return this.taskDal.getAll();
    }

    @Override
    @Transactional
    public void add(Task task) {
        this.taskDal.add(task);

    }

    @Override
    @Transactional
    public void delete(Task task) {
        this.taskDal.delete(task);

    }

    @Override
    public void update(Task task) {
        this.taskDal.update(task);
    }

    @Override
    public Task getById(int id) {
        return this.taskDal.getById(id);
    }

}
