package com.example.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Serializable> {

}
