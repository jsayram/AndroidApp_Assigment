package com.chefd.mealprep.mealprep;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.List;

public class CalorieViewActivity extends AppCompatActivity {

    private List<FoodProduct> foods = DataPlacer.foodProductList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        //creates the food adapter that holds each of the food items
        FoodListAdapter adapter = new FoodListAdapter(
                // custom layout for each of the food items in the listview of the calorieActivity
                this, R.layout.listitem, foods);
        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);
    }

}
