package com.example.callum.cookbook;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class PhotographActivity extends AppCompatActivity {

    EditText nameText;
    EditText ingredientsText;
    EditText directionsText;
    Button saveButton;
    Button imageButton;
    ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photograph);

        saveButton = (Button) findViewById(R.id.saveButton);
        nameText = (EditText) findViewById(R.id.saveName);
        ingredientsText = (EditText) findViewById(R.id.saveIngredients);
        directionsText = (EditText) findViewById(R.id.saveDirections);
        imageButton = (Button) findViewById(R.id.imageButton);
        imageView2 = (ImageView) findViewById(R.id.imageView2);

        imageButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivityForResult(intent, 1);
                        }
                    }
                }
        );

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Log.d("cameraPlace", "got here");
                Bundle cameraBundle = data.getExtras();
                Bitmap cameraImage = (Bitmap) cameraBundle.get("data");
                imageView2.setImageBitmap(cameraImage);

            } else if (resultCode == RESULT_CANCELED) {
                Log.d("cameraPlace", "erm?");
                // User cancelled the image capture
            } else {
                Log.d("cameraPlace", "broke");
                // Image capture failed, advise user
            }
        }
    }
}
