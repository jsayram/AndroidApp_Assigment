package com.chefd.mealprep.mealprep;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.List;

/**
 * Created by Jose Ramirez on 11/1/2016.
 */

public class FoodListAdapter extends ArrayAdapter<FoodProduct> {

    private List<FoodProduct> foods;

    public FoodListAdapter(Context context, int resource, List<FoodProduct> objects) {
        super(context, resource, objects);
        foods = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.listitem, parent, false);
        }
        FoodProduct food = foods.get(position);

        //gets the name of the food
        TextView nameText= (TextView) convertView.findViewById(R.id.nameText);
        nameText.setText(food.getName());

        // gets the amount of calories for food
        NumberFormat formatter = NumberFormat.getInstance();
        String calories = formatter.format(food.getCalorieNumber());
        TextView calorieNumberText = (TextView) convertView.findViewById(R.id.calorieNumberText);
        calorieNumberText.setText(calories);

        // gets required imageview from the created assets folder
        ImageView iv = (ImageView) convertView.findViewById(R.id.imageView);
        Bitmap bitmap = getBitmapFromAsset(food.getFoodId());
        iv.setImageBitmap(bitmap);

        return convertView;
    }

    private Bitmap getBitmapFromAsset(String foodId) {
        AssetManager assetManager = getContext().getAssets();
        InputStream stream = null;

        try {
            stream = assetManager.open(foodId + ".png");
            return BitmapFactory.decodeStream(stream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
