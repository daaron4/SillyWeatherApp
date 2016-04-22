package com.gcraven.ga.customarrayadapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Description extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Intent intent = getIntent();
        String temp = intent.getStringExtra("high");

        int high = Integer.parseInt(temp.substring(6,8));

        TextView textView = (TextView) findViewById(R.id.text_view);

        if (high >= 80) {
            textView.setText(high + ", Dats hot yo!");
        }
        else if (high >= 60) {
            textView.setText(high + ", Dats not so bad yo!");
        }
        else if (high >= 40) {
            textView.setText(high + ", Dats cold yo!");
        }
        else {
            textView.setText(high + ", Dats supa cold yo!");
        }

    }
}
