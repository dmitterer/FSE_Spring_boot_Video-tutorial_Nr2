package com.itkollegimst.SpringBootTutorial.service;


import com.itkollegimst.SpringBootTutorial.entity.Staff;
import com.itkollegimst.SpringBootTutorial.repository.StaffRepositoryTest;
import com.itkollegimst.SpringBootTutorial.repository.StaffReppsitory;
import org.springframework.beans.factory.annotation.Autowired;


@SpringBootTest
public class StaffServiceTest {

        @Autowired
        private StaffService staffService;
        @MockBean
        private StaffRepository staffReppsitory;

        @BeforeEach
        void setUp() {
            Staff employee = staff.builder()
                    .staffFirstName("Dominik")
                    .staffLastName("Mitterer")
                    .staffId(1L)
                    .build();

            Mockito.when(staffRepository.findByEmployeeLastNameIgnoreCase("Mitterer"))
                    .thenReturn(staff);
        }
        @Test
        @DisplayName("Get Data based Valid Staff Name")
        public void whenValidStaffName_thenStaffShouldFound(){
            String employeeLastName = "Mitterer";
            Staff found = staffService.fetchStaffByLastName(staffLastName);
            assertEquals(staffLastName, found.getStaffLastName());
        }

    }
