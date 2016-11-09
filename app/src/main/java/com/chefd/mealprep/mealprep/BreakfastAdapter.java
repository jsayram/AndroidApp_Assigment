package com.chefd.mealprep.mealprep;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by artisja on 10/5/2016.
 */

public class BreakfastAdapter extends RecyclerView.Adapter<BreakfastAdapter.ViewHolder> {
    public static Integer count=0,hashcode=0;
    ArrayList<FoodIdenityHolder> foodList;
    public static int currentPosition;
    public int hash = hashCode();


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageButton foodImage;

        public ViewHolder(LinearLayout imageView) {
            super(imageView);
            foodImage = (ImageButton) imageView.findViewById(R.id.food_swipe_image);
        }
    }

    public BreakfastAdapter(ArrayList<FoodIdenityHolder> list) {
        foodList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food_swipe,parent,false);
        ViewHolder viewHolder = new ViewHolder((LinearLayout)view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        currentPosition=position;
        holder.foodImage.setImageResource(foodList.get(position).getImageId());

    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public int getPosition() {
        return currentPosition;
    }
}
