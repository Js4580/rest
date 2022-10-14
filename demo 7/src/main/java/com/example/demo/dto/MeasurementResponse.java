package com.example.demo.dto;

import com.example.demo.models.HotelModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeasurementResponse {
    private int countDays;
    private double finalPrice;
    private HotelModel hotelModel;
}
