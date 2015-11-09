package com.example.callum.cookbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Callum on 09/11/2015.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("drop table if exists recipeTable ");
        db.execSQL("CREATE TABLE IF NOT EXISTS recipeTable (colID PRIMARY KEY, colName, colIngredients, colDirections, colPhoto)");
        Log.d("dbhelper", "table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addRecipe(Recipes recipe){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("colID", recipe.getID());
        values.put("colName", recipe.getName());
        values.put("colIngredients", recipe.getIngredients());
        values.put("colDirections", recipe.getDirections());
        values.put("colPhoto", recipe.getPhoto());


        long result = db.insert("recipeTable", null, values);
        if (result > 0){
            Log.d("dbhelper", "inserted successfully");
        } else {
            Log.d("dbhelper", "failed to insert");
        }

        db.close();
    }

    public DatabaseHandler(Context context){
        super(context, "testDB", null, 1);
    }
}
