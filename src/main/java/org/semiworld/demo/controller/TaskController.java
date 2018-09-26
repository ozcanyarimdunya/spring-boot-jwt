package org.semiworld.demo.controller;

import org.semiworld.demo.model.Task;
import org.semiworld.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> get() {
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public Task get(@PathVariable Long id) {
        return taskService.getOne(id);
    }

    @PostMapping
    public void add(@RequestBody Task task) {
        taskService.save(task);
    }

    @PutMapping("/{id}")
    public void edit(@PathVariable Long id, @RequestBody Task task) {
        Task existingTask = taskService.getOne(id);
        Assert.notNull(existingTask, "Task not found.");
        existingTask.setDescription(task.getDescription());
        taskService.save(existingTask);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskService.deleteById(id);
    }

}
