package com.CarRentalUser.ApiConstant;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ApiRespones {

    private String id;
    private String fname;
    private String lname;
    private String email;
    private LocalDate dob;
    private String password;
   // private String auth;



}
