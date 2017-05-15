package com.example.jc346295.hotair;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Report extends AppCompatActivity {
    private Spinner spinner;
    private Spinner issue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        //this should be declared in orders, so it won't be always declared here onCreate
        List<String> orders = new ArrayList<>();
        List<String> issue = new ArrayList<>();
        orders.add("Order 1");
        orders.add("Order 2");
        issue.add("Dead on arrival");
        issue.add("Wrong item");


        Spinner spinner = (Spinner) findViewById(R.id.orderID);
        Spinner issues = (Spinner) findViewById(R.id.reportID);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, orders);
        spinner.setAdapter(spinnerArrayAdapter);
        ArrayAdapter<String> issueArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, issue);
        issues.setAdapter(issueArrayAdapter);
    }

    public void onClick(){

    }


}