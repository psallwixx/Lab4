package com.example.demo.service;

import com.example.demo.model.House;
import com.example.demo.repository.HouseRepository;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "houses")
public class HouseService {
    private final HouseRepository houseRepository;

    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @Cacheable
    public List<House> getAllHouses() {
        return houseRepository.findAll();
    }

    public House createHouse(House house) {
        return houseRepository.save(house);
    }

    public House getHouseById(Long id) {
        return houseRepository.findById(id).orElseThrow(() -> new RuntimeException("House not found"));
    }

    public House updateHouse(Long id, House updatedHouse) {
        House house = getHouseById(id);
        house.setRoomType(updatedHouse.getRoomType());
        house.setMaxCountOfGuests(updatedHouse.getMaxCountOfGuests());
        house.setConveniences(updatedHouse.getConveniences());
        return houseRepository.save(house);
    }

    public void deleteHouse(Long id) {
        houseRepository.deleteById(id);
    }
}
