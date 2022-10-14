package com.example.demo.repositories;

import com.example.demo.models.HotelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelsRepository extends JpaRepository<HotelModel, Integer> {
}
