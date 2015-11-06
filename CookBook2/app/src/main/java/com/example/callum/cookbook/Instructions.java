package com.example.callum.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Instructions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        Intent myIntent = getIntent();
        String rname = myIntent.getStringExtra("name");
        String ringredients = myIntent.getStringExtra("ingredients");
        String rdirections = myIntent.getStringExtra("directions");
        int pos = myIntent.getIntExtra("position", 0);
        int[] photos = myIntent.getIntArrayExtra("pictures");

        ImageView image = (ImageView) findViewById(R.id.imageView);
        TextView name = (TextView) findViewById(R.id.nameTextView);
        TextView ingredients = (TextView) findViewById(R.id.ingredientsTextView);
        TextView directions = (TextView) findViewById(R.id.directionsTextView);

        image.setImageResource(photos[pos]);
        name.setText(rname);
        ingredients.setText(ringredients);
        directions.setText(rdirections);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
