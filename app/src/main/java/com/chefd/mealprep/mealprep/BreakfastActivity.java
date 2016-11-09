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
import java.util.HashMap;
import java.util.Hashtable;

public class BreakfastActivity extends AppCompatActivity {

    private Button favoriteButton,carbohydrateButton,proteinButton,vegetablesButton;
    BreakfastAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    public Hashtable<Integer,Integer> ingredientTable = new Hashtable<>();

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
        FoodIdenityHolder foodIdenityHolder = new FoodIdenityHolder(R.drawable.pancakes,R.string.banana_pancakes,R.string.banana_pancakes_carbs,R.string.banana_pancakes_proteins,R.string.banana_pancakes_veg_fruits);
        FoodIdenityHolder foodIdenityHolder1 = new FoodIdenityHolder(R.drawable.kale_hash,R.string.kale_hash,R.string.carbs_kale_hash,R.string.protein_kale_hash,R.string.veg_kale_hash);
//        FoodIdenityHolder foodIdenityHolder2 = new FoodIdenityHolder(R.drawable.seed_pudding,R.string.seed_pudding);
//        FoodIdenityHolder foodIdenityHolder4 = new FoodIdenityHolder(R.drawable.overnight_oats,R.string.overnight_oats);
//        FoodIdenityHolder foodIdenityHolder5 = new FoodIdenityHolder(R.drawable.yogurt_granola,R.string.yogurt_granola);
        foodPicList.add(foodIdenityHolder);
        foodPicList.add(foodIdenityHolder1);
//        foodPicList.add(foodIdenityHolder2);
//        foodPicList.add(foodIdenityHolder4);
//        foodPicList.add(foodIdenityHolder5);
        ingredientTable.put(foodIdenityHolder.getCarbsId(),R.drawable.carbs_pancakes);
        ingredientTable.put(foodIdenityHolder.getProteinId(),R.drawable.twoeggs);
        ingredientTable.put(foodIdenityHolder.getVegFruitId(),R.drawable.bananas);
        ingredientTable.put(foodIdenityHolder1.getCarbsId(),R.drawable.sweet_potato);
        ingredientTable.put(foodIdenityHolder1.getProteinId(),R.drawable.chicken_sasusage);
        ingredientTable.put(foodIdenityHolder1.getVegFruitId(),R.drawable.red_pepper);
    }

    private void setUpRecyclerView(){
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new BreakfastAdapter(foodPicList);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager  = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        layoutManager = linearLayoutManager;
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void setButtonClicker() {
        favoriteButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"send favorite click to favorite activity",Toast.LENGTH_LONG);
            }
        });

        carbohydrateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FoodIdenityHolder foodIdenityCarbs = foodPicList.get(BreakfastAdapter.currentPosition);
                Intent intent = new Intent(BreakfastActivity.this,CarbsAcitivity.class);
                intent.putExtra("currentMealImage",ingredientTable.get(foodIdenityCarbs.getCarbsId()));
                intent.putExtra("currentMealString",foodIdenityCarbs.getStringId());
                intent.putExtra("currentMealCarbs",foodIdenityCarbs.getCarbsId());
                startActivity(intent);
            }
        });

        proteinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FoodIdenityHolder foodIdenityProtein = foodPicList.get(BreakfastAdapter.currentPosition);
                Intent intent = new Intent(BreakfastActivity.this,ProteinActivity.class);
                intent.putExtra("currentMealImage",ingredientTable.get(foodIdenityProtein.getProteinId()));
                intent.putExtra("currentMealString",foodIdenityProtein.getStringId());
                intent.putExtra("currentMealProtein",foodIdenityProtein.getProteinId());
                startActivity(intent);
            }
        });

        vegetablesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FoodIdenityHolder foodIdenityVeg = foodPicList.get(BreakfastAdapter.currentPosition);
                Intent intent = new Intent(BreakfastActivity.this,VegetablesActivity.class);
                intent.putExtra("currentMealImage",ingredientTable.get(foodIdenityVeg.getVegFruitId()));
                intent.putExtra("currentMealString",foodIdenityVeg.getStringId());
                intent.putExtra("currentMealVegetable",foodIdenityVeg.getVegFruitId());
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
}
