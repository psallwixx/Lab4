package com.example.demo.util;

import java.util.Map;

public class ConveniencePricing {
    public static final Map<String, Integer> PRICES = Map.of(
            "WiFi", 10,
            "Kitchen", 30,
            "Pool", 50,
            "SPA", 100
    );

    public static int getPrice(String convenience) {
        return PRICES.getOrDefault(convenience, 0); // Повертаємо 0, якщо зручність відсутня у словнику
    }
}
