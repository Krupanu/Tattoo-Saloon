package com.example.tattoosalon.repository;

import com.example.tattoosalon.model.Role;
import com.example.tattoosalon.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User getUsersById(Long id);

    User getUsersByIdAndRole(Long id, Role role);

}


