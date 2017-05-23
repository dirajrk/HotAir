package com.example.jc346295.hotair;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class HistoryActivity extends AppCompatActivity {

    ArrayAdapter<Java> stringArray;
    SharedPreferences preferences;
    TextView welcomeText;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        username = getIntent().getExtras().getString("username");
        welcomeText = (TextView) findViewById(R.id.welcomeText);
        welcomeText.setText(getString(R.string.order_history, username));
    }

    public void Home(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }

    protected void onStart(){
        super.onStart();

        stringArray = new ArrayAdapter<Java>(this, android.R.layout.simple_list_item_1);

        stringArray.add(new Java("Order ID : 13251882","Without lactose"));
        stringArray.add(new Java("Order ID : 12245923","Without milk"));

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(stringArray);

/*        Map<String,?> keys = preferences.getAll();
        for (Map.Entry<String,?> entry : keys.entrySet())
        {
            stringArray.add(new Java(entry.getKey(),entry.getValue().toString()));
        }
        */

    }

    public void location(View view){
        Intent intent = new Intent(this,NavActivity.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }

    public void track(View view){
        Intent intent = new Intent(this,TrackActivity.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }
    public void notif(View view){
        Intent intent = new Intent(this,NotifActivity.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }
    public void report(View view){
        Intent intent = new Intent(this,Report.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }
}
