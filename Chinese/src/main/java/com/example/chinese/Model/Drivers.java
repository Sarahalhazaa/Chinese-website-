package com.example.chinese.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Drivers {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer driverId ;

    @NotEmpty(message = "It must not be empty")
   @Column(columnDefinition = "varchar(20) not null ")
    private String name ;

    @NotEmpty(message = "It must not be empty")
    @Size(min = 5,message ="You must enter at least 5 characters" )
   @Column(columnDefinition = "varchar(20) not null unique")
    private String userName ;

    @NotEmpty(message ="It must not be empty" )
   @Column(columnDefinition = " varchar(10) not null")
    private String password ;

    @NotEmpty(message ="It must not be empty" )
    @Email
    @Column(columnDefinition = " varchar(40) not null unique ")
    private String email;

    @NotEmpty(message ="It must not be empty" )
    @Column(columnDefinition = " varchar(10) not null unique ")
    private String phoneNumber ;

    @NotNull(message = "It must not be empty")
   @Column(columnDefinition = " int not null ")
    private Integer age ;

    @NotNull(message = "It must not be empty")
    @Column(columnDefinition = "int")
    private Integer bonusBalance=0;



    private Integer deliveryOrders=0;


}
