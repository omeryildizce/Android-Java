package com.omeryildizce.mylistview2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MesajAdapter extends BaseAdapter {
    List<MesajModel> list;
    Context context;

    public MesajAdapter(List<MesajModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View layout = LayoutInflater.from(context).inflate(R.layout.layout, parent, false);
        ImageView image = layout.findViewById(R.id.kisiResmi);
        TextView name = layout.findViewById(R.id.kisiIsım);
        TextView message = layout.findViewById(R.id.mesaj);

        image.setImageResource(list.get(position).getResimId());
        name.setText(list.get(position).getKisi());
        message.setText(list.get(position).getMesajIcerik());


        return layout;
    }
}
