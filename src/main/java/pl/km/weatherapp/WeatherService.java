package pl.km.weatherapp;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.km.weatherapp.openweather.OpenWeatherDto;

@Service
public class WeatherService {
    static final String URL_START = "https://api.openweathermap.org/data/2.5/weather?q=";
    static final String URL_END = "&units=metric&lang=pl&appid=";
    static final String API_KEY = "e3e9a64d42500ec2b9b11e8dd441629c";

    public WeatherDto getWeatherInCity(String city) {
        RestTemplate restTemplate = new RestTemplate();
        String url = URL_START + city + URL_END + API_KEY;
        OpenWeatherDto response = restTemplate.getForObject(url, OpenWeatherDto.class);
//        WeatherDto weatherDto1 = new WeatherDto("Londyn", "zachmurzenie umiarkowane", 26.88, 27.67, 1015.0, 56.0, 10000, 4.63, 210, 57);
        return WeatherDtoMapper.map(response);
    }
}