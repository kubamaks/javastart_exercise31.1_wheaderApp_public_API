package pl.km.weatherapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class ApiConnectionException extends RuntimeException {
    public ApiConnectionException(String message) {
        super(message);
    }

    public ApiConnectionException() {
    }
}
