package com.project.library.repository;

import com.project.library.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository  extends JpaRepository<Users,Long> {

    Users findByName(String name);

}
