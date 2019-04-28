package com.example.tomatotimer.task;

import com.example.tomatotimer.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUser(User user);

    Optional<Task> findByUserAndId(User user, Long taskId);
}
