package com.example.demo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "hotel")
@Getter
@Setter
@NoArgsConstructor
public class HotelModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "area")
    private double area;
    @Column(name = "floor")
    private int floor;
    @Enumerated(EnumType.STRING)
    private RoomType type;
    @Column(name = "price")
    private int price;
}
