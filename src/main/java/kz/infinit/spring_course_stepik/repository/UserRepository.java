package kz.infinit.spring_course_stepik.repository;

import kz.infinit.spring_course_stepik.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

  Optional<User> findByLogin(String login);



}
