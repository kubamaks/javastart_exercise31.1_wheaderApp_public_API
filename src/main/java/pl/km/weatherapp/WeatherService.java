package pl.km.weatherapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.km.weatherapp.exceptions.ApiConnectionException;
import pl.km.weatherapp.exceptions.CityNotFoundException;
import pl.km.weatherapp.openweather.OpenWeatherDto;

@Service
public class WeatherService {
    static final String URL_START = "https://api.openweathermap.org/data/2.5/weather?q=";
    static final String URL_END = "&units=metric&lang=pl&appid=";
    static final String API_KEY = "e3e9a64d42500ec2b9b11e8dd441629c";

    public WeatherDto getWeatherInCity(String city) {
        RestTemplate restTemplate = new RestTemplate();
        String url = URL_START + city + URL_END + API_KEY;
        try {
            ResponseEntity<OpenWeatherDto> response = restTemplate.getForEntity(url, OpenWeatherDto.class);
            return WeatherDtoMapper.map(response.getBody());
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
                throw new CityNotFoundException("City not found");
            } else {
                throw new ApiConnectionException("Problem with connection occured");
            }
        }
    }
}