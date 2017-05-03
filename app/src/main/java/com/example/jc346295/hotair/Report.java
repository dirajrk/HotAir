package com.example.jc346295.hotair;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Report extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        //this should be declared in orders, so it won't be always declared here onCreate
        List<String> orders = new ArrayList<String>();
        orders.add("Order 1");
        orders.add("Order 2");


        Spinner spinner = (Spinner) findViewById(R.id.orderID);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, orders);
        spinner.setAdapter(spinnerArrayAdapter);
    }
}
