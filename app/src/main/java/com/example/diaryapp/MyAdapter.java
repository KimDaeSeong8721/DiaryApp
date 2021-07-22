package com.example.diaryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<cultureData> sample;

    public MyAdapter(Context context, ArrayList<cultureData> data) {
        mContext = context;
        sample = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return sample.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public cultureData getItem(int position) {
        return sample.get(position);
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.list_element, null);

        TextView cultureName = (TextView)view.findViewById(R.id.cultureName);
        TextView cultureLocation = (TextView)view.findViewById(R.id.cultureLocation);


        cultureName.setText(sample.get(position).getCultureName());
        cultureLocation.setText(sample.get(position).getCulutreLocation());

        return view;
    }
}
