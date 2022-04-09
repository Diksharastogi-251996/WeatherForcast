package com.new2.weatherappassignment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.new2.weatherappassignment.constant.Languages;
import com.new2.weatherappassignment.constant.Units;
import com.new2.weatherappassignment.currentweather.CurrentWeather;
import com.new2.weatherappassignment.implementation.OpenWeatherMapHelper;
import com.new2.weatherappassignment.implementation.callback.CurrentWeatherCallback;


public class DetailActivity extends AppCompatActivity {
    public static final String TAG = "my name";
    TextView detailCityName, weatherDecription, temperature, windSpeed, country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        fetchingId();

        Intent i = getIntent();
        String text = i.getStringExtra("TextBox");
        detailCityName.setText(text.toUpperCase());


        OpenWeatherMapHelper helper = new OpenWeatherMapHelper(getString(R.string.apikey_weather));
        helper.setUnits(Units.IMPERIAL);
        helper.setLanguage(Languages.ENGLISH);
        helper.getCurrentWeatherByCityName(text, new CurrentWeatherCallback() {
            @Override
            public void onSuccess(CurrentWeather currentWeather) {
                setText(currentWeather);
            }

            @Override
            public void onFailure(Throwable throwable) {
                detailCityName.setText("City Not Found");


                Toast.makeText(DetailActivity.this, "City not Found", Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void fetchingId() {
        detailCityName = findViewById(R.id.detailCityName);
        weatherDecription = findViewById(R.id.weatherDescription);
        temperature = findViewById(R.id.temprature);
        windSpeed = findViewById(R.id.windSpeed);
        country = findViewById(R.id.country);
    }

    private void setText(CurrentWeather currentWeather) {
        weatherDecription.setText("Weather is :-"+currentWeather.getWeather().get(0).getDescription());
        temperature.setText("Feels like :-"+currentWeather.getMain().getTempMax());
        windSpeed.setText("wind speed :-" + currentWeather.getWind().getSpeed());
        country.setText("You are in :- "+currentWeather.getSys().getCountry());
    }
}