package com.example.sqlitefoodorderapp.Adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlitefoodorderapp.FoodDetails;
import com.example.sqlitefoodorderapp.HomePage;
import com.example.sqlitefoodorderapp.Model.CartModel;
import com.example.sqlitefoodorderapp.R;
import com.example.sqlitefoodorderapp.SQLiteDBHelper;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.viewHolder> {
    ArrayList<CartModel> lists;
    Context context;


    public CartAdapter(ArrayList<CartModel> lists, Context context) {
        this.lists = lists;
        this.context = context;
    }

    @NonNull
    @Override
    public CartAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_list, parent, false);
        return new viewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CartAdapter.viewHolder holder, int position) {
        CartModel cartModel = lists.get(position);
        holder.orderImg.setImageResource(cartModel.getOrderImg());
        holder.orderName.setText(cartModel.getOrderFoodName());
        holder.orderPrice.setText("₹ "+cartModel.getOrderPrice());
        holder.orderNumber.setText(cartModel.getOrderNumber());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, FoodDetails.class);
            intent.putExtra("id", Integer.parseInt(cartModel.getOrderNumber()));
            intent.putExtra("type", 2);
            context.startActivity(intent);
        });
        holder.itemView.setOnLongClickListener(v -> {
            new AlertDialog.Builder(context)
                    .setTitle("Delete Item")
                    .setMessage("Are you sure to delete this item?")
                    .setPositiveButton("Yes", (dialog, which) -> {
                        try (SQLiteDBHelper dbHelper = new SQLiteDBHelper(context)) {
                            if (dbHelper.deleteData(cartModel.getOrderNumber()) > 0) {
                                context.startActivity(new Intent(context, HomePage.class));
                                Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    })
                    .setNegativeButton("No", (dialog, which) -> dialog.cancel()).show();
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        ImageView orderImg;
        TextView orderName, orderNumber, orderPrice;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            orderImg = itemView.findViewById(R.id.foodOrderImg);
            orderName = itemView.findViewById(R.id.foodOrderName);
            orderPrice = itemView.findViewById(R.id.foodOrderPrice);
            orderNumber = itemView.findViewById(R.id.foodOrderNumber);
        }
    }
}
