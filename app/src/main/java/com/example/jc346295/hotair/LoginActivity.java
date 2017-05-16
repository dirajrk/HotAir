package com.example.jc346295.hotair;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LoginActivity extends AppCompatActivity {
    private Database userCred;
    private Button button;
    private EditText userName;
    private EditText userPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button = (Button) findViewById(R.id.button);

    }

    public void onClick(View view){
        userName = (EditText) findViewById(R.id.userEmail);
        userPass = (EditText) findViewById(R.id.userPassword);
        String input1 = userName.getText().toString();
        String input2 = userPass.getText().toString();
        Set<String> VALUES = new HashSet<String>(Arrays.asList(
                new String[] {"nathanael","fadni","diraj","test1"}
        ));
        if(view == button){
            if (VALUES.contains(input1)){
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
            else {
                new AlertDialog.Builder(view.getContext())
                        .setTitle("No username")
                        .setMessage("You're not cool enough to be in the database!")
                        .show();
            }
        }
    }
}