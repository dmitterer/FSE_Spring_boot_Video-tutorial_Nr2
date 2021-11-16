package com.itkollegimst.SpringBootTutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Staff {


    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long StaffId;
    @NotBlank(message = "Please Add Firstname for Staff")
    private String staffFirstName;
    @NotBlank(message = "Please Add Lastname for Staff")
    private String staffLastName;

    //Entität: Department Referenzierung
    @ManyToOne
    private Department department;


}
