package com.itkollegimst.SpringBootTutorial.service;

import com.itkollegimst.SpringBootTutorial.entity.Staff;
import com.itkollegimst.SpringBootTutorial.error.StaffNotFoundException;
import com.itkollegimst.SpringBootTutorial.repository.StaffReppsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService{
    @Autowired
    private StaffReppsitory staffReppsitory;

    @Override
    public Staff saveStaff(Staff staff) {
        return staffReppsitory.save(staff);
    }

    @Override
    public List<Staff> fetchStaffList() {
        return staffReppsitory.findAll();
    }

    @Override
    public Staff fetchStaffById(Long staffId) throws StaffNotFoundException {
        Optional<Staff> staff = staffReppsitory.findById(staffId);
        if(!staff.isPresent()){
            throw new StaffNotFoundException(("Staff Not Available!"));
        }else{
            return staff.get();
        }
    }

    @Override
    public String deleteStaffById(Long staffId) {
        staffReppsitory.deleteById(staffId);
        return null;
    }

    @Override
    public Staff updateStaff(Long staffId, Staff staff) throws StaffNotFoundException {
        Optional<Staff> staffDatabase = staffReppsitory.findById(staffId);
        if (!staffDatabase.isPresent()) {
            throw new StaffNotFoundException("Staff Not Available!");
        }
        /**
         * Weitere Möglichkeit / Schreibweise
         * Staff Staff = StaffDatabase.get();
         */
        if (Objects.nonNull(staff.getStaffFirstName()) && !"".equalsIgnoreCase(staff.getStaffFirstName())) {
            staffDatabase.get().setStaffFirstName(staff.getStaffFirstName());
        }
        if (Objects.nonNull(staff.getStaffLastName()) && !"".equalsIgnoreCase(staff.getStaffLastName())) {
            staffDatabase.get().setStaffFirstName(staff.getStaffLastName());
        }
        return staffReppsitory.save(staffDatabase.get());
    }

    @Override
    public Staff fetchStaffByName(String staffLastName) {
        return staffReppsitory.findByStaffLastNameIgnoreCase(staffLastName);
    }

}
