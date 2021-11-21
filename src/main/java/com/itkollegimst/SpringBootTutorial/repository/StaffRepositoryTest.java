package com.itkollegimst.SpringBootTutorial.repository;

import com.itkollegimst.SpringBootTutorial.entity.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StaffRepositoryTest {
    public class EmployeeRepositoryTest {

        @Autowired
        private StaffRepository staffRepository;

        @Autowired
        private TestEntityManager entityManager;

        @BeforeEach
        void setUp() {
            Staff staff = Staff.builder()
                    .staffFirstName("Dominik")
                    .staffLastName("Mitterer")
                    .build();

            entityManager.persist(staff);
        }

        @Test
        public void whenFindById_thenReturnStaff() {
            Staff staff = staffRepository.findById(1L).get();
            assertEquals(staff.getStaffLastName(), "Mitterer");
        }


    }

}
