package com.gcraven.ga.customarrayadapter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    CustomAdapter adapter;
    ArrayList<ItemData> arrayList = new ArrayList<>();
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                count++;
                Random random = new Random();
                int temp1 = random.nextInt(101);
                int temp2 = random.nextInt(101);
                ItemData itemData;

                if (temp1 > temp2) {
                    if (temp1 >= 80) {
                        itemData= new ItemData("Next Day", "High: " + temp1, "Low: " + temp2, R.drawable.hot);
                    }
                    else if (temp1 >= 60) {
                        itemData= new ItemData("Next Day", "High: " + temp1, "Low: " + temp2, R.drawable.cloud);
                    }
                    else if (temp1 >= 40) {
                        itemData= new ItemData("Next Day", "High: " + temp1, "Low: " + temp2, R.drawable.rain);
                    }
                    else {
                        itemData= new ItemData("Next Day", "High: " + temp1, "Low: " + temp2, R.drawable.severe);
                    }
                }
                else {
                    if (temp2 >= 80) {
                        itemData= new ItemData("Next Day", "High: " + temp2, "Low: " + temp1, R.drawable.hot);
                    }
                    else if (temp2 >= 60) {
                        itemData= new ItemData("Next Day", "High: " + temp2, "Low: " + temp1, R.drawable.cloud);
                    }
                    else if (temp2 >= 40) {
                        itemData= new ItemData("Next Day", "High: " + temp2, "Low: " + temp1, R.drawable.rain);
                    }
                    else {
                        itemData= new ItemData("Next Day", "High: " + temp2, "Low: " + temp1, R.drawable.severe);
                    }
                }
                
                arrayList.add(itemData);
                adapter.notifyDataSetChanged();

            }
        });

        ItemData mon = new ItemData("Monday", "High: 56", "Low: 16", R.drawable.rain);
        ItemData tues = new ItemData("Tuesday", "High: 100", "Low: 80", R.drawable.hot);
        ItemData wed = new ItemData("Wednesday", "High: 60", "Low: 45", R.drawable.cloud);
        ItemData thurs = new ItemData("Thursday", "High: 20", "Low: 10", R.drawable.severe);
        ItemData fri = new ItemData("Friday", "High: 90", "Low: 80", R.drawable.hot);

        arrayList.add(mon);
        arrayList.add(tues);
        arrayList.add(wed);
        arrayList.add(thurs);
        arrayList.add(fri);

        ListView listView = (ListView) findViewById(R.id.listView);
        adapter = new CustomAdapter(this, R.layout.list_item, arrayList);
        listView.setAdapter(adapter);

    }


}
