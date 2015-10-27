package com.example.callum.cookbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by callum on 27/10/2015.
 */
public class RecipesAdapter extends ArrayAdapter<Recipes> {

    private int resource;
    private ArrayList<Recipes> recipes;
    private Context context;

    public RecipesAdapter(Context context, int resource, ArrayList<Recipes> recipes) {
        super(context, resource, recipes);
        this.resource = resource;
        this.recipes = recipes;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View v = convertView;
        try{
            if (v == null){
                LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = layoutInflater.inflate(resource, parent, false);
            }

            ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
            TextView textViewName = (TextView) v.findViewById(R.id.textViewName);
            TextView textViewIngredients = (TextView) v.findViewById(R.id.textViewDetail);

            imageView.setImageResource(recipes.get(position).getPhoto());
            textViewName.setText(recipes.get(position).getName());
            textViewIngredients.setText(recipes.get(position).getIngredients());

        }
        catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
        return v;
    }

}