package com.chefd.mealprep.mealprep;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class VegetablesActivity extends AppCompatActivity {

    private FoodIdenityHolder foodIdenityHolder;
    private ImageView image;
    private TextView vegetablesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetables_);

        Bundle bundle = getIntent().getExtras();
        foodIdenityHolder =
                new FoodIdenityHolder(bundle.getInt("currentMealImage"),
                        bundle.getInt("currentMealString"));
        vegetablesTextView = (TextView) findViewById(R.id.vegetables_title);
        vegetablesTextView.setText("Vegetables/Fruit");
        image = (ImageView) findViewById(R.id.vegetables_Image);
        image.setImageResource(foodIdenityHolder.getImageId());
    }

}
