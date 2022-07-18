package br.com.acbueno.quarkus.resource;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.jboss.resteasy.reactive.RestQuery;

import br.com.acbueno.quarkus.dao.WeatherForecast;
import br.com.acbueno.quarkus.service.WeatherForecastService;

@Path("/weather")
public class WeatherForecastResource {

    @Inject
    WeatherForecastService weatherForecastService;

    @GET
    public  WeatherForecast getForecast(@RestQuery String city, @RestQuery long daysInFuture) {
        long executionStart = System.currentTimeMillis();
        List<String> dailyForecasts = Arrays.asList(
                weatherForecastService.getDailyForecast(LocalDate.now().plusDays(daysInFuture), city),
                weatherForecastService.getDailyForecast(LocalDate.now().plusDays(daysInFuture +1L), city),
                weatherForecastService.getDailyForecast(LocalDate.now().plusDays(daysInFuture +2L), city));
        long executionEnd = System.currentTimeMillis();

        return new WeatherForecast(dailyForecasts, executionEnd - executionStart);
    }

}
