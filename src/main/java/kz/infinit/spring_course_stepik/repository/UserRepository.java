package kz.infinit.spring_course_stepik.repository;

import kz.infinit.spring_course_stepik.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

//@Repository
@Transactional
public interface UserRepository extends PagingAndSortingRepository<User, Long> {



}
