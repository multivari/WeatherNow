package top.gsfhyj.forecastify.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getCurrentWeather(String city) {
        String url = String.format("http://api.weatherapi.com/v1/current.json?key=%s&q=%s&aqi=no", apiKey, city);
        return restTemplate.getForObject(url, String.class);
    }
}
