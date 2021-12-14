package kz.infinit.spring_course_stepik.service;

import kz.infinit.spring_course_stepik.model.User;


public interface UserService {

  Iterable<User> findAll();

  User create(User user);

  User getCurrentUser();


}
