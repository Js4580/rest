package com.example.demo.dto;

import com.example.demo.models.RoomType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelRequest {
    private int id;
    private double area;
    private int floor;
    private RoomType type;
    private int price;
}
