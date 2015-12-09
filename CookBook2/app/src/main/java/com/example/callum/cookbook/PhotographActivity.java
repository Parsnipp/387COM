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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class PhotographActivity extends AppCompatActivity {

    EditText nameText;
    EditText ingredientsText;
    EditText directionsText;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photograph);

        saveButton = (Button) findViewById(R.id.saveButton);
        nameText = (EditText) findViewById(R.id.saveName);
        ingredientsText = (EditText) findViewById(R.id.saveIngredients);
        directionsText = (EditText) findViewById(R.id.saveDirections);

        saveButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = String.valueOf(nameText.getText());
                        String ingredients = String.valueOf(ingredientsText.getText());
                        String directions = String.valueOf(directionsText.getText());
                        String[] ingList = ingredients.split(",");
                        if (name.length() == 0) {
                            Toast.makeText(getApplicationContext(), "Recipe not named!", Toast.LENGTH_LONG).show();
                        } else if (ingredients.length() == 0) {
                            Toast.makeText(getApplicationContext(), "No ingredients added!", Toast.LENGTH_LONG).show();
                        } else if (ingList.length == 1) {
                            Toast.makeText(getApplicationContext(), "Ingredients not comma separated.", Toast.LENGTH_LONG).show();
                        } else if (directions.length() == 0) {
                            Toast.makeText(getApplicationContext(), "No instructions given!", Toast.LENGTH_LONG).show();
                        } else {
                            Log.d("Saved", "recipe saved");
                            DatabaseHandler db = new DatabaseHandler(PhotographActivity.this);
                            Random random = new Random();
                            int randint = random.nextInt(99999999);
                            db.addRecipe(new Recipes(String.valueOf(randint), name, ingredients, directions, R.drawable.no_image));
                            Toast.makeText(getApplicationContext(), name + " saved.", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(PhotographActivity.this, SavedRecipeActivity.class);
                            startActivity(intent);
                        }
                    }
                }
        );

    }

}
