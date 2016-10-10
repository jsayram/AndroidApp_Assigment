package com.chefd.mealprep.mealprep;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;



public class BreakfastAdapter extends RecyclerView.Adapter<BreakfastAdapter.ViewHolder>{

    ArrayList<Integer> foodList;
    private int currentPosition;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView foodImage;

        public ViewHolder(LinearLayout imageView){
            super(imageView);
            foodImage = (ImageView) imageView.findViewById(R.id.food_swipe_image);
        }
    }

    public BreakfastAdapter(ArrayList<Integer> list){
        foodList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_swipe,parent,false);
        ViewHolder viewHolder = new ViewHolder((LinearLayout)view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        currentPosition = position;
        holder.foodImage.setImageResource(foodList.get(position));
    }

    @Override
    public int getItemCount() {

        return foodList.size();
    }

    public int getPosition(){

        return currentPosition;
    }
}
