package com.example.nxtstayz.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String roomNumber;
    private String type;
    private double price;
    @ManyToOne
    @JoinColumn(name = "hotelid")
    private Hotel hotel;
}