package com.itkollegimst.SpringBootTutorial.controller;


import com.itkollegimst.SpringBootTutorial.entity.Staff;
import com.itkollegimst.SpringBootTutorial.service.StaffService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(StaffController.class)
public class StaffControllerTest {

        @Autowired
        private MockMvc mockMvc;
        @MockBean
        private StaffService staffService;
        private Staff staff;

        @BeforeEach
        void setUp(){
            staff = Staff.builder()
                    .staffFirstName("Dominik")
                    .staffLastName("Mitterer")
                    .staffId(1L)
                    .build();
        }

          @Test
             void saveStaff() throws Exception {
                 Staff inputStaff = Staff.builder()
                       .staffFirstName("Dominik")
                        .staffLastName("Mitterer")
                         .build();

                  Mockito.when(staffService.saveStaff(inputStaff))
                          .thenReturn(staff);

            //POST-Operation
            mockMvc.perform(post("/staff")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\n" +
                            "\t\"StaffFirstName\":\"Dominik\",\n" +
                            "\t\"StaffLastName\":\"Mitterer\",\n" +
                            "}"))
                    .andExpect(status().isOk());
        }

   @Test
    void fetchStaffById() throws Exception {
        Mockito.when(staffService.fetchStaffById(1L))
                .thenReturn(staff);
        //GET-Operation
        mockMvc.perform(get("/staff/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.staffLastName").value(staff.getStaffLastName()));

   }


}
