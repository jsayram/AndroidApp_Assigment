package com.chefd.mealprep.mealprep;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import static com.chefd.mealprep.mealprep.R.id.textView;

public class VegetablesActivity extends AppCompatActivity {

    private FoodIdenityHolder foodIdenityHolder;
    private ImageView image;
    private TextView vegetablesTextView;
    private TextView titleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetables_);

        FoodIdenityHolder foodIdenityHolder;
        Bundle bundle = getIntent().getExtras();
        foodIdenityHolder = new FoodIdenityHolder(bundle.getInt("currentMealImage"),
                bundle.getInt("currentMealString"),
                bundle.getInt("currentMealVegetable"),null,null);
        image = (ImageView) findViewById(R.id.vegetables_Image);
        image.setImageResource(bundle.getInt("currentMealImage"));
        titleView = (TextView) findViewById(R.id.vegetables_title);
        titleView.setText(foodIdenityHolder.getStringId());
        vegetablesTextView = (TextView) findViewById(R.id.vegetables_text);
        vegetablesTextView.setText(bundle.getInt("currentMealVegetable"));
    }

}
