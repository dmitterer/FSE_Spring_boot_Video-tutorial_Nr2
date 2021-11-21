package com.itkollegimst.SpringBootTutorial.repository;


import com.itkollegimst.SpringBootTutorial.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {

    Staff findByStaffLastNameIgnoreCase(String staffLastName);
}
