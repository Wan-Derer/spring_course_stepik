package kz.infinit.spring_course_stepik.repository;

import kz.infinit.spring_course_stepik.model.Task;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//@Repository
@Transactional
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

  @Modifying
  @Query("update Task set done = true where id = :id")
  void markAsDone(@Param("id") Long id);

  Iterable<Task> findAllByUserId (long userID);


}
