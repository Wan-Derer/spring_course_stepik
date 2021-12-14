package kz.infinit.spring_course_stepik.service;


import kz.infinit.spring_course_stepik.model.User;
import kz.infinit.spring_course_stepik.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service("userDetailsService")
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository userRepo;

  @Override
  public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
    User user = userRepo.findByLogin(login)
      .orElseThrow(() ->new UsernameNotFoundException("user not found / Пользователь не найден"));

    return new org.springframework.security.core.userdetails.User(
      user.getLogin(), user.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("USER"))
    );
  }
}
