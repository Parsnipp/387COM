package com.example.callum.cookbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Callum on 09/11/2015.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("drop table if exists recipeTable ");
        db.execSQL("CREATE TABLE IF NOT EXISTS recipeTable (ID PRIMARY KEY, Name, Ingredients, Directions, Photo)");
        Log.d("dbhelper", "table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addRecipe(Recipes recipe){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("ID", recipe.getID());
        values.put("Name", recipe.getName());
        values.put("Ingredients", recipe.getIngredients());
        values.put("Directions", recipe.getDirections());
        values.put("Photo", recipe.getPhoto());

        long result = db.insert("recipeTable", null, values);

        if (result > 0){
            Log.d("dbhelper", "inserted successfully");
        } else {
            Log.d("dbhelper", "failed to insert");
        }

        db.close();
    }

    public void deleteRecipe(String id){
        SQLiteDatabase db = getWritableDatabase();

        String selection = "SELECT * FROM recipeTable where id = '" + id + "'";
        Cursor recipes = db.rawQuery(selection, null);
        recipes.moveToFirst();
        while (!recipes.isAfterLast()){
            Log.d("dbhelper", recipes.getString(0) + " " + recipes.getString(1) + " " + recipes.getString(2) + " " + recipes.getString(3));
            recipes.moveToNext();
        }

        boolean aa = db.delete("recipeTable", "id" + "='" + id + "'", null) > 0;

        Log.d("dbhelper", String.valueOf(aa));

        db.close();
    }

    public ArrayList<Recipes> showSaved(){
        ArrayList<Recipes> returnable = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = "SELECT * FROM recipeTable";
        Cursor recipes = db.rawQuery(selection, null);
        recipes.moveToFirst();
        while (!recipes.isAfterLast()){
            returnable.add(new Recipes(recipes.getString(0), recipes.getString(1), recipes.getString(2), recipes.getString(3), recipes.getInt(4)));
            recipes.moveToNext();
        }
        return returnable;
    }

    public DatabaseHandler(Context context){
        super(context, "recipeDB", null, 1);
    }
}
