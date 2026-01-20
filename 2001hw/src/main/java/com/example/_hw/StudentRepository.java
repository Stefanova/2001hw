package com.example._hw;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface StudentRepository extends JpaRepository<Student,
        Long> {
    List<Student> findByTitleContaining(String title);
    List<Student> findByGrade(int grade);
}
