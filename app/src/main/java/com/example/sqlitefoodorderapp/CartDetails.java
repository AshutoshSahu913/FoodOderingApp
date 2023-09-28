package com.example.sqlitefoodorderapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.sqlitefoodorderapp.Adapter.CartAdapter;
import com.example.sqlitefoodorderapp.Model.CartModel;
import com.example.sqlitefoodorderapp.databinding.ActivityCartDetailsBinding;

import java.util.ArrayList;

public class CartDetails extends AppCompatActivity {

    ActivityCartDetailsBinding cartDetailsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cartDetailsBinding = ActivityCartDetailsBinding.inflate(getLayoutInflater());
        setContentView(cartDetailsBinding.getRoot());

        ArrayList<CartModel> list;
        try (SQLiteDBHelper dbHelper = new SQLiteDBHelper(this)) {
            list = dbHelper.getOrders();
        }

        CartAdapter cartAdapter = new CartAdapter(list, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        cartDetailsBinding.rvCart.setAdapter(cartAdapter);
        cartDetailsBinding.rvCart.setLayoutManager(linearLayoutManager);
    }
}