package com.example.callum.cookbook;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MealPickerActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_recipe);

        DatabaseHandler db = new DatabaseHandler(this);
        final ArrayList<Recipes> recipes = db.showSaved();

        final Intent myIntent = getIntent();

        listView = (ListView) findViewById(R.id.listView2);
        listView.setAdapter(new RecipesAdapter(this, R.layout.list_item, recipes));
        listView.setOnItemClickListener(

                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        final String rid = recipes.get(position).getID();
                        final String name = recipes.get(position).getName();
                        final String ingredients = recipes.get(position).getIngredients();
                        final String directions = recipes.get(position).getDirections();
                        final int photo = recipes.get(position).getPhoto();
                        final String meal = myIntent.getStringExtra("meal");
                        final String day = myIntent.getStringExtra("day");
                        final AlertDialog.Builder builder = new AlertDialog.Builder(MealPickerActivity.this);
                        builder.setMessage("Do you want to have: " + name + " for " + meal + " on " + day + "?")
                                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        DatabaseHandler db = new DatabaseHandler(MealPickerActivity.this);
                                        db.planRecipe(new Recipes(rid, name, ingredients, directions, photo), day, meal);
                                        Intent intent = new Intent(MealPickerActivity.this, MealPlanActivity.class);
                                        startActivity(intent);
                                    }
                                })
                                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.dismiss();
                                    }
                                });

                        builder.create();
                        builder.show();
                    }
                }
        );
    }

}
