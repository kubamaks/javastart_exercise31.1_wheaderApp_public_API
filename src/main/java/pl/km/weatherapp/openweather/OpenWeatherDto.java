package pl.km.weatherapp.openweather;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class OpenWeatherDto {
    private Map<String, String> coord;
    private List<Weather> weather;
    private String base;
    private Map<String, String> main;
    private int visibility;
    private Map<String, String> wind;
    private Map<String, String> clouds;
    private int dt;
    private Map<String, String> sys;
    private int timezone;
    private int id;
    private String name;
    private int cod;
}