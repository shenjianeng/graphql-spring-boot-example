package com.example._04_.repository;

import com.example._04_.pojo.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("select min(id) from Student")
    Integer findMinId();

    @Query("select max(id) from Student")
    Integer findMaxId();

    List<Student> findByIdGreaterThan(Integer id, Pageable pageable);
}
