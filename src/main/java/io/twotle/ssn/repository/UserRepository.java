package io.twotle.ssn.repository;

import io.twotle.ssn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
