package pl.km.weatherapp;

import pl.km.weatherapp.openweather.OpenWeatherDto;

public class WeatherDtoMapper {

    public static WeatherDto map(OpenWeatherDto openWeather) {
        WeatherDto weatherDto = new WeatherDto();
        weatherDto.setCity(openWeather.getName());
        weatherDto.setDescription(openWeather.getWeather().get(0).getDescription());
        weatherDto.setTemp(Double.parseDouble(openWeather.getMain().get("temp")));
        weatherDto.setFeelsLike(Double.parseDouble(openWeather.getMain().get("feels_like")));
        weatherDto.setPressure(Double.parseDouble(openWeather.getMain().get("pressure")));
        weatherDto.setHumidity(Double.parseDouble(openWeather.getMain().get("humidity")));
        weatherDto.setVisibility(openWeather.getVisibility());
        weatherDto.setWindSpeed(Double.parseDouble(openWeather.getWind().get("speed")));
        weatherDto.setWindDirection(Integer.parseInt(openWeather.getWind().get("deg")));
        weatherDto.setCloudiness(Integer.parseInt(openWeather.getClouds().get("all")));
        return weatherDto;
    }
}
