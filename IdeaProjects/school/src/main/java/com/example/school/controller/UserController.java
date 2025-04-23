package com.example.school.controller;

import com.example.school.model.User;
import com.example.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController// trả về dạng json
@RequestMapping("/users")//đánh dấu class này là 1 controller

public class UserController {
    @Autowired /*được sử dụng để tiêm (inject) các dependency vào các thành phần khác.
    Khi bạn đánh dấu một thuộc tính bằng @Autowired, Spring Boot sẽ tự động tiêm một
    instance của dependency tương ứng vào thuộc tính đó.*/
    private UserService userService;

    @GetMapping//read
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")//read
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping//create
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")//update
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }
/*@RequestBody dùng để ánh xạ (map) dữ liệu JSON từ phần body của HTTP request
thành một đối tượng Java.
Spring Boot sẽ:
Đọc JSON trong body
Chuyển thành đối tượng User
Gán vào tham số user*/
/*@PathVariable dùng để lấy giá trị từ URL path (đường dẫn) và gán vào biến trong
phương thức.
Spring Boot sẽ:
Lấy giá trị 5 trong URL
Gán vào biến id*/
    @DeleteMapping("/{id}")//delete
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }
}
