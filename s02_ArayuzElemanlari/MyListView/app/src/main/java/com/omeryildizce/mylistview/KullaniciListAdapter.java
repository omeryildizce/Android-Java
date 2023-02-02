package com.omeryildizce.mylistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class KullaniciListAdapter extends BaseAdapter {
    List<KullaniciModel> list;
    Context context;
    public KullaniciListAdapter(List<KullaniciModel> list, Context context) {
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
        TextView ad = layout.findViewById(R.id.isim);
        TextView soyad = layout.findViewById(R.id.soyisim);
        TextView yas = layout.findViewById(R.id.yas);
        TextView takim = layout.findViewById(R.id.takim);
        ad.setText(list.get(position).getIsim());
        soyad.setText(list.get(position).getSoyisim());
        yas.setText(list.get(position).getYas());
        takim.setText(list.get(position).getTuttuguTakim());
        return layout;
    }
}
