package com.example.demo.services;

import com.example.demo.models.MeasurementModel;
import com.example.demo.repositories.MeasurementsRepository;
import com.example.demo.utils.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MeasurementsService {
    private final MeasurementsRepository measurementsRepository;
    private final HotelsService hotelsService;

    @Autowired
    public MeasurementsService(MeasurementsRepository measurementsRepository,
                               HotelsService hotelsService) {
        this.measurementsRepository = measurementsRepository;
        this.hotelsService = hotelsService;
    }

    @Transactional
    public MeasurementModel count(MeasurementModel measurementModel) {
        enrichMeasurement(measurementModel);

        int price = measurementModel.getHotelModel().getPrice();
        int countDays = measurementModel.getCountDays();
        double finalPrice = Calculator.calcul(price, countDays);

        measurementModel.setFinalPrice(finalPrice);

        measurementsRepository.save(measurementModel);

        return measurementModel;
    }

    private void enrichMeasurement(MeasurementModel measurementModel) {
        measurementModel.setHotelModel(hotelsService.find(measurementModel
                        .getHotelModel()
                        .getId()));
    }
}
