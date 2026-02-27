package com.example.androiduitesting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView cityList;
    EditText newName;
    LinearLayout nameField;


    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameField = findViewById(R.id.field_nameEntry);
        newName = findViewById(R.id.editText_name);
        cityList = findViewById(R.id.city_list);

        dataList = new ArrayList<>();

        cityAdapter = new ArrayAdapter<>(this,
                R.layout.content,
                dataList);

        cityList.setAdapter(cityAdapter);

        Button addButton = findViewById(R.id.button_add);
        addButton.setOnClickListener(v ->
                nameField.setVisibility(View.VISIBLE)
        );

        Button confirmButton = findViewById(R.id.button_confirm);
        confirmButton.setOnClickListener(v -> {

            String cityName = newName.getText().toString().trim();

            if (!cityName.isEmpty()) {
                dataList.add(cityName);
                cityAdapter.notifyDataSetChanged();
            }

            newName.getText().clear();
            nameField.setVisibility(View.INVISIBLE);
        });
        Button deleteButton = findViewById(R.id.button_clear);
        deleteButton.setOnClickListener(v -> {
            dataList.clear();
            cityAdapter.notifyDataSetChanged();
        });

        cityList.setOnItemClickListener((parent, view, position, id) -> {

            String selectedCity = dataList.get(position);

            Intent intent = new Intent(MainActivity.this, ShowActivity.class);
            intent.putExtra("city_name", selectedCity);

            startActivity(intent);
        });
    }
}
