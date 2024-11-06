package org.example.nckh1.Repository;

import org.example.nckh1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}