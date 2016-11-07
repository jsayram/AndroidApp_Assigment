package com.chefd.mealprep.mealprep;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BreakfastActivity extends AppCompatActivity {

    private Button favoriteButton,carbohydrateButton,proteinButton,vegetablesButton;
    BreakfastAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    public ArrayList<FoodIdenityHolder> foodPicList = new ArrayList<FoodIdenityHolder>();


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);
        findViews();
        setUpData();

        setUpRecyclerView();
        setButtonClicker();
        }

    private void setUpData() {
        FoodIdenityHolder foodIdenityHolder = new FoodIdenityHolder(R.drawable.pancakes,R.string.banana_pancakes);
        FoodIdenityHolder foodIdenityHolder1 = new FoodIdenityHolder(R.drawable.kale_hash,R.string.bmi_calculator);
        FoodIdenityHolder foodIdenityHolder2 = new FoodIdenityHolder(R.drawable.seed_pudding,R.string.seed_pudding);
        FoodIdenityHolder foodIdenityHolder4 = new FoodIdenityHolder(R.drawable.overnight_oats,R.string.overnight_oats);
        FoodIdenityHolder foodIdenityHolder5 = new FoodIdenityHolder(R.drawable.yogurt_granola,R.string.yogurt_granola);
        foodPicList.add(foodIdenityHolder);
        foodPicList.add(foodIdenityHolder1);
        foodPicList.add(foodIdenityHolder2);
        foodPicList.add(foodIdenityHolder4);
        foodPicList.add(foodIdenityHolder5);
    }

    private void setUpRecyclerView(){
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new BreakfastAdapter(foodPicList);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager  = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        layoutManager = linearLayoutManager;
        recyclerView.setLayoutManager(layoutManager);
    }

    private void setButtonClicker() {
        favoriteButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"send favorite click to favorite activity",Toast.LENGTH_LONG);
            }
        });

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.scrollTo(adapter.getItemCount(),adapter.getItemCount()+1);
            }
        });

        carbohydrateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FoodIdenityHolder foodIdenityCarbs = new FoodIdenityHolder(R.drawable.carbs_pancakes,R.string.banana_pancakes_carbs);
                Intent intent = new Intent(BreakfastActivity.this,CarbsAcitivity.class);
                intent.putExtra("currentMealImage",foodIdenityCarbs.getImageId());
                intent.putExtra("currentMealString",foodIdenityCarbs.getStringId());
                startActivity(intent);
            }
        });

        proteinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FoodIdenityHolder foodIdenityProtein = new FoodIdenityHolder(R.drawable.twoeggs,R.string.banana_pancakes_proteins);
                Intent intent = new Intent(BreakfastActivity.this,ProteinActivity.class);
                intent.putExtra("currentMealImage",foodIdenityProtein.getImageId());
                intent.putExtra("currentMealString",foodIdenityProtein.getStringId());
                startActivity(intent);
            }
        });

        vegetablesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FoodIdenityHolder foodIdenityVeg = new FoodIdenityHolder(R.drawable.bananas,R.string.banana_pancakes_veg_fruits);
                Intent intent = new Intent(BreakfastActivity.this,VegetablesActivity.class);
                intent.putExtra("currentMealImage",foodIdenityVeg.getImageId());
                intent.putExtra("currentMealString",foodIdenityVeg.getStringId());
                startActivity(intent);
            }
        });
    }

    private void findViews() {
        favoriteButton = (Button) findViewById(R.id.favorite_button);
        carbohydrateButton = (Button) findViewById(R.id.carbohydrate);
        proteinButton = (Button) findViewById(R.id.protein);
        vegetablesButton = (Button) findViewById(R.id.vegetables);
        
    }

    public FoodIdenityHolder getCurrentInfo(){
        FoodIdenityHolder foodIdenityHolder = new FoodIdenityHolder(foodPicList.get(adapter.getPosition()).getImageId(),foodPicList.get(adapter.getPosition()).getStringId());
        return  foodIdenityHolder;
    }

}
