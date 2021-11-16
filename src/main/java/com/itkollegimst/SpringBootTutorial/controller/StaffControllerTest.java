package com.itkollegimst.SpringBootTutorial.controller;

import com.itkollegimst.SpringBootTutorial.controller.StaffController;
import com.itkollegimst.SpringBootTutorial.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


public class StaffControllerTest {

    @EnableWebMvc(StaffController.class)
    public class StaffControllerTest {

        @Autowired
        private MockMvc mockMvc;
        @MockMockBean
        private com.itkollegimst.SpringBootTutorial.service.StaffService StaffService;
        private Staff staff;

        @BeforeEach
        void setUp() {
            staff = staff.builder()
                    .staffFirstName("Dominik")
                    .staffLastName("Mitterer")
                    .staffId(1L)
                    .build();
        }

        @Test
        void saveStaff() throws Exception {
            staff inputStaff = staff.builder()
                    .StaffFirstName("Dominik")
                    .StaffLastName("Mitterer")
                    .build();

            Mockito.when(staffService.saveStaff(inputStaff))
                    .thenReturn(staff);

            //POST-Operation
            mockMvc.perform(post("/Staff")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\n" +
                            "\t\"StaffFirstName\":\"Dominik\",\n" +
                            "\t\"StaffLastName\":\"Mitterer\",\n" +
                            "}"))
                    .andExpect(status().isOk());
        }

    }

    @Test
    void fetchStaffById() throws Exception {
        Mockito.when(staffService.fetchStaffById(1L))
                .thenReturn(staff);
        //GET-Operation
        mockMvc.perform(get("/staff/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.staffLastName").value(staff.getSaffLastName()));
    }


}
