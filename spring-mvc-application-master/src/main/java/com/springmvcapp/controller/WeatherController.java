package com.springmvcapp.controller;

import com.springmvcapp.DTO.WeatherDTO;
import com.springmvcapp.model.ForecastData;
import com.springmvcapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/client-weather")
    public String getWeather(Model model) {
        ForecastData forecast = weatherService.getWeatherForecast();
        if (forecast != null && !forecast.getList().isEmpty()) {
            // Usar a primeira previsão como exemplo
            ForecastData.Forecast today = forecast.getList().get(0);
            model.addAttribute("weather", new WeatherDTO(
                    today.getWeather().get(0).getDescription(),
                    today.getMain().getTemp(),
                    today.getWeather().get(0).getIcon()
            ));
        } else {
            model.addAttribute("weather", null);
        }
        return "client-weather";
    }
}

