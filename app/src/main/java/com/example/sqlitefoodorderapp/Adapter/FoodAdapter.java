package com.example.sqlitefoodorderapp.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlitefoodorderapp.FoodDetails;
import com.example.sqlitefoodorderapp.Model.FoodModel;
import com.example.sqlitefoodorderapp.R;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.viewHolder> {
    ArrayList<FoodModel> lists;
    @SuppressLint("StaticFieldLeak")
    static Context context;

    public FoodAdapter( ArrayList<FoodModel> modelArrayList, Context context) {
        this.lists = modelArrayList;
        FoodAdapter.context = context;
    }

    @NonNull
    @Override
    public FoodAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item_list,parent,false);
        return new viewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.viewHolder holder, int position) {
        FoodModel food = lists.get(position);
        holder.foodImg.setImageResource(food.getFoodImg());
        holder.foodName.setText(food.getFoodName());
        holder.foodPrice.setText("₹ "+food.getFoodPrice());
        holder.foodDescription.setText(food.getFoodDes());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, FoodDetails.class);
            intent.putExtra("foodImg",food.getFoodImg());
            intent.putExtra("foodName",food.getFoodName());
            intent.putExtra("foodPrice",food.getFoodPrice());
            intent.putExtra("foodDes", food.getFoodDes());
            intent.putExtra("type", 1);

            Pair[] pairs = new Pair[1];
            pairs[0] = new Pair<View, String>(holder.foodImg, "img");
            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, pairs);
            context.startActivity(intent, activityOptions.toBundle());

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {

        ImageView foodImg;
        TextView foodName, foodPrice, foodDescription;


        public viewHolder(@NonNull View itemView) {
            super(itemView);
            foodImg = itemView.findViewById(R.id.foodImg);
            foodName = itemView.findViewById(R.id.foodName);
            foodPrice = itemView.findViewById(R.id.foodPrice);
            foodDescription = itemView.findViewById(R.id.foodDescription);
        }
    }
}
