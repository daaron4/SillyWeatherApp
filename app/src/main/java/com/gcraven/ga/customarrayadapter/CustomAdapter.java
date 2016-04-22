package com.gcraven.ga.customarrayadapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context mContext;
    int mLayoutResource;
    ArrayList<ItemData> mList;

    public CustomAdapter(Context context, int layoutResource, ArrayList<ItemData> list){
        super(context, layoutResource, list);
        mContext = context;
        mLayoutResource = layoutResource;
        mList = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;

        View view;
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(mLayoutResource, null);

        TextView textView1 = (TextView)view.findViewById(R.id.day);
        textView1.setText(mList.get(position).getDay());
        TextView textView2 = (TextView)view.findViewById(R.id.high);
        textView2.setText(mList.get(position).getHigh());
        TextView textView3 = (TextView)view.findViewById(R.id.low);
        textView3.setText(mList.get(position).getLow());

        ImageView imageView = (ImageView)view.findViewById(R.id.image);
        imageView.setImageResource(mList.get(position).getImg());


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, Description.class);
                intent.putExtra("high", mList.get(pos).getHigh());
                mContext.startActivity(intent);
            }
        });

        return view;
    }
}