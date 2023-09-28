package com.example.sqlitefoodorderapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sqlitefoodorderapp.databinding.ActivityFoodDetailsBinding;

import java.util.Objects;

public class FoodDetails extends AppCompatActivity {

    ActivityFoodDetailsBinding foodDetailsBinding;
    int food_img;
    String food_name, food_des;
    int food_price;


    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        foodDetailsBinding = ActivityFoodDetailsBinding.inflate(getLayoutInflater());
        setContentView(foodDetailsBinding.getRoot());

        Context context = this;
        // Increment quantity
        foodDetailsBinding.increaseCount.setOnClickListener(v -> incrementQuantity());

        // Decrement quantity
        foodDetailsBinding.decreaseCount.setOnClickListener(v -> decrementQuantity());

        try (SQLiteDBHelper dbHelper = new SQLiteDBHelper(FoodDetails.this)) {
            if (getIntent().getIntExtra("type", 0) == 1) {
                food_img = getIntent().getIntExtra("foodImg", 0);
                food_name = getIntent().getStringExtra("foodName");
                food_price = Integer.parseInt((Objects.requireNonNull(getIntent().getStringExtra("foodPrice"))));
                food_des = getIntent().getStringExtra("foodDes");

                //set action bar title after getAndSetIntentData method
                ActionBar ab = getSupportActionBar();
                if (ab != null) {
                    ab.setTitle(food_name);
                }

                foodDetailsBinding.foodDetailsImg.setImageResource(food_img);
                foodDetailsBinding.foodDetailsPrice.setText(String.format("%d", food_price));
                foodDetailsBinding.foodDetailsDes.setText(food_des);
                foodDetailsBinding.foodDetailsName.setText(food_name);


                foodDetailsBinding.orderNowBtn.setOnClickListener(v -> {
                    String userName = foodDetailsBinding.enterName.getText().toString();
                    String phone = foodDetailsBinding.enterPhoneNo.getText().toString();
                    if (userName.isEmpty() || phone.isEmpty()) {
                        if (userName.isEmpty()) {
                            foodDetailsBinding.enterName.setError("Fill name please");
                        }
                        if (phone.isEmpty()) {
                            foodDetailsBinding.enterPhoneNo.setError("fill phone no");
                        }
                        return;
                    }
                    dbHelper.insertData(
                            userName,
                            phone,
                            food_name,
                            food_price,
                            food_img,
                            Integer.parseInt(foodDetailsBinding.foodDetailsQty.getText().toString()),
                            food_des,
                            context);
                    startActivity(new Intent(FoodDetails.this, CartDetails.class));
                });
            } else {

                int id = getIntent().getIntExtra("id", 0);
                Cursor cursor = dbHelper.getOrderById(id);

                final int image = cursor.getInt(5);
                String name = cursor.getString(3);

                foodDetailsBinding.enterName.setText(cursor.getString(1));
                foodDetailsBinding.enterPhoneNo.setText(cursor.getString(2));
                foodDetailsBinding.foodDetailsName.setText(name);
                foodDetailsBinding.foodDetailsPrice.setText(String.format("%d", cursor.getInt(4)));
                foodDetailsBinding.foodDetailsImg.setImageResource(image);
                foodDetailsBinding.foodDetailsDes.setText(cursor.getString(6));
                foodDetailsBinding.foodDetailsQty.setText(cursor.getString(7));

                //set action bar title after getAndSetIntentData method
                ActionBar ab = getSupportActionBar();
                if (ab != null) {
                    ab.setTitle(name);
                }
                foodDetailsBinding.orderNowBtn.setText("Update Now");
                foodDetailsBinding.orderNowBtn.setOnClickListener(v -> {
                    dbHelper.updateData(
                            foodDetailsBinding.enterName.getText().toString(),
                            foodDetailsBinding.enterPhoneNo.getText().toString(),
                            foodDetailsBinding.foodDetailsName.getText().toString(),
                            Integer.parseInt(foodDetailsBinding.foodDetailsPrice.getText().toString()),
                            image,
                            Integer.parseInt(foodDetailsBinding.foodDetailsQty.getText().toString()),
                            foodDetailsBinding.foodDetailsDes.getText().toString(),
                            context,
                            id
                    );
                    startActivity(new Intent(FoodDetails.this, CartDetails.class));
                });

            }
        }
    }
    // Method to increment the quantity
    private void incrementQuantity() {
        int currentQuantity = Integer.parseInt(foodDetailsBinding.foodDetailsQty.getText().toString());
        currentQuantity++;
        foodDetailsBinding.foodDetailsQty.setText(String.valueOf(currentQuantity));
    }

    // Method to decrement the quantity, avoiding negative values
    private void decrementQuantity() {
        int currentQuantity = Integer.parseInt(foodDetailsBinding.foodDetailsQty.getText().toString());
        if (currentQuantity > 1) {
            currentQuantity--;
            foodDetailsBinding.foodDetailsQty.setText(String.valueOf(currentQuantity));
        }
    }

}