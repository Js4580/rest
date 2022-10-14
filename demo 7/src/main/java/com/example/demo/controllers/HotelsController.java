package com.example.demo.controllers;

import com.example.demo.dto.*;
import com.example.demo.models.HotelModel;
import com.example.demo.services.HotelsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/hotels")
public class HotelsController {
    private final HotelsService hotelsService;
    private final ModelMapper modelMapper;

    @Autowired
    public HotelsController(HotelsService hotelsService,
                            ModelMapper modelMapper) {
        this.hotelsService = hotelsService;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    public HotelResponse getAll() {
        return new HotelResponse(hotelsService.findAll()
                .stream()
                .map(this::convertToHotelRequest)
                .collect(Collectors.toList()));
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> save(@RequestBody HotelDTO hotelDTO) {
        HotelModel model = convertToHotelModel(hotelDTO);
        hotelsService.save(model);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    private HotelModel convertToHotelModel(HotelDTO hotelDTO) {
        return modelMapper.map(hotelDTO, HotelModel.class);
    }

    private HotelRequest convertToHotelRequest(HotelModel all) {
        return modelMapper.map(all, HotelRequest.class);
    }
}
