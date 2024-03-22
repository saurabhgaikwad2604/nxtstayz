package com.example.nxtstayz.model;

import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String location;
    private int rating;
}