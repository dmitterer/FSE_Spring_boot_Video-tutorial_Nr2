package com.itkollegimst.SpringBootTutorial.service;

import com.itkollegimst.SpringBootTutorial.entity.Staff;
import com.itkollegimst.SpringBootTutorial.error.StaffNotFoundException;

import java.util.List;

public interface StaffService {
    Staff saveStaff(Staff staff);

    List<Staff> fetchStaffList();

    Staff fetchStaffById(Long staffId) throws StaffNotFoundException;

    String deleteStaffById(Long staffId);

    Staff updateStaff(Long StaffId, Staff staff) throws StaffNotFoundException;

    Staff fetchStaffByName(String staffLastName);
}
