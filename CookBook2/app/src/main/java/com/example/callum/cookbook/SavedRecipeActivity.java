package com.example.callum.cookbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SavedRecipeActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_recipe);

        DatabaseHandler db = new DatabaseHandler(this);
        final ArrayList<Recipes> recipes = db.showSaved();

        listView = (ListView) findViewById(R.id.listView2);
        listView.setAdapter(new RecipesAdapter(this, R.layout.list_item, recipes));
        listView.setOnItemClickListener(

                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(SavedRecipeActivity.this, SavedInstructions.class);
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
}
