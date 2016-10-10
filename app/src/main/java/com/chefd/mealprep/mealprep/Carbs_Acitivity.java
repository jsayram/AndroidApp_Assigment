package com.chefd.mealprep.mealprep;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Carbs_Acitivity extends AppCompatActivity {

    private ImageView image;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carbs__acitivity);
        //so Brain here just find both the views for the activity and then just use the setimageResource,and setText for both the text
        //and image view just look suggestions and the choose the right one
        FoodIdenityHolder foodIdenityHolder;
        Bundle bundle = getIntent().getExtras();
        foodIdenityHolder = new FoodIdenityHolder(bundle.getInt("currentMealImage"),bundle.getInt("currentMealString"));
        image = (ImageView) findViewById(R.id.imageView_c1);
        image.setImageResource(foodIdenityHolder.getImageID());
        textView = (TextView) findViewById(R.id.carbohydrates_textview);

}
    }
