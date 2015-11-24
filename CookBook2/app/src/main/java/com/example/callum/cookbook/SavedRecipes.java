package com.example.callum.cookbook;

/**
 * Created by Callum on 24/11/2015.
 */
public class SavedRecipes {
    private String id;
    private String name;
    private String ingredients;
    private String directions;
    private int photo;
    private String day;
    private String meal;

    public SavedRecipes(String id, String name, String ingredients, String directions, int photo, String day, String meal) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.directions = directions;
        this.photo = photo;
        this.day = day;
        this.meal = meal;
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

    public String getDay() {
        return day;
    }

    public String getMeal() {
        return meal;
    }
}
