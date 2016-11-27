package com.chefd.mealprep.mealprep;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by artisja on 11/25/2016.
 */

public class LunchAdapter extends RecyclerView.Adapter<LunchAdapter.ViewHolder> {
    public static Integer count = 0;
    public static Integer hashcode = 0;
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

    public LunchAdapter(ArrayList<FoodIdenityHolder> list) {
        foodList = list;
    }

    @Override
    public LunchAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food_swipe, parent, false);
        LunchAdapter.ViewHolder viewHolder = new LunchAdapter.ViewHolder((LinearLayout) view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(LunchAdapter.ViewHolder holder, int position) {
        currentPosition = position;
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