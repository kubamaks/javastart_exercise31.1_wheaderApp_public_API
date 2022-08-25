package pl.km.weatherapp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class WeatherDto {

    private String city;
    private String description;
    private double temp;
    private double feelsLike;
    private double pressure;
    private double humidity;
    private int visibility;
    private double windSpeed;
    private int windDirection;
    private int cloudiness;
}
