package com.example.callum.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MealPlanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_plan);

        Button monday_breakfast = (Button) findViewById(R.id.monday_breakfast);
        monday_breakfast.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "mon");
                        intent.putExtra("meal", "breakfast");
                        startActivity(intent);
                    }
                }
        );

        Button monday_lunch = (Button) findViewById(R.id.monday_lunch);
        monday_lunch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "mon");
                        intent.putExtra("meal", "lunch");
                        startActivity(intent);
                    }
                }
        );

        Button monday_dinner = (Button) findViewById(R.id.monday_dinner);
        monday_dinner.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "mon");
                        intent.putExtra("meal", "dinner");
                        startActivity(intent);
                    }
                }
        );

        Button tuesday_breakfast = (Button) findViewById(R.id.tuesday_breakfast);
        tuesday_breakfast.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "tues");
                        intent.putExtra("meal", "breakfast");
                        startActivity(intent);
                    }
                }
        );

        Button tuesday_lunch = (Button) findViewById(R.id.tuesday_lunch);
        tuesday_lunch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "tues");
                        intent.putExtra("meal", "lunch");
                        startActivity(intent);
                    }
                }
        );

        Button tuesday_dinner = (Button) findViewById(R.id.tuesday_dinner);
        tuesday_dinner.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "tues");
                        intent.putExtra("meal", "dinner");
                        startActivity(intent);
                    }
                }
        );

        Button wednesday_breakfast = (Button) findViewById(R.id.wednesday_breakfast);
        wednesday_breakfast.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "wed");
                        intent.putExtra("meal", "breakfast");
                        startActivity(intent);
                    }
                }
        );

        Button wednesday_lunch = (Button) findViewById(R.id.wednesday_lunch);
        wednesday_lunch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "wed");
                        intent.putExtra("meal", "lunch");
                        startActivity(intent);
                    }
                }
        );

        Button wednesday_dinner = (Button) findViewById(R.id.wednesday_dinner);
        wednesday_dinner.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "wed");
                        intent.putExtra("meal", "dinner");
                        startActivity(intent);
                    }
                }
        );

        Button thursday_breakfast = (Button) findViewById(R.id.thursday_breakfast);
        thursday_breakfast.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "thurs");
                        intent.putExtra("meal", "breakfast");
                        startActivity(intent);
                    }
                }
        );

        Button thursday_lunch = (Button) findViewById(R.id.thursday_lunch);
        thursday_lunch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "thurs");
                        intent.putExtra("meal", "lunch");
                        startActivity(intent);
                    }
                }
        );

        Button thursday_dinner = (Button) findViewById(R.id.thursday_dinner);
        thursday_dinner.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "thurs");
                        intent.putExtra("meal", "dinner");
                        startActivity(intent);
                    }
                }
        );

        Button friday_breakfast = (Button) findViewById(R.id.friday_breakfast);
        friday_breakfast.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "fri");
                        intent.putExtra("meal", "breakfast");
                        startActivity(intent);
                    }
                }
        );

        Button friday_lunch = (Button) findViewById(R.id.friday_lunch);
        friday_lunch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "fri");
                        intent.putExtra("meal", "lunch");
                        startActivity(intent);
                    }
                }
        );

        Button friday_dinner = (Button) findViewById(R.id.friday_dinner);
        friday_dinner.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "fri");
                        intent.putExtra("meal", "dinner");
                        startActivity(intent);
                    }
                }
        );

        Button saturday_breakfast = (Button) findViewById(R.id.saturday_breakfast);
        saturday_breakfast.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "sat");
                        intent.putExtra("meal", "breakfast");
                        startActivity(intent);
                    }
                }
        );

        Button saturday_lunch = (Button) findViewById(R.id.saturday_lunch);
        saturday_lunch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "sat");
                        intent.putExtra("meal", "lunch");
                        startActivity(intent);
                    }
                }
        );

        Button saturday_dinner = (Button) findViewById(R.id.saturday_dinner);
        saturday_dinner.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "sat");
                        intent.putExtra("meal", "dinner");
                        startActivity(intent);
                    }
                }
        );

        Button sunday_breakfast = (Button) findViewById(R.id.sunday_breakfast);
        sunday_breakfast.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "sun");
                        intent.putExtra("meal", "breakfast");
                        startActivity(intent);
                    }
                }
        );

        Button sunday_lunch = (Button) findViewById(R.id.sunday_lunch);
        sunday_lunch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "sun");
                        intent.putExtra("meal", "lunch");
                        startActivity(intent);
                    }
                }
        );

        Button sunday_dinner = (Button) findViewById(R.id.sunday_dinner);
        sunday_dinner.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "sun");
                        intent.putExtra("meal", "dinner");
                        startActivity(intent);
                    }
                }
        );

    }

}
