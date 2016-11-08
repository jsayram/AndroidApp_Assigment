package com.chefd.mealprep.mealprep;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BreakfastActivity extends AppCompatActivity {

    private Button favoriteButton;
    private Button carbohydrateButton;
    private Button proteinButton;
    private Button vegetablesButton;
    BreakfastAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    private TextView mealTitleText;
    public ArrayList<FoodIdenityHolder> foodPicList = new ArrayList<FoodIdenityHolder>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);
        findViews();

        // makes sure the activity stays in portrait mode
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        FoodIdenityHolder foodIdenityHolder =
                new FoodIdenityHolder(R.drawable.pancakes,R.string.banana_pancakes);
        foodPicList.add(foodIdenityHolder);
        setUpRecyclerView();
        setButtonClicker();
        mealTitleText.setText(getCurrentInfo().getStringId());

    }

    private void setUpRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new BreakfastAdapter(foodPicList);
        recyclerView.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void setButtonClicker() {
        favoriteButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "send favorite click to favorite activity",Toast.LENGTH_LONG);
            }
        });

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.scrollTo(adapter.getItemCount(), adapter.getItemCount() + 1);
            }
        });

        carbohydrateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FoodIdenityHolder foodIdenityCarbs =
                        new FoodIdenityHolder(R.drawable.carbs_pancakes,
                                R.string.banana_pancakes_carbs);
                Intent intent = new Intent(BreakfastActivity.this, CarbsAcitivity.class);
                intent.putExtra("currentMealImage", foodIdenityCarbs.getImageId());
                intent.putExtra("currentMealString", foodIdenityCarbs.getStringId());
                startActivity(intent);
            }
        });

        proteinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FoodIdenityHolder foodIdenityProtein =
                        new FoodIdenityHolder(R.drawable.twoeggs,
                                R.string.banana_pancakes_proteins);
                Intent intent = new Intent(BreakfastActivity.this, ProteinActivity.class);
                intent.putExtra("currentMealImage", foodIdenityProtein.getImageId());
                intent.putExtra("currentMealString", foodIdenityProtein.getStringId());
                startActivity(intent);
            }
        });

        vegetablesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FoodIdenityHolder foodIdenityVeg =
                        new FoodIdenityHolder(R.drawable.bananas,
                                R.string.banana_pancakes_veg_fruits);
                Intent intent = new Intent(BreakfastActivity.this, VegetablesActivity.class);
                intent.putExtra("currentMealImage", foodIdenityVeg.getImageId());
                intent.putExtra("currentMealString", foodIdenityVeg.getStringId());
                startActivity(intent);
            }
        });
    }

    private void findViews() {
        favoriteButton = (Button) findViewById(R.id.favorite_button);
        carbohydrateButton = (Button) findViewById(R.id.carbohydrate);
        proteinButton = (Button) findViewById(R.id.protein);
        vegetablesButton = (Button) findViewById(R.id.vegetables);
        mealTitleText = (TextView) findViewById(R.id.meal_title);

    }

    public FoodIdenityHolder getCurrentInfo() {
        FoodIdenityHolder foodIdenityHolder =
                new FoodIdenityHolder(foodPicList.get(adapter.getPosition())
                        .getImageId(), foodPicList.get(adapter.getPosition())
                        .getStringId());
        return foodIdenityHolder;
    }

}
