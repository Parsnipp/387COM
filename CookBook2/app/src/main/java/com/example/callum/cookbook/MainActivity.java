package com.example.callum.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String[] mainz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mainz = getResources().getStringArray(R.array.mainz);

        listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mainz);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(

                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position == 0) {
                            Intent intent = new Intent(MainActivity.this, RecipeDatabaseActivity.class);
                            startActivity(intent);
                        } else if (position == 1) {
                            Intent intent = new Intent(MainActivity.this, SavedRecipeActivity.class);
                            startActivity(intent);
                        } else if (position == 2) {
                            Intent intent = new Intent(MainActivity.this, MealPlanActivity.class);
                            startActivity(intent);
                        } else if (position == 3) {
                            Intent intent = new Intent(MainActivity.this, ShoppingListActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getBaseContext(), mainz[position] + ", not implemented...", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }
}
