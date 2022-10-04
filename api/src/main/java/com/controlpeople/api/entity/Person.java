package com.controlpeople.api.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "person")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Integer personId;

    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "phone")
    private Integer phone;
    @Column(name = "date")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;
    @Column(name = "amount")
    private Float amount;
    @Column(name = "active")
    private Boolean active;

}
