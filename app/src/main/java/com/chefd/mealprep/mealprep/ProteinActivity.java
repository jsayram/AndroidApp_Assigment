package com.chefd.mealprep.mealprep;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class ProteinActivity extends AppCompatActivity {


    private ImageView image;
    private TextView textView;
    private TextView titleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protein_);
        FoodIdenityHolder foodIdenityHolder;
        Bundle bundle = getIntent().getExtras();
        foodIdenityHolder = new FoodIdenityHolder(bundle.getInt("currentMealImage"),
                bundle.getInt("currentMealString"),
                bundle.getInt("currentMealProtein"),null,null);
        image = (ImageView) findViewById(R.id.protein_image);
        image.setImageResource(bundle.getInt("currentMealImage"));
        titleView = (TextView) findViewById(R.id.protein_text);
        titleView.setText(foodIdenityHolder.getStringId());
        textView = (TextView) findViewById(R.id.protein_recipe);
        textView.setText(bundle.getInt("currentMealProtein"));
    }
}
