package com.itkollegimst.SpringBootTutorial.repository;

import com.itkollegimst.SpringBootTutorial.entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;

public class StaffRepositoryTest {
    public class EmployeeRepositoryTest {

        @Autowired
        private StaffReppsitory staffReppsitory;

        @Autowired
        private TestEntityManager entityManager;

        @BeforeEach
        void setUp() {
            Staff staff = Employee.builder()
                    .staffFirstName("Dominik")
                    .staffLastName("Mitterer")
                    .build();

            entityManager.persist(staff);
        }

        @Test
        public void whenFindById_thenReturnStaff() {
            Staff staff = staffReppsitory.findById(1L).get();
            assertEquals(staff.getStaffLastName(), "Mitterer");
        }


    }

}
