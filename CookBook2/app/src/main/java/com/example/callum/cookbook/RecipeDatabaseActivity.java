package com.example.callum.cookbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class RecipeDatabaseActivity extends AppCompatActivity {

    public static int[] recipePhotos = {
            R.drawable.chilli,
            R.drawable.curry,
            R.drawable.bolognese,
    };
    private String[] recipeID;
    private String[] recipeNames;
    private String[] recipeIngredients;
    private String[] recipeDirections;
    private ArrayList<Recipes> recipes = new ArrayList<>();

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_database);

        recipeID = getResources().getStringArray(R.array.recipe_id);
        recipeNames = getResources().getStringArray(R.array.recipe_name);
        recipeIngredients = getResources().getStringArray(R.array.recipe_ingredients);
        recipeDirections = getResources().getStringArray(R.array.recipe_directions);
        generateRecipes();

        listView = (ListView) findViewById(R.id.listView2);
        listView.setAdapter(new RecipesAdapter(this, R.layout.list_item, recipes));
        listView.setOnItemClickListener(

                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(RecipeDatabaseActivity.this, Instructions.class);
                        String rid = recipes.get(position).getID();
                        String rname = recipes.get(position).getName();
                        String ringredients = recipes.get(position).getIngredients();
                        String rdirections = recipes.get(position).getDirections();
                        int rphoto = recipes.get(position).getPhoto();
                        intent.putExtra("id", rid);
                        intent.putExtra("name", rname);
                        intent.putExtra("ingredients", ringredients);
                        intent.putExtra("directions", rdirections);
                        intent.putExtra("pictures", rphoto);
                        startActivity(intent);
                    }
                }
        );
    }

    private void generateRecipes() {
        for (int i = 0; i < recipePhotos.length; i++) {
            recipes.add(new Recipes(recipeID[i], recipeNames[i], recipeIngredients[i], recipeDirections[i], recipePhotos[i]));
        }
    }
}
