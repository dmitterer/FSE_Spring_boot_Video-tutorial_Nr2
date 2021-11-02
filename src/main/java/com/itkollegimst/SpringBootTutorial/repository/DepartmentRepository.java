package com.itkollegimst.SpringBootTutorial.repository;

import com.itkollegimst.SpringBootTutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>  {

    public Department findByDepartmentName(String departmentName);
    public Department findByDepartmentNameIgnorCase(String departmentName);
}



