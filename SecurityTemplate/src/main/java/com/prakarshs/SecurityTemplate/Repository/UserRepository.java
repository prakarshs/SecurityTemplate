package com.prakarshs.SecurityTemplate.Repository;

import com.prakarshs.SecurityTemplate.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Integer, UserEntity> {
}
