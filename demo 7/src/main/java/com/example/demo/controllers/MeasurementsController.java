package com.example.demo.controllers;

import com.example.demo.dto.MeasurementDTO;
import com.example.demo.dto.MeasurementResponse;
import com.example.demo.models.MeasurementModel;
import com.example.demo.services.MeasurementsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/measurements")
public class MeasurementsController {
    private final MeasurementsService measurementsService;
    private final ModelMapper modelMapper;

    @Autowired
    public MeasurementsController(MeasurementsService measurementsService, ModelMapper modelMapper) {
        this.measurementsService = measurementsService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public MeasurementResponse counting(@RequestBody MeasurementDTO measurementDTO){
        MeasurementModel measurementModel = convertToMeasurementModel(measurementDTO);
        MeasurementModel measurementModel1 = measurementsService.count(measurementModel);
        return convertToMeasurementResponse(measurementModel1);
    }

    private MeasurementResponse convertToMeasurementResponse(MeasurementModel measurementModel1) {
        return modelMapper.map(measurementModel1, MeasurementResponse.class);
    }

    private MeasurementModel convertToMeasurementModel(MeasurementDTO measurementDTO) {
        return modelMapper.map(measurementDTO, MeasurementModel.class);
    }
}
