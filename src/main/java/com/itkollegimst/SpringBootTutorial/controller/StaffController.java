package com.itkollegimst.SpringBootTutorial.controller;

import com.itkollegimst.SpringBootTutorial.entity.Staff;
import com.itkollegimst.SpringBootTutorial.error.StaffNotFoundException;
import com.itkollegimst.SpringBootTutorial.service.StaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StaffController {


    @Autowired
    private StaffService staffService;

    public final Logger LOGGER = LoggerFactory.getLogger(StaffController.class);

    @PostMapping("/staff")
    public Staff saveStaff(@Valid @RequestBody Staff staff){
        LOGGER.info("Inside saveStaff of StaffController");
        return staffService.saveStaff(staff);
    }

    @GetMapping("/staff")
    public List<Staff> fetchStaffList(){
        LOGGER.info("Inside fetchStaffList of StaffController");
        return staffService.fetchStaffList();
    }

    @GetMapping("/staff/{id}")
    public Staff fetchStaffById(@PathVariable("id") Long staffId) throws StaffNotFoundException {
        return staffService.fetchStaffById(staffId);
    }

    @DeleteMapping("/staff/{id}")
    public String deleteStaffById(@PathVariable("id") Long staffId){
        staffService.deleteStaffById(staffId);
        return "Staff deleted Successfully!";
    }

    @PutMapping("/staff/{id}")
    public Staff updateStaff(@PathVariable("id") Long staffId, @RequestBody Staff staff) throws StaffNotFoundException {
        return staffService.updateStaff(staffId, staff);
    }

    @GetMapping("/staff/name/{name}")
    public Staff fetchStaffByName(@PathVariable("name") String staffLastName){
        return staffService.fetchStaffByLastName(staffLastName);
    }
}



