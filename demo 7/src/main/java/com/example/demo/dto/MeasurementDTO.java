package com.example.demo.dto;

import com.example.demo.models.HotelModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeasurementDTO {
    private int countDays;
    private HotelModel hotelModel;
}
