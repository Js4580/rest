package com.example.demo.services;

import com.example.demo.models.HotelModel;
import com.example.demo.repositories.HotelsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class HotelsService {
    private final HotelsRepository hotelsRepository;

    public HotelsService(HotelsRepository hotelsRepository) {
        this.hotelsRepository = hotelsRepository;
    }

    public List<HotelModel> findAll() {
        return hotelsRepository.findAll();
    }

    @Transactional
    public void save(HotelModel hotelModel) {
        hotelModel.setPrice(hotelModel.getType().getPrices());
        hotelsRepository.save(hotelModel);
    }

    public HotelModel find(int id) {
        return hotelsRepository.findById(id)
                .stream()
                .findAny()
                .orElse(null);
    }
}
