package com.example.callum.cookbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ShoppingListActivity extends AppCompatActivity {

    private ArrayList<String> items = new ArrayList<>();

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        DatabaseHandler db = new DatabaseHandler(this);
        final ArrayList<SavedRecipes> recipes = db.showPlan();

        if (recipes.size() == 0) {
            items.add("No food required.");
        } else {
            for (int i = 0; i < recipes.size(); i++) {
                String ingredients = recipes.get(i).getIngredients();
                String[] inglist = ingredients.split(",");
                for (int j = 0; j < inglist.length; j++) {
                    String item;
                    if (inglist[j].charAt(0) == ' ') {
                        item = inglist[j].substring(1);
                    } else {
                        item = inglist[j];
                    }
                    items.add(item);
                }
            }

            Log.d("shopping", "done loop 1");

            for (int i = 0; i < items.size(); i++) {
                Log.d("shopping", String.valueOf(items.size()));
                int numberOf = 1;
                for (int j = i + 1; j < items.size(); j++) {
                    Log.d("shopping", items.get(i) + ":" + items.get(j));

                    if (items.get(i).equals(items.get(j))) {
                        numberOf++;
                        items.remove(j);
                        j--;
                    }
                }

                Log.d("shopping", String.valueOf(items.size()));

                String newItem = String.valueOf(numberOf) + " " + items.get(i);
                items.set(i, newItem);
            }
        }

        listView = (ListView) findViewById(R.id.listView3);

        if (items.get(0).equals("No food required.")) {
            listView.setAdapter(new NoShoppingAdapter(this, R.layout.no_shopping_item, items));
        } else {
            listView.setAdapter(new ShoppingAdapter(this, R.layout.shopping_list_item, items));
        }
    }

}
