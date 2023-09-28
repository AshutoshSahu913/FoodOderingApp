package com.example.sqlitefoodorderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.sqlitefoodorderapp.Adapter.FoodAdapter;
import com.example.sqlitefoodorderapp.Model.FoodModel;
import com.example.sqlitefoodorderapp.databinding.ActivityHomePageBinding;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {

    ActivityHomePageBinding homePageBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homePageBinding = ActivityHomePageBinding.inflate(getLayoutInflater());
        setContentView(homePageBinding.getRoot());

        ArrayList<FoodModel> arrLists = new ArrayList<>();

        arrLists.add(new FoodModel(R.drawable.momos, "Momos", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "150"));
        arrLists.add(new FoodModel(R.drawable.noodle, "Noodles", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "850"));
        arrLists.add(new FoodModel(R.drawable.fast_food1, "Roll", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "350"));
        arrLists.add(new FoodModel(R.drawable.salads, "Salads", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "450"));
        arrLists.add(new FoodModel(R.drawable.roll, "Roll", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "450"));
        arrLists.add(new FoodModel(R.drawable.momos, "Momos", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "150"));
        arrLists.add(new FoodModel(R.drawable.noodle, "Noodles", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "850"));
        arrLists.add(new FoodModel(R.drawable.fast_food1, "Roll", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "350"));
        arrLists.add(new FoodModel(R.drawable.salads, "Salads", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "450"));
        arrLists.add(new FoodModel(R.drawable.roll, "Roll", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "450"));
        arrLists.add(new FoodModel(R.drawable.roll, "Roll", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "450"));
        arrLists.add(new FoodModel(R.drawable.momos, "Momos", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "150"));
        arrLists.add(new FoodModel(R.drawable.noodle, "Noodles", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "850"));
        arrLists.add(new FoodModel(R.drawable.fast_food1, "Roll", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "350"));
        arrLists.add(new FoodModel(R.drawable.salads, "Salads", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "450"));
        arrLists.add(new FoodModel(R.drawable.roll, "Roll", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "450"));
        arrLists.add(new FoodModel(R.drawable.momos, "Momos", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "150"));
        arrLists.add(new FoodModel(R.drawable.noodle, "Noodles", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "850"));
        arrLists.add(new FoodModel(R.drawable.fast_food1, "Roll", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "350"));
        arrLists.add(new FoodModel(R.drawable.salads, "Salads", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "450"));
        arrLists.add(new FoodModel(R.drawable.roll, "Roll", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "450"));
        arrLists.add(new FoodModel(R.drawable.roll, "Roll", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "450"));

        arrLists.add(new FoodModel(R.drawable.momos, "Momos", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "150"));
        arrLists.add(new FoodModel(R.drawable.noodle, "Noodles", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "850"));
        arrLists.add(new FoodModel(R.drawable.fast_food1, "Roll", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "350"));
        arrLists.add(new FoodModel(R.drawable.salads, "Salads", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "450"));
        arrLists.add(new FoodModel(R.drawable.roll, "Roll", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "450"));
        arrLists.add(new FoodModel(R.drawable.momos, "Momos", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "150"));
        arrLists.add(new FoodModel(R.drawable.noodle, "Noodles", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "850"));
        arrLists.add(new FoodModel(R.drawable.fast_food1, "Roll", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "350"));
        arrLists.add(new FoodModel(R.drawable.salads, "Salads", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "450"));
        arrLists.add(new FoodModel(R.drawable.roll, "Roll", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "450"));
        arrLists.add(new FoodModel(R.drawable.roll, "Roll", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "450"));
        arrLists.add(new FoodModel(R.drawable.momos, "Momos", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "150"));
        arrLists.add(new FoodModel(R.drawable.noodle, "Noodles", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "850"));
        arrLists.add(new FoodModel(R.drawable.fast_food1, "Roll", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "350"));
        arrLists.add(new FoodModel(R.drawable.salads, "Salads", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "450"));
        arrLists.add(new FoodModel(R.drawable.roll, "Roll", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "450"));
        arrLists.add(new FoodModel(R.drawable.momos, "Momos", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "150"));
        arrLists.add(new FoodModel(R.drawable.noodle, "Noodles", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "850"));
        arrLists.add(new FoodModel(R.drawable.fast_food1, "Roll", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "350"));
        arrLists.add(new FoodModel(R.drawable.salads, "Salads", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "450"));
        arrLists.add(new FoodModel(R.drawable.roll, "Roll", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "450"));
        arrLists.add(new FoodModel(R.drawable.roll, "Roll", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "450"));
        arrLists.add(new FoodModel(R.drawable.momos, "Momos", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "150"));
        arrLists.add(new FoodModel(R.drawable.noodle, "Noodles", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "850"));
        arrLists.add(new FoodModel(R.drawable.fast_food1, "Roll", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "350"));
        arrLists.add(new FoodModel(R.drawable.salads, "Salads", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "450"));
        arrLists.add(new FoodModel(R.drawable.roll, "Roll", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "450"));
        arrLists.add(new FoodModel(R.drawable.momos, "Momos", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "150"));
        arrLists.add(new FoodModel(R.drawable.noodle, "Noodles", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "850"));
        arrLists.add(new FoodModel(R.drawable.fast_food1, "Roll", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "350"));
        arrLists.add(new FoodModel(R.drawable.salads, "Salads", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "450"));
        arrLists.add(new FoodModel(R.drawable.roll, "Roll", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "450"));
        arrLists.add(new FoodModel(R.drawable.roll, "Roll", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "450"));
        arrLists.add(new FoodModel(R.drawable.momos, "Momos", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "150"));
        arrLists.add(new FoodModel(R.drawable.noodle, "Noodles", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "850"));
        arrLists.add(new FoodModel(R.drawable.fast_food1, "Roll", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "350"));
        arrLists.add(new FoodModel(R.drawable.salads, "Salads", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "450"));
        arrLists.add(new FoodModel(R.drawable.roll, "Roll", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "450"));
        arrLists.add(new FoodModel(R.drawable.momos, "Momos", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "150"));
        arrLists.add(new FoodModel(R.drawable.noodle, "Noodles", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "850"));
        arrLists.add(new FoodModel(R.drawable.fast_food1, "Roll", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "350"));
        arrLists.add(new FoodModel(R.drawable.salads, "Salads", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "450"));
        arrLists.add(new FoodModel(R.drawable.roll, "Roll", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "450"));
        arrLists.add(new FoodModel(R.drawable.roll, "Roll", "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", "450"));

        FoodAdapter foodAdapter = new FoodAdapter(arrLists, HomePage.this);
        homePageBinding.rvHomepage.setAdapter(foodAdapter);
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(this, 2);
        homePageBinding.rvHomepage.setLayoutManager(linearLayoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.orders) {
            startActivity(new Intent(this, CartDetails.class));
        }
        return super.onOptionsItemSelected(item);
    }
}