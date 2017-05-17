package com.example.jc346295.hotair;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LoginActivity extends AppCompatActivity {
    private Button button;
    private EditText userName;
    private EditText userPass;
    public Map<String,String> users;


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
        Map<String,String> users = new Map<String, String>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(Object key) {
                return false;
            }

            @Override
            public boolean containsValue(Object value) {
                return false;
            }

            @Override
            public String get(Object key) {
                return null;
            }

            @Override
            public String put(String key, String value) {
                return null;
            }

            @Override
            public String remove(Object key) {
                return null;
            }

            @Override
            public void putAll(@NonNull Map<? extends String, ? extends String> m) {

            }

            @Override
            public void clear() {

            }

            @NonNull
            @Override
            public Set<String> keySet() {
                return null;
            }

            @NonNull
            @Override
            public Collection<String> values() {
                return null;
            }

            @NonNull
            @Override
            public Set<Entry<String, String>> entrySet() {
                return null;
            }
        };
        users.put("fadni", "123456");
        users.put("nathanael", "baygon");
        users.put("diraj", "1234");
        if(view == button){
            if (users.containsKey(input1) && users.get(input1).equals(input2)){
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                intent.putExtra("username", input1);
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