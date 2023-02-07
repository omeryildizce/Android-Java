package com.omeryildizce.dbjson.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.omeryildizce.dbjson.DialogClass;
import com.omeryildizce.dbjson.R;
import com.omeryildizce.dbjson.models.Kullanici;

import java.util.List;

public class KullaniciAdapter extends BaseAdapter {
    List<Kullanici> list;
    Context context;
    Activity activity;

    public KullaniciAdapter(List<Kullanici> list, Context context, Activity activity) {
        this.list = list;
        this.context = context;
        this.activity = activity;
    }

    public KullaniciAdapter(List<Kullanici> list, Context context) {
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
        convertView = LayoutInflater.from(context).inflate(R.layout.layout, parent, false);
        TextView id = convertView.findViewById(R.id.id);
        TextView isim = convertView.findViewById(R.id.isim);
        TextView soyisim = convertView.findViewById(R.id.soyisim);
        id.setText(list.get(position).getId());
        isim.setText(list.get(position).getIsim());
        soyisim.setText(list.get(position).getSoyisim());
        return convertView;
    }
}
