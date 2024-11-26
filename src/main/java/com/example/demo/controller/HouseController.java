package com.example.demo.controller;

import com.example.demo.model.House;
import com.example.demo.service.HouseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/houses")
public class HouseController {
    private final HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping
    public List<House> getAllHouses() {
        return houseService.getAllHouses();
    }

    @GetMapping("/{id}")
    public House getHouseById(@PathVariable Long id) {
        return houseService.getHouseById(id);
    }

    @PostMapping
    public House createHouse(@RequestBody House house) {
        return houseService.createHouse(house);
    }

    @PutMapping("/{id}")
    public House updateHouse(@PathVariable Long id, @RequestBody House house) {
        return houseService.updateHouse(id, house);
    }

    @DeleteMapping("/{id}")
    public void deleteHouse(@PathVariable Long id) {
        houseService.deleteHouse(id);
    }
}
