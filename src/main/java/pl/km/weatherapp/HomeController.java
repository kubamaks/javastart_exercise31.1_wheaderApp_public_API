package pl.km.weatherapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.km.weatherapp.exceptions.ApiConnectionException;
import pl.km.weatherapp.exceptions.CityNotFoundException;

@Controller
public class HomeController {
    private final WeatherService weatherService;

    public HomeController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String home(Model model,
                       @RequestParam(required = false, name = "city") String city) {
        if (city != null && !city.equals("")) {
            try {
                WeatherDto currentWeather = weatherService.getWeatherInCity(city);
                model.addAttribute("weather", currentWeather);
            } catch (CityNotFoundException e) {
                model.addAttribute("message", "Miasta " + city + " nie ma w naszej bazie meteo." +
                        " Podaj inne dane");
            } catch (Exception e) {
                throw new ApiConnectionException();
            }
        }
        return "index";
    }
}
