package com.ra.web.repository;

import com.ra.web.model.entity.UserE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserERepository extends JpaRepository<UserE, String>{
}
