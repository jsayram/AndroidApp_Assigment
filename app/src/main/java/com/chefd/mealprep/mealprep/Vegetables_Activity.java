package com.chefd.mealprep.mealprep;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Vegetables_Activity extends AppCompatActivity {

    private FoodIdenityHolder foodIdenityHolder;
    private ImageView image;
    private TextView vegetablesTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetables_);

        Bundle bundle = getIntent().getExtras();
        foodIdenityHolder = new FoodIdenityHolder(bundle.getInt("currentMealImage"),bundle.getInt("currentMealString"));
        vegetablesTextView = (TextView) findViewById(R.id.vegetables_title);
        vegetablesTextView.setText("Vegetables/Fruit");
        image = (ImageView) findViewById(R.id.vegetables_Image);
        image.setImageResource(foodIdenityHolder.getImageID());

        //so quan here just find both the views for the activity and then just use the setimageResource,and setText for both the text
        //and image view just look suggestions and the choose the right
    }

}
