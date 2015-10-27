package com.example.callum.cookbook;

/**
 * Created by callum on 27/10/2015.
 */
public class Recipes {
    private String name;
    private String ingredients;
    private  String directions;
    private int photo;

    public Recipes(String name, String ingredients, String directions, int photo) {
        this.name = name;
        this.ingredients = ingredients;
        this.directions = directions;
        this.photo = photo;
    }

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

    @Override
    public String toString() {
        return directions;
    }
}
