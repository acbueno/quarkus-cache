package br.com.acbueno.quarkus.dao;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherForecast {

    private List<String> dailyForecasts;

    private long executionTimeInMs;



}
