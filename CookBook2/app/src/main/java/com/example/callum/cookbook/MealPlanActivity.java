package com.example.callum.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MealPlanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_plan);

        Button monday_breakfast = (Button) findViewById(R.id.monday_breakfast);
        Button monday_lunch = (Button) findViewById(R.id.monday_lunch);
        Button monday_dinner = (Button) findViewById(R.id.monday_dinner);
        Button tuesday_breakfast = (Button) findViewById(R.id.tuesday_breakfast);
        Button tuesday_lunch = (Button) findViewById(R.id.tuesday_lunch);
        Button tuesday_dinner = (Button) findViewById(R.id.tuesday_dinner);
        Button wednesday_breakfast = (Button) findViewById(R.id.wednesday_breakfast);
        Button wednesday_lunch = (Button) findViewById(R.id.wednesday_lunch);
        Button wednesday_dinner = (Button) findViewById(R.id.wednesday_dinner);
        Button thursday_breakfast = (Button) findViewById(R.id.thursday_breakfast);
        Button thursday_lunch = (Button) findViewById(R.id.thursday_lunch);
        Button thursday_dinner = (Button) findViewById(R.id.thursday_dinner);
        Button friday_breakfast = (Button) findViewById(R.id.friday_breakfast);
        Button friday_lunch = (Button) findViewById(R.id.friday_lunch);
        Button friday_dinner = (Button) findViewById(R.id.friday_dinner);
        Button saturday_breakfast = (Button) findViewById(R.id.saturday_breakfast);
        Button saturday_lunch = (Button) findViewById(R.id.saturday_lunch);
        Button saturday_dinner = (Button) findViewById(R.id.saturday_dinner);
        Button sunday_breakfast = (Button) findViewById(R.id.sunday_breakfast);
        Button sunday_lunch = (Button) findViewById(R.id.sunday_lunch);
        Button sunday_dinner = (Button) findViewById(R.id.sunday_dinner);

        DatabaseHandler db = new DatabaseHandler(this);
        final ArrayList<SavedRecipes> recipes = db.showPlan();

        for (int i = 0; i < recipes.size(); i++) {
            if (recipes.get(i).getDay().equals("Monday")) {
                if (recipes.get(i).getMeal().equals("breakfast")) {
                    monday_breakfast.setText(recipes.get(i).getName());
                } else if (recipes.get(i).getMeal().equals("lunch")) {
                    monday_lunch.setText(recipes.get(i).getName());
                } else if (recipes.get(i).getMeal().equals("dinner")) {
                    monday_dinner.setText(recipes.get(i).getName());
                }
            } else if (recipes.get(i).getDay().equals("Tuesday")) {
                if (recipes.get(i).getMeal().equals("breakfast")) {
                    tuesday_breakfast.setText(recipes.get(i).getName());
                } else if (recipes.get(i).getMeal().equals("lunch")) {
                    tuesday_lunch.setText(recipes.get(i).getName());
                } else if (recipes.get(i).getMeal().equals("dinner")) {
                    tuesday_dinner.setText(recipes.get(i).getName());
                }
            } else if (recipes.get(i).getDay().equals("Wednesday")) {
                if (recipes.get(i).getMeal().equals("breakfast")) {
                    wednesday_breakfast.setText(recipes.get(i).getName());
                } else if (recipes.get(i).getMeal().equals("lunch")) {
                    wednesday_lunch.setText(recipes.get(i).getName());
                } else if (recipes.get(i).getMeal().equals("dinner")) {
                    wednesday_dinner.setText(recipes.get(i).getName());
                }
            } else if (recipes.get(i).getDay().equals("Thursday")) {
                if (recipes.get(i).getMeal().equals("breakfast")) {
                    thursday_breakfast.setText(recipes.get(i).getName());
                } else if (recipes.get(i).getMeal().equals("lunch")) {
                    thursday_lunch.setText(recipes.get(i).getName());
                } else if (recipes.get(i).getMeal().equals("dinner")) {
                    thursday_dinner.setText(recipes.get(i).getName());
                }
            } else if (recipes.get(i).getDay().equals("Friday")) {
                if (recipes.get(i).getMeal().equals("breakfast")) {
                    friday_breakfast.setText(recipes.get(i).getName());
                } else if (recipes.get(i).getMeal().equals("lunch")) {
                    friday_lunch.setText(recipes.get(i).getName());
                } else if (recipes.get(i).getMeal().equals("dinner")) {
                    friday_dinner.setText(recipes.get(i).getName());
                }
            } else if (recipes.get(i).getDay().equals("Saturday")) {
                if (recipes.get(i).getMeal().equals("breakfast")) {
                    saturday_breakfast.setText(recipes.get(i).getName());
                } else if (recipes.get(i).getMeal().equals("lunch")) {
                    saturday_lunch.setText(recipes.get(i).getName());
                } else if (recipes.get(i).getMeal().equals("dinner")) {
                    saturday_dinner.setText(recipes.get(i).getName());
                }
            } else if (recipes.get(i).getDay().equals("Sunday")) {
                if (recipes.get(i).getMeal().equals("breakfast")) {
                    sunday_breakfast.setText(recipes.get(i).getName());
                } else if (recipes.get(i).getMeal().equals("lunch")) {
                    sunday_lunch.setText(recipes.get(i).getName());
                } else if (recipes.get(i).getMeal().equals("dinner")) {
                    sunday_dinner.setText(recipes.get(i).getName());
                }
            }
        }

        monday_breakfast.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "Monday");
                        intent.putExtra("meal", "breakfast");
                        startActivity(intent);
                    }
                }
        );

        monday_lunch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "Monday");
                        intent.putExtra("meal", "lunch");
                        startActivity(intent);
                    }
                }
        );

        monday_dinner.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "Monday");
                        intent.putExtra("meal", "dinner");
                        startActivity(intent);
                    }
                }
        );

        tuesday_breakfast.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "Tuesday");
                        intent.putExtra("meal", "breakfast");
                        startActivity(intent);
                    }
                }
        );

        tuesday_lunch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "Tuesday");
                        intent.putExtra("meal", "lunch");
                        startActivity(intent);
                    }
                }
        );

        tuesday_dinner.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "Tuesday");
                        intent.putExtra("meal", "dinner");
                        startActivity(intent);
                    }
                }
        );

        wednesday_breakfast.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "Wednesday");
                        intent.putExtra("meal", "breakfast");
                        startActivity(intent);
                    }
                }
        );

        wednesday_lunch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "Wednesday");
                        intent.putExtra("meal", "lunch");
                        startActivity(intent);
                    }
                }
        );

        wednesday_dinner.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "Wednesday");
                        intent.putExtra("meal", "dinner");
                        startActivity(intent);
                    }
                }
        );

        thursday_breakfast.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "Thursday");
                        intent.putExtra("meal", "breakfast");
                        startActivity(intent);
                    }
                }
        );

        thursday_lunch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "Thursday");
                        intent.putExtra("meal", "lunch");
                        startActivity(intent);
                    }
                }
        );

        thursday_dinner.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "Thursday");
                        intent.putExtra("meal", "dinner");
                        startActivity(intent);
                    }
                }
        );

        friday_breakfast.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "Friday");
                        intent.putExtra("meal", "breakfast");
                        startActivity(intent);
                    }
                }
        );

        friday_lunch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "Friday");
                        intent.putExtra("meal", "lunch");
                        startActivity(intent);
                    }
                }
        );

        friday_dinner.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "Friday");
                        intent.putExtra("meal", "dinner");
                        startActivity(intent);
                    }
                }
        );

        saturday_breakfast.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "Saturday");
                        intent.putExtra("meal", "breakfast");
                        startActivity(intent);
                    }
                }
        );

        saturday_lunch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "Saturday");
                        intent.putExtra("meal", "lunch");
                        startActivity(intent);
                    }
                }
        );

        saturday_dinner.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "Saturday");
                        intent.putExtra("meal", "dinner");
                        startActivity(intent);
                    }
                }
        );

        sunday_breakfast.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "Sunday");
                        intent.putExtra("meal", "breakfast");
                        startActivity(intent);
                    }
                }
        );

        sunday_lunch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "Sunday");
                        intent.putExtra("meal", "lunch");
                        startActivity(intent);
                    }
                }
        );

        sunday_dinner.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MealPlanActivity.this, MealPickerActivity.class);
                        intent.putExtra("day", "Sunday");
                        intent.putExtra("meal", "dinner");
                        startActivity(intent);
                    }
                }
        );

    }

}
