package org.semiworld.demo.service;

import org.semiworld.demo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskService extends JpaRepository<Task, Long> {
}
