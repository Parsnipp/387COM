package com.example.callum.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Instructions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        Intent myIntent = getIntent();
        final String rid = myIntent.getStringExtra("id");
        final String rname = myIntent.getStringExtra("name");
        final String ringredients = myIntent.getStringExtra("ingredients");
        final String rdirections = myIntent.getStringExtra("directions");
        final int photos = myIntent.getIntExtra("pictures", 0);

        ImageView image = (ImageView) findViewById(R.id.imageView);
        TextView name = (TextView) findViewById(R.id.nameTextView);
        TextView ingredients = (TextView) findViewById(R.id.ingredientsTextView);
        TextView directions = (TextView) findViewById(R.id.directionsTextView);

        image.setImageResource(photos);
        name.setText(rname);
        ingredients.setText(ringredients);
        directions.setText(rdirections);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHandler db = new DatabaseHandler(Instructions.this);
                db.addRecipe(new Recipes(rid, rname, ringredients, rdirections, photos));
                Toast.makeText(getApplicationContext(), rname + " saved.", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Instructions.this, RecipeDatabaseActivity.class);
                startActivity(intent);
            }
        });
    }
}
