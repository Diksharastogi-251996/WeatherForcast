package com.new2.weatherappassignment.implementation.callback;


import com.new2.weatherappassignment.currentweather.CurrentWeather;

public interface CurrentWeatherCallback{
    void onSuccess(CurrentWeather currentWeather);
    void onFailure(Throwable throwable);
}
