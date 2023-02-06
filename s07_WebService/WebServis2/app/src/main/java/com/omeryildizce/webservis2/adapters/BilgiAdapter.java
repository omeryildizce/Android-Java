package com.omeryildizce.webservis2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.omeryildizce.webservis2.R;
import com.omeryildizce.webservis2.models.Bilgi;

import java.util.List;

public class BilgiAdapter extends BaseAdapter {
    List<Bilgi> bilgiList;
    Context context;

    public BilgiAdapter(List<Bilgi> bilgiList, Context context) {
        this.bilgiList = bilgiList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return bilgiList.size();
    }

    @Override
    public Object getItem(int position) {
        return bilgiList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.layout, parent, false);
        TextView id = convertView.findViewById(R.id.id);
        TextView userId = convertView.findViewById(R.id.userId);
        TextView title = convertView.findViewById(R.id.title);
        CheckBox completed = convertView.findViewById(R.id.completed);
        title.setText(bilgiList.get(position).getTitle());
        id.setText(id.getText().toString() + bilgiList.get(position).getId());
        userId.setText(userId.getText().toString() + bilgiList.get(position).getUserId());

        Boolean deger = bilgiList.get(position).getCompleted();
        if (deger == true) {
            completed.setChecked(deger);
        } else {
            completed.setChecked(deger);
        }
        return convertView;
    }
}
