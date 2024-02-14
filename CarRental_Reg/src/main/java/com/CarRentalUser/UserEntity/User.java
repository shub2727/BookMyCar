package com.CarRentalUser.UserEntity;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(uniqueConstraints ={ @UniqueConstraint(columnNames = "email")})
public class User {
    @Id
    private String id;
    private String fname;
    private String lname;
    private String email;
    private LocalDate dob;
    private String password;


}
