package com.chefd.mealprep.mealprep;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by artisja on 10/5/2016.
 */

public class BreakfastAdapter extends RecyclerView.Adapter<BreakfastAdapter.ViewHolder> {

    ArrayList<Integer> foodList;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView foodImage;

        public ViewHolder(ImageView imageView){
            super(imageView);
            foodImage = imageView;
        }
    }

    public BreakfastAdapter(ArrayList<Integer> list){
        foodList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_swipe,parent,false);
        ViewHolder viewHolder = new ViewHolder((ImageView) view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.foodImage.setImageResource(foodList.get(position));
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }
}
