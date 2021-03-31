package com.example.PhaseEnd.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.PhaseEnd.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>
{
	User findByUser(String user);
}