package com.todoproject.v2.RestApi;

import com.todoproject.v2.Business.ITaskService;
import com.todoproject.v2.Entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TaskController {

    private ITaskService taskService;

    @Autowired
    public TaskController(ITaskService taskService) {

        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> get(){

        return taskService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody Task task){

        taskService.add(task);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Task task){

        taskService.delete(task);
    }

    @PostMapping("/update")
    public void update(@RequestBody Task task){

        taskService.update(task);
    }

    @GetMapping("/tasks/{id}")
    public Task getById(@PathVariable int id){

        return taskService.getById(id);
    }



}
