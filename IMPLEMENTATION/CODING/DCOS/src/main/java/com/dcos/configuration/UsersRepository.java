package com.dcos.configuration;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcos.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

	Users findByEmail(String email);

}
