package kz.infinit.spring_course_stepik.service;

import kz.infinit.spring_course_stepik.model.User;
import kz.infinit.spring_course_stepik.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

  private final UserRepository userRepo;

  @Override
  public Iterable<User> findAll() {
    return userRepo.findAll();
  }

  @Override
  public User save(User user) {
    return userRepo.save(user);
  }
}
