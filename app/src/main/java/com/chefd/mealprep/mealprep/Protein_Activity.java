package com.chefd.mealprep.mealprep;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static com.chefd.mealprep.mealprep.R.id.image;

public class Protein_Activity extends AppCompatActivity {


    private ImageView image;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protein_);
        FoodIdenityHolder foodIdenityHolder;
        Bundle bundle = getIntent().getExtras();
        foodIdenityHolder = new FoodIdenityHolder(bundle.getInt("currentMealImage"),bundle.getInt("currentMealString"));
        image = (ImageView) findViewById(R.id.protein_image);
        image.setImageResource(foodIdenityHolder.getImageID());
        textView = (TextView) findViewById(R.id.protein_recipe);
    }
}
