package com.example.callum.cookbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;

import java.util.ArrayList;

/**
 * Created by Callum on 30/11/2015.
 */
public class ShoppingAdapter extends ArrayAdapter<String> {

    private int resource;
    private ArrayList<String> items;
    private Context context;

    public ShoppingAdapter(Context context, int resource, ArrayList<String> items) {
        super(context, resource, items);
        this.resource = resource;
        this.items = items;
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

            CheckBox checkBox = (CheckBox) v.findViewById(R.id.checkBox);

            checkBox.setText(items.get(position));
        }
        catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
        return v;
    }

}
