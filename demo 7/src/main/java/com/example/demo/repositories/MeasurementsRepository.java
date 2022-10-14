package com.example.demo.repositories;

import com.example.demo.models.MeasurementModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementsRepository extends JpaRepository<MeasurementModel, Integer> {
}
