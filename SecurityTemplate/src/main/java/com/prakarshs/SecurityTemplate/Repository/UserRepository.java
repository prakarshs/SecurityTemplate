package com.prakarshs.SecurityTemplate.Repository;

import com.prakarshs.SecurityTemplate.Entity.UserEntity;
import com.prakarshs.SecurityTemplate.Enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserDetails> findByEmail(String username);
    UserEntity findByRole(Role role);
}
