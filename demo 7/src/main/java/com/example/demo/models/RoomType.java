package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum RoomType {
    STANDARD(150),
    COMFORT(270),
    LUX(550),
    PRESIDENT(1300);
    private int prices;
}
