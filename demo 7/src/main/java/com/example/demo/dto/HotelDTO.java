package com.example.demo.dto;

import com.example.demo.models.RoomType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelDTO {
    private double area;
    private int floor;
    private RoomType type;
}
