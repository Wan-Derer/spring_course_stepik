package kz.infinit.spring_course_stepik.controller;

import kz.infinit.spring_course_stepik.model.Task;
import kz.infinit.spring_course_stepik.repository.TaskRepository;
import kz.infinit.spring_course_stepik.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class TaskController {

  private final TaskRepository taskRepo;
  private final UserServiceImpl userService;

  @GetMapping("/tasks")
  public Iterable<Task> getAllTasks(){
    return taskRepo.findAllByUserId(userService.getCurrentUser().getId());
  }

  @GetMapping("/tasks/{id}")
  public Task getTaskById(@PathVariable Long id){
    Task task = taskRepo.findById(id).orElse(null);
    long userID = userService.getCurrentUser().getId();

    if (task != null && task.getUser().getId() != userID) task = null;

    return task;
  }

//  @GetMapping(value = {"/tasks", "/tasks/{id}"})
//  public List<Task> getTasks(@PathVariable(required = false) Long id){
//    if (id != null) {
//      List<Task> tasks = new ArrayList<>();
//      tasks.add(taskRepo.findById(id).orElse(null));
//      return tasks;
//    }
//    return (List<Task>) taskRepo.findAll();
//  }

  @PostMapping("/tasks")
  public Task createTask(@RequestBody Task task){
    task.setUser(userService.getCurrentUser());
    return taskRepo.save(task);
  }

  @PutMapping("/tasks/{id}")
  public Task updateTask(@PathVariable Long id, @RequestBody Task task){
    task.setId(id);
    task.setUser(userService.getCurrentUser());
    return taskRepo.save(task);
  }

  @PatchMapping("/tasks/{id}")
  public void markTaskAsDone(@PathVariable Long id, @RequestBody Task task){
    if (task.isDone()) taskRepo.markAsDone(id);
  }

  @PatchMapping("/tasks/{id}:mark-as-done")
  public void markTaskAsDone(@PathVariable Long id){
    taskRepo.markAsDone(id);
  }

  @DeleteMapping("/tasks/{id}")
  public void deleteTask(@PathVariable Long id){
    taskRepo.deleteById(id);
  }




}
