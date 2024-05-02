package com.project.library.repository;

import com.project.library.model.Blacklist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlackListRepository extends JpaRepository<Blacklist,Long> {
    Blacklist deleteByUserId(long userId);

    Long countByUserId(long userId);
}
