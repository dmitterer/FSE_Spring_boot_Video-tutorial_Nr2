package com.itkollegimst.SpringBootTutorial.controller;

import com.itkollegimst.SpringBootTutorial.entity.Department;
import com.itkollegimst.SpringBootTutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {

        department = Department.builder()
                .departmentAddress("Imst")
                .departmentCode("IT-03")
                .departmentName("IT")
                .departmentId(1L)
                .build();
    }

    @Test
    void saveDepartment () throws Exception {
            Department inputDepartment = Department.builder()
                    .departmentAddress("Imst")
                    .departmentCode("IT-03")
                    .departmentName("IT")
                    .build();

            Mockito.when(departmentService.saveDepartment(inputDepartment))
                    .thenReturn(department);

        mockMvc.perform(post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"departmentName\":\"IT\",\n" +
                        "\t\"departmentAddress\":\"Imst\",\n" +
                        "\t\"departmentCode\":\"IT-03\"\n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    void fetchDepartmentById() {
    }
}