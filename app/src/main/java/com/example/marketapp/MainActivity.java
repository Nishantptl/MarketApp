package com.example.marketapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    RecyclerView recyclerView;

    List<item> itemList;

    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        itemList = new ArrayList<>();
        item i1 = new item(R.drawable.fruit, "Fruits", "Eat Fresh fruits ");
        item i2 = new item(R.drawable.vegitables, "Vegetables", "Delicious Vegetables");
        item i3 = new item(R.drawable.beverage, "Beverage", "Juice, Tea and Coffee");
        item i4 = new item(R.drawable.bread, "Bakery", "Bread, Wheat and Beans");
        item i5 = new item(R.drawable.milk, "Milk", "Milk, shakes and Yogurt");
        item i6 = new item(R.drawable.popcorn, "Popcorn", "Pop corn and Donuts");

        itemList.add(i1);
        itemList.add(i2);
        itemList.add(i3);
        itemList.add(i4);
        itemList.add(i5);
        itemList.add(i6);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        myAdapter = new MyAdapter(itemList);
        recyclerView.setAdapter(myAdapter);
        myAdapter.setClickListener(this);

    }

    @Override
    public void onClick(View v, int pos) {
        Toast.makeText(this, "You choose : " +itemList.get(pos).getItemName(), Toast.LENGTH_SHORT).show();
    }
}
