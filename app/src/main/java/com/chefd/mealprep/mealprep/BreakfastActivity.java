package com.chefd.mealprep.mealprep;

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
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    ArrayList<Integer> foodPicList =new ArrayList<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);
        findViews();
        foodPicList.add(R.drawable.deanalbum);
        foodPicList.add(R.drawable.handsomeman);
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
    }

    private void findViews() {
        favoriteButton = (Button) findViewById(R.id.favorite_button);
        carbohydrateButton = (Button) findViewById(R.id.carbohydrate);
        proteinButton = (Button) findViewById(R.id.protein);
        vegetablesButton = (Button) findViewById(R.id.vegetables);
    }

}
