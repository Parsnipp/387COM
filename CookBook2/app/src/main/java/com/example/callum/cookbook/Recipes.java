package com.example.callum.cookbook;

/**
 * Created by callum on 27/10/2015.
 */
public class Recipes {
    private  String id;
    private String name;
    private String ingredients;
    private  String directions;
    private int photo;

    public Recipes(String id, String name, String ingredients, String directions, int photo) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.directions = directions;
        this.photo = photo;
    }

    public String getID() {
        return id;
    };

    public String getName() {
        return name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getDirections() {
        return directions;
    }

    public int getPhoto() {
        return photo;
    }

}
