package com.example.jc346295.hotair;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class LoginActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



    }
    protected void onClick(View view){
        Button button = (Button) findViewById(R.id.button);
        //both these variables are placeholders
        String userID = "";
        String userPass = "";
        if (view == button){
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("ID",userID);
            intent.putExtra("Pass",userPass);
            startActivity(intent);
        }
    }
}

