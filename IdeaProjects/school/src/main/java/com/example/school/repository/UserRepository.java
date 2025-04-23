package com.example.school.repository;
import com.example.school.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
/*UserRepository kế thừa từ interface JpaRepository. JpaRepository là một
interface có sẵn trong Spring Data JPA, cung cấp sẵn các phương thức cơ bản
để thao tác với cơ sở dữ liệu (CRUD: Create, Read, Update, Delete).*/