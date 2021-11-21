package com.itkollegimst.SpringBootTutorial.service;

import com.itkollegimst.SpringBootTutorial.entity.Staff;
import com.itkollegimst.SpringBootTutorial.error.StaffNotFoundException;

import java.util.List;

public interface StaffService {
    Staff saveStaff(Staff staff);

    List<Staff> fetchStaffList();

    Staff fetchStaffById(Long staffId) throws StaffNotFoundException;

    void deleteStaffById(Long staffId);

    Staff updateStaff(Long staffId, Staff staff) throws StaffNotFoundException;

    Staff fetchStaffByLastName(String staffLastName);
}
