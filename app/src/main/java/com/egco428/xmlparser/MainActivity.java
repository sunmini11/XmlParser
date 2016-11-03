package com.egco428.xmlparser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText display,url;
    private JsonParser obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = (EditText)findViewById(R.id.displayTxt);
        url = (EditText)findViewById(R.id.urlTxt);



    }

    public void openWeatherMethod(View view){
        String url = location.getText().toString();

        obj = new JsonParser(finalUrl);
        obj.fetchJSON();
        while (obj.parsingComplete);
        country.setText(obj.getCountry());

        humidity.setText(obj.getHumidity());
        pressure.setText(obj.getPressure());


        float kelvin = Float.parseFloat(obj.getTemperature());
        float cel = kelvin-273;
        DecimalFormat format = new DecimalFormat("0.00");
        temperature.setText(String.valueOf(format.format(cel)));
    }

}
