package com.new2.weatherappassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button lookup;
    EditText cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lookup = findViewById(R.id.lookup);
        cityName = findViewById(R.id.cityname);
        lookup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent detailActivity = new Intent(MainActivity.this,DetailActivity.class );

                detailActivity .putExtra ( "TextBox", cityName.getText().toString() );
                startActivity(detailActivity);

                
            }
        });


    }
}