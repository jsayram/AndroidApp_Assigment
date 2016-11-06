package com.chefd.mealprep.mealprep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jose Ramirez on 11/1/2016.
 */

public class DataPlacer {
    public static List<FoodProduct> foodProductList = new ArrayList<>();
    public static Map<String, FoodProduct> foodProductMap = new HashMap<>();


    // the following food ids ie. food1, food2, food3, etc ...correspond to the images in the
    // main-> assets as long as the image is a .png file just put the name of the image
    //replacing food1, food2, food3 etc... with the correspoding image name you wish
    //to replace it with.


    static {
        addProduct("bananas",  // file name without .png extension
                "Bananas",  // name of item
                "Fresh Bananas", // description of item
                100); // how many calories that specific food item is.

        addProduct("oats",
                "Sweet Potato",
                "This is a nice carb",
                128);

        addProduct("cinnamon",
                "Brown Rice",
                "Good Carb",
                85);

        addProduct("greekyogurt",
                "Pineapple",
                "carbs for sweetness",
                23);

        addProduct("peanutbutter",
                "Apple",
                "Healthy apple",
                26);

        addProduct("egg",
                "Sunny side up egg",
                "Good morning protein",
                78);

        addProduct("mashedpotatoes",
                "Mashed potatoes",
                "Easy Carbs for Dinner",
                88);

        addProduct("meatballs",
                "Meatballs",
                "Mix with spaghetti and Tomato sauce for a good Carb, protein and vegie mix",
                197);

        addProduct("porkchops",
                "Pork chops",
                "Protein ",
                206);

        addProduct("spaghetti",
                "Spaghetti",
                "Mix with Meat balls and Tomato sauce for a good Carb, protein and vegie mix",
                158);

        addProduct("sweetcorn",
                "Sweet corn",
                "Vegtables",
                77);

        addProduct("tomatosauce",
                "Tomato SAuce",
                "Mix with Meat balls and Spaghetti for a good Carb, protein and vegie mix",
                115);

    }

    private static void addProduct(String itemId, String name,
                                   String description, int calorieNumber) {
        FoodProduct item = new FoodProduct(itemId, name, description, calorieNumber);
        foodProductList.add(item);
        foodProductMap.put(itemId, item);
    }

    public static List<String> getProductNames() {
        List<String> list = new ArrayList<>();
        for (FoodProduct product : foodProductList) {
            list.add(product.getName());
        }
        return list;
    }

    public static List<FoodProduct> getFilteredList(String searchString) {

        List<FoodProduct> filteredList = new ArrayList<>();
        for (FoodProduct foodProduct : foodProductList) {
            if (foodProduct.getFoodId().contains(searchString)) {
                filteredList.add(foodProduct);
            }
        }
        return filteredList;

    }

}

