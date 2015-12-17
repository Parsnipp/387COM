package com.example.callum.cookbook;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
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
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class PhotographActivity extends AppCompatActivity {

    EditText nameText;
    EditText ingredientsText;
    EditText directionsText;
    Button saveButton;
    Button imageButton;
    public static final int MEDIA_TYPE_IMAGE = 1;
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    private Uri fileUri;
    private int[] image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photograph);

        saveButton = (Button) findViewById(R.id.saveButton);
        nameText = (EditText) findViewById(R.id.saveName);
        ingredientsText = (EditText) findViewById(R.id.saveIngredients);
        directionsText = (EditText) findViewById(R.id.saveDirections);
        imageButton = (Button) findViewById(R.id.imageButton);

        imageButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                        startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
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
//
//    public void getImage(View arg0) {
//        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
//        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
//        startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
//    }

    private static Uri getOutputMediaFileUri(int type) {
        return Uri.fromFile(getOutputMediaFile(type));
    }

    private static File getOutputMediaFile(int type) {
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "MyCameraApp");
        Log.d("xxxx", "line 84");

        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d("MyCameraApp", mediaStorageDir.toString());

                Log.d("MyCameraApp", "failed to create directory");
                return null;
            }
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.UK).format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "IMG_" + timeStamp + ".jpg");
        } else {
            return null;
        }
        Log.d("xxxx", "line 108");
        return mediaFile;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // Image captured and saved to fileUri specified in the Intent
                Toast.makeText(this, "Image saved to:\n" +
                        data.getExtras(), Toast.LENGTH_LONG).show();
            } else if (resultCode == RESULT_CANCELED) {
                // User cancelled the image capture
            } else {
                // Image capture failed, advise user
            }
        }
    }
}
