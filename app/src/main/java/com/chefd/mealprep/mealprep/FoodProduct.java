package com.chefd.mealprep.mealprep;

/**
 * Created by Jose Ramirez on 11/1/2016.
 */

public class FoodProduct {
    private String foodId;
    private String name;
    private String description;
    private int calorieNumber;


    public String getFoodId() {
        return foodId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description + "\n";
    }

    public int getCalorieNumber() {
        return calorieNumber;
    }

    public FoodProduct(String foodId, String name, String description, int calorieNumber) {
        this.foodId = foodId;
        this.name = name;
        this.description = description;
        this.calorieNumber = calorieNumber;
    }
}
