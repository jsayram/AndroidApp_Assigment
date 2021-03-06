package com.chefd.mealprep.mealprep;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Hashtable;

public class LunchActivity extends Activity {

    private Button favoriteButton;
    private Button carbohydrateButton;
    private Button proteinButton;
    private Button vegetablesButton;
    LunchAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    public Hashtable<Integer,Integer> ingredientTable = new Hashtable<>();
    public ArrayList<FoodIdenityHolder> foodPicList = new ArrayList<FoodIdenityHolder>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);
        findViews();
        setUpData();
        setUpRecyclerView();
        setButtonClicker();
    }

    private void setUpData() {
        FoodIdenityHolder foodIdenityHolder =
                new FoodIdenityHolder(R.drawable.food_album,
                        R.string.MADE_title,
                        R.string.M_description,
                        R.string.D_description,
                        R.string.E_description);
        ingredientTable.put(foodIdenityHolder.getCarbsId(),R.drawable.m_red);
        ingredientTable.put(foodIdenityHolder.getProteinId(),R.drawable.d_green);
        ingredientTable.put(foodIdenityHolder.getVegFruitId(),R.drawable.e_yellow);
        foodPicList.add(foodIdenityHolder);
    }

    private void setUpRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_lunch);
        adapter = new LunchAdapter(foodPicList);
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
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"send favorite click to favorite activity",Toast.LENGTH_LONG);
            }
        });

        carbohydrateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FoodIdenityHolder foodIdenityCarbs = foodPicList.get(LunchAdapter.currentPosition);
                Intent intent = new Intent(LunchActivity.this,CarbsAcitivity.class);
                intent.putExtra("currentMealImage",ingredientTable.get(foodIdenityCarbs.getCarbsId()));
                intent.putExtra("currentMealString",foodIdenityCarbs.getStringId());
                intent.putExtra("currentMealCarbs",foodIdenityCarbs.getCarbsId());
                startActivity(intent);
            }
        });

        proteinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FoodIdenityHolder foodIdenityProtein = foodPicList.get(LunchAdapter.currentPosition);
                Intent intent = new Intent(LunchActivity.this,ProteinActivity.class);
                intent.putExtra("currentMealImage",ingredientTable.get(foodIdenityProtein.getProteinId()));
                intent.putExtra("currentMealString",foodIdenityProtein.getStringId());
                intent.putExtra("currentMealProtein",foodIdenityProtein.getProteinId());
                startActivity(intent);
            }
        });

        vegetablesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FoodIdenityHolder foodIdenityVeg = foodPicList.get(LunchAdapter.currentPosition);
                Intent intent = new Intent(LunchActivity.this,VegetablesActivity.class);
                intent.putExtra("currentMealImage",ingredientTable.get(foodIdenityVeg.getVegFruitId()));
                intent.putExtra("currentMealString",foodIdenityVeg.getStringId());
                intent.putExtra("currentMealVegetable",foodIdenityVeg.getVegFruitId());
                startActivity(intent);
            }
        });
    }

    private void findViews() {
        favoriteButton = (Button) findViewById(R.id.favorite_button_lunch);
        carbohydrateButton = (Button) findViewById(R.id.carbohydrate_lunch);
        proteinButton = (Button) findViewById(R.id.protein_lunch);
        vegetablesButton = (Button) findViewById(R.id.vegetables_lunch);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_lunch);
    }
}
