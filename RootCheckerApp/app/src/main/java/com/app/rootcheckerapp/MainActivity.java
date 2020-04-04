package com.app.rootcheckerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button check;
    private TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        check  = findViewById(R.id.check);
        status = findViewById(R.id.status);


        check.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        if (Helper.isRooted())
        {
            status.setBackgroundColor(Color.parseColor("#228B22"));
            status.setTextColor(Color.parseColor("#FFFFFF"));
            status.setText("Device is Rooted");

        }
        else
        {
            status.setTextColor(Color.parseColor("#FFFFFF"));
            status.setBackgroundColor(Color.parseColor("#B22222"));
            status.setText("Device is Not Rooted");
        }


    }
}
