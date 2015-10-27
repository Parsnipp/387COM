package com.example.callum.cookbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PhotoListActivity extends AppCompatActivity {

    public static int[] recipePhotos = {
            R.drawable.chilli,
            R.drawable.curry,
            R.drawable.bolognese,
    };
    private String[] recipeNames;
    private String[] recipeIngredients;
    private String[] recipeDirections;
    private ArrayList<Recipes> recipes = new ArrayList<>();

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_list);

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

                        Toast.makeText(getBaseContext(), recipes.get(position).toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    private void generateRecipes() {

        // replace \ with angle brackets
        for (int i = 0; i < recipePhotos.length; i++) {
            recipes.add(new Recipes(recipeNames[i], recipeIngredients[i], recipeDirections[i], recipePhotos[i]));
        }
    }
}
