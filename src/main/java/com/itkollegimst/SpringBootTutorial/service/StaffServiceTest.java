package com.itkollegimst.SpringBootTutorial.service;


import com.itkollegimst.SpringBootTutorial.entity.Staff;
import com.itkollegimst.SpringBootTutorial.repository.StaffRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class StaffServiceTest {

        @Autowired
        private StaffService staffService;
        @MockBean
        private StaffRepository staffReppsitory;

        @BeforeEach
        void setUp() {
            Staff staff = Staff.builder()
                    .staffFirstName("Dominik")
                    .staffLastName("Mitterer")
                    .staffId(1L)
                    .build();

            Mockito.when(staffReppsitory.findByStaffLastNameIgnoreCase("Mitterer"))
                    .thenReturn(staff);
        }
        @Test
        @DisplayName("Get Data based Valid Staff Name")
        public void whenValidStaffName_thenStaffShouldFound(){
            String staffLastName = "Mitterer";
            Staff found = staffService.fetchStaffByLastName(staffLastName);
            assertEquals(staffLastName, found.getStaffLastName());
        }

    }
