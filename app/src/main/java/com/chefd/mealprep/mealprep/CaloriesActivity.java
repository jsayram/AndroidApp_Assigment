package com.chefd.mealprep.mealprep;

import android.os.Bundle;
import android.support.annotation.StringDef;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class CaloriesActivity extends AppCompatActivity {

    private List<FoodProduct> foods = DataPlacer.foodProductList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //creates the food adapter that holds each of the food items
        FoodListAdapter adapter = new FoodListAdapter(
                this, R.layout.listitem,foods);
        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);
    }


} //end class
