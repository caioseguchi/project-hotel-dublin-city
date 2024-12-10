package com.springmvcapp.service;

import com.springmvcapp.model.ForecastData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherService {

    private static final String API_URL = "https://api.openweathermap.org/data/2.5/forecast";
    private static final String API_KEY = "53c9368ebebf34096693584dfdda8aec";
    private static final double LATITUDE = 53.3498;
    private static final double LONGITUDE = -6.2603;
    private static final String UNITS = "metric"; // Para graus Celsius
    private static final String LANG = "en"; // Idioma (en para inglês)

    public ForecastData getWeatherForecast() {
        RestTemplate restTemplate = new RestTemplate();

        String url = UriComponentsBuilder.fromHttpUrl(API_URL)
                .queryParam("lat", LATITUDE)
                .queryParam("lon", LONGITUDE)
                .queryParam("appid", API_KEY)
                .queryParam("units", UNITS)
                .queryParam("lang", LANG)
                .toUriString();

        return restTemplate.getForObject(url, ForecastData.class);
    }
}

