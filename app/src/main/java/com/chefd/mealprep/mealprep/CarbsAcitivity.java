package com.chefd.mealprep.mealprep;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class CarbsAcitivity extends AppCompatActivity {

    private ImageView image;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carbs__acitivity);


        FoodIdenityHolder foodIdenityHolder;
        Bundle bundle = getIntent().getExtras();
        foodIdenityHolder =
                new FoodIdenityHolder(bundle.getInt("currentMealImage"),
                        bundle.getInt("currentMealString"));
        image = (ImageView) findViewById(R.id.imageView_c1);
        image.setImageResource(foodIdenityHolder.getImageId());
        textView = (TextView) findViewById(R.id.carbohydrates_textview);
    }
}
