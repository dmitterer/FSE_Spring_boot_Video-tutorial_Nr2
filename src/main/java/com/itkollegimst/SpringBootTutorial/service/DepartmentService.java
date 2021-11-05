package com.itkollegimst.SpringBootTutorial.service;

import com.itkollegimst.SpringBootTutorial.entity.Department;
import com.itkollegimst.SpringBootTutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

   public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

       public void deleteDepartmentById(Long departmentId);

   public Department updateDepartment(Long departmentId, Department department);

    Department fetchDepartmentByName(String departmentName);


}
