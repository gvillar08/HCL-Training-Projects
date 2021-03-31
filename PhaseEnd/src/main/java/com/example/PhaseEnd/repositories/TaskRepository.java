package com.example.PhaseEnd.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.PhaseEnd.entities.Task;

public interface TaskRepository extends CrudRepository<Task, Integer>
{
	
}