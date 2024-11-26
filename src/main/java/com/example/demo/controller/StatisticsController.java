package com.example.demo.controller;

import com.example.demo.service.StatisticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {
    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/income")
    public int getTotalIncome() {
        return statisticsService.calculateTotalIncome();
    }

    @GetMapping("/expenses")
    public int getTotalExpenses() {
        return statisticsService.calculateTotalExpenses();
    }
}
