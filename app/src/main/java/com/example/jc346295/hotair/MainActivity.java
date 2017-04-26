package com.example.jc346295.hotair;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton reportButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view){
        reportButton = (ImageButton) findViewById(R.id.reportButton);
        if (view == reportButton){
            Intent intent = new Intent(this, Report.class);
            startActivity(intent);
        }
    }
}
