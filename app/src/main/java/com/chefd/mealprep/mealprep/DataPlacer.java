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
    //replacing food1, food2, food3 etc... with the corresponding image name you wish
    //to replace it with.

    static {
        addProduct("food1",  // file name without .png extension
                "Chicken Leg",  // name of item
                "Is made of chicken", // description of item
                35); // how many calories that specific food item is.

        addProduct("food2",
                "Sweet Potato",
                "This is a nice carb",
                128);

        addProduct("food3",
                "Brown Rice",
                "Good Carb",
                85);

        addProduct("food4",
                "Pineapple",
                "carbs for sweetness",
                23);

        addProduct("food5",
                "Apple",
                "Healthy apple",
                26);

        addProduct("food6",
                "Peach",
                "Sweet Peach",
                65);

        addProduct("food7",
                "Can of Tuna",
                "Protein and fish oil",
                38);

        addProduct("food8",
                "Salmon",
                "Salmon from alaska good source of protein",
                45);

        addProduct("food9",
                "Pepperoni Pizza",
                "Carbs and lil bit of protein ",
                85);

        addProduct("food10",
                "Steak",
                "Protein Food",
                35);

        addProduct("food11",
                "Pork",
                "Protein Food",
                28);
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

