package org.example.nckh1.Repository;

import org.example.nckh1.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    // Phương thức tìm người dùng theo tên đăng nhập
    Optional<Users> findUserByUsername(String username);

    // Thêm phương thức tìm người dùng theo email (nếu cần)
    Optional<Users> findUserByEmail(String email);
}
