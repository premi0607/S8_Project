package net.javaguides.springbootbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springbootbackend.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
    
}
