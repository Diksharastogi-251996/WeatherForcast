package com.new2.weatherappassignment.implementation.callback;


import com.new2.weatherappassignment.model.threehourforecast.ThreeHourForecast;

public interface ThreeHourForecastCallback{
    void onSuccess(ThreeHourForecast threeHourForecast);
    void onFailure(Throwable throwable);
}