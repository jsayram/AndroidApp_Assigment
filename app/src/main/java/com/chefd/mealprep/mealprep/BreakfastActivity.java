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
        FoodIdenityHolder foodIdenityHolder = new FoodIdenityHolder(R.drawable.deanalbum,R.string.protein);
        //FoodIdenityHolder foodIdenityHolder1 = new FoodIdenityHolder(R.drawable.handsomeman,R.string.Favorite);
        foodPicList.add(foodIdenityHolder);
        //foodPicList.add(foodIdenityHolder1);
        setUpRecyclerView();
        setButtonClicker();

    }

    private void setUpRecyclerView(){
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new BreakfastAdapter(foodPicList);
        recyclerView.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
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
                Intent intent = new Intent(BreakfastActivity.this,Vegetables_Activity.class);
                //intent.putExtra("currentMealImage",getCurrentInfo().getImageID());
                //intent.putExtra("currentMealString",getCurrentInfo().getStringID());
                startActivity(intent);
            }
        });

        proteinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BreakfastActivity.this,Vegetables_Activity.class);
                intent.putExtra("currentMealImage",getCurrentInfo().getImageID());
                intent.putExtra("currentMealString",getCurrentInfo().getStringID());
                startActivity(intent);
            }
        });

        vegetablesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BreakfastActivity.this,Vegetables_Activity.class);
                intent.putExtra("currentMealImage",getCurrentInfo().getImageID());
                intent.putExtra("currentMealString",getCurrentInfo().getStringID());
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
        FoodIdenityHolder foodIdenityHolder = new FoodIdenityHolder(foodPicList.get(adapter.getPosition()).getImageID(),foodPicList.get(adapter.getPosition()).getStringID());
        return  foodIdenityHolder;
    }

}
