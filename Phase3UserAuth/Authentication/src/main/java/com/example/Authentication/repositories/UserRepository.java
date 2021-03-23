package com.example.Authentication.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.Authentication.entities.*;

public interface UserRepository extends CrudRepository<Auth, Integer> {

}