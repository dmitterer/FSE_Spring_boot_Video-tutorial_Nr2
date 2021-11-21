package com.itkollegimst.SpringBootTutorial.service;

import com.itkollegimst.SpringBootTutorial.entity.Staff;
import com.itkollegimst.SpringBootTutorial.error.StaffNotFoundException;
import com.itkollegimst.SpringBootTutorial.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService{
    @Autowired
    private StaffRepository staffRepository;

    @Override
    public Staff saveStaff(Staff staff) {

        return staffRepository.save(staff);
    }

    @Override
    public List<Staff> fetchStaffList() {

        return staffRepository.findAll();
    }

    @Override
    public Staff fetchStaffById(Long staffId) throws StaffNotFoundException {
        Optional<Staff> staff = staffRepository.findById(staffId);
        if(!staff.isPresent()){
            throw new StaffNotFoundException("Staff Not Available!");
        }else{
            return staff.get();
        }
    }

    @Override
    public void deleteStaffById(Long staffId) {
        staffRepository.deleteById(staffId);

    }

    @Override
    public Staff updateStaff(Long staffId, Staff staff) throws StaffNotFoundException {
        Optional<Staff> staffDatabase = staffRepository.findById(staffId);
        if (!staffDatabase.isPresent()) {
            throw new StaffNotFoundException("Staff Not Available!");
        }
        /**
         * Weitere Möglichkeit / Schreibweise
         * Staff staff = staffDatabase.get();
         */
        if (Objects.nonNull(staff.getStaffFirstName()) && !"".equalsIgnoreCase(staff.getStaffFirstName())) {
            staffDatabase.get().setStaffFirstName(staff.getStaffFirstName());
        }
        if (Objects.nonNull(staff.getStaffLastName()) && !"".equalsIgnoreCase(staff.getStaffLastName())) {
            staffDatabase.get().setStaffFirstName(staff.getStaffLastName());
        }
        return staffRepository.save(staffDatabase.get());
    }

    @Override
    public Staff fetchStaffByLastName(String staffLastName) {
        return staffRepository.findByStaffLastNameIgnoreCase(staffLastName);
    }

}
