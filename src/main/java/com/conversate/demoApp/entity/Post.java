package com.conversate.demoApp.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String postdate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String details;
}
