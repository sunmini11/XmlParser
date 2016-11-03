package com.egco428.xmlparser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private String url1 = "http://api.openweathermap.org/data/2.5/weather?q=";
    private String url2 = "&mode=xml&appid=b994c35873c281b5257ad8edbf3c6dfb";
    private EditText location,country,temperature,humidity,pressure;
    private HandleXML obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        location = (EditText)findViewById(R.id.locInput);
        country = (EditText)findViewById(R.id.countryTxt);
        temperature = (EditText)findViewById(R.id.tempTxt);
        humidity = (EditText)findViewById(R.id.humidTxt);
        pressure = (EditText)findViewById(R.id.pressTxt);
    }

    public void openWeatherMethod(View view){
        String url = location.getText().toString();
        String finalUrl = url1 + url + url2;

        obj = new HandleXML(finalUrl);
        obj.fetchXML();
        while (obj.parsingComplete);
        country.setText(obj.getCountry());
        temperature.setText(obj.getTemperature());
        humidity.setText(obj.getHumidity());
        pressure.setText(obj.getPressure());


    }

}
