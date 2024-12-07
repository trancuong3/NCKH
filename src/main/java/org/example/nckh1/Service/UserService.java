package org.example.nckh1.Service;

import org.example.nckh1.Model.Roles;
import org.example.nckh1.Model.Users;
import org.example.nckh1.Repository.RoleRepository;
import org.example.nckh1.Repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public void registerUser(Users user) {
        // Kiểm tra xem tên đăng nhập đã tồn tại hay chưa
        if (userRepository.findUserByUsername(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Tên đăng nhập đã tồn tại!");
        }

        // Lấy vai trò ROLE_USER từ cơ sở dữ liệu
        Roles role = roleRepository.findByRoleName("ROLE_USER")
                .orElseThrow(() -> new IllegalArgumentException("Vai trò không tồn tại!"));

        // Gán vai trò và mã hóa mật khẩu
        user.setRole(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Lưu người dùng vào cơ sở dữ liệu
        userRepository.save(user);
    }

    public Users getUserByUsername(String username) {
        return userRepository.findUserByUsername(username).orElse(null);
    }
    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
    public void updateUser(Users user) {
        userRepository.save(user);
    }
    public void saveUser(Users user) {
        userRepository.save(user);
    }
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    private boolean isPasswordEncrypted(String password) {
        return password != null && password.startsWith("$2a$");
}

    public boolean isPasswordCorrect(String currentPassword, String storedPassword) {
        return passwordEncoder.matches(currentPassword, storedPassword);
    }
    public void updatePassword(String username, String newPassword) {
        Users user = userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }
}
