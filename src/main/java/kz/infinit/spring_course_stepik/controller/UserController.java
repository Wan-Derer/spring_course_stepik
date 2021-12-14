package kz.infinit.spring_course_stepik.controller;

import kz.infinit.spring_course_stepik.model.User;
import kz.infinit.spring_course_stepik.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

  private final UserServiceImpl userService;

  @GetMapping("/users")
  public Iterable<User> getAllUsers(){
    return userService.findAll();
  }

  @PostMapping("/users")
  public User createUser(@RequestBody User user){
    System.out.println(user);
    return userService.save(user);
  }

}
