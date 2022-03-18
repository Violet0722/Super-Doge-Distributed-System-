package com.safedelivery.service;

import com.safedelivery.models.WeatherResponse;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WeatherService {

    public static String getCurrentWeather() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 3);

        String url = "https://api.open-meteo.com/v1/forecast?latitude=53.3441&longitude=-6.2675&daily=weathercode&timezone=Eire";
        RestTemplate restTemplate = new RestTemplate();
        WeatherResponse weatherResponse = restTemplate.getForObject(url, WeatherResponse.class);

        Integer currentWeatherCode = Integer.valueOf(weatherResponse.getDaily().getWeathercode()[0]);

        if (currentWeatherCode >= 90) {
            //Thunderstorm
            c.add(Calendar.DATE, 7);
        } else if (currentWeatherCode >= 50 && currentWeatherCode < 90) {
            //snow or rain
            c.add(Calendar.DATE, 5);
        } else if (currentWeatherCode >= 10 && currentWeatherCode < 50) {
            //frog
            c.add(Calendar.DATE, 3);
        } else if (currentWeatherCode >= 0 && currentWeatherCode < 10) {
            //clear
            c.add(Calendar.DATE, 2);
        }

        return dateFormat.format(c.getTime());
    }
}
