package com.itkollegimst.SpringBootTutorial.service;

import com.itkollegimst.SpringBootTutorial.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

   public List<Department> fetchDepartmentList();

    public Department fetDepartmentById(Long departmentId);

       public void deleteDepartmentById(Long departmentId);

   public Department updateDepartment(Long departmentId, Department department);
}
