package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "measurement")
@Getter
@Setter
public class MeasurementModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "final_price")
    private double finalPrice;
    @Column(name = "count_days")
    private int countDays;
    @ManyToOne
    @JoinColumn(name = "number", referencedColumnName = "id")
    private HotelModel hotelModel;
}
