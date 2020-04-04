package com.app.dialogfromservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button start_service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start_service = findViewById(R.id.start_service);

        start_service.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        Intent intent = new Intent(getBaseContext(), BackgroundDialogService.class);

        startService(intent);


    }
}
