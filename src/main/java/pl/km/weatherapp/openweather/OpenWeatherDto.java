package pl.km.weatherapp.openweather;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class OpenWeatherDto {
    Map<String, String> coord;
    List<Weather> weather;
    String base;
    Map<String, String> main;
    int visibility;
    Map<String, String> wind;
    Map<String, String> clouds;
    int dt;
    Map<String, String> sys;
    int timezone;
    int id;
    String name;
    int cod;
}