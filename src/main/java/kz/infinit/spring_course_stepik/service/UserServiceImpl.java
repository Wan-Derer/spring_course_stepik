package kz.infinit.spring_course_stepik.service;

import kz.infinit.spring_course_stepik.model.User;
import kz.infinit.spring_course_stepik.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepo;
  private final PasswordEncoder passwordEncoder;

  @Override
  public Iterable<User> findAll() {
    return userRepo.findAll();
  }

  @Override
  public User create(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepo.save(user);
  }

  @Override
  public User getCurrentUser() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    org.springframework.security.core.userdetails.User principal =
      (org.springframework.security.core.userdetails.User) auth.getPrincipal();

    return userRepo.findByLogin(principal.getUsername())
      .orElseThrow(()-> new IllegalArgumentException("user nor found / Пользователь не найден"));
  }
}
