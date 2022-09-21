package com.conversate.demoApp.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String firstname;
    private String lastname;
    @ManyToOne (cascade = {CascadeType.ALL})
    @JoinColumn(name = "location_id")
    private Location location;
    private String email;
}
