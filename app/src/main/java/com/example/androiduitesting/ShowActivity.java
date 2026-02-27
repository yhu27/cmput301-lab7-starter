package com.example.androiduitesting;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        TextView textView = findViewById(R.id.show_text);
        Button backButton = findViewById(R.id.button_back);

        String city = getIntent().getStringExtra("city_name");

        textView.setText(city);

        backButton.setOnClickListener(v -> finish());
    }
}