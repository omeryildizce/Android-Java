package com.omeryildizce.realminsert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class Adapter extends BaseAdapter {
    List<KisiBilgileri> list;
    Context context;

    public Adapter(List<KisiBilgileri> list, Context context) {
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
        TextView isim = convertView.findViewById(R.id.tvKullaniciIsim);
        TextView kullaniciAdi = convertView.findViewById(R.id.tvKullaniciAdi);
        TextView sifre = convertView.findViewById(R.id.tvKullaniciSifre);
        TextView cisiyet = convertView.findViewById(R.id.tvKullaniciCinsiyet);
        isim.setText(list.get(position).getIsim());
        kullaniciAdi.setText(list.get(position).getKullanici());
        sifre.setText(list.get(position).getSifre());
        cisiyet.setText(list.get(position).getCinsiyet());
        return convertView;
    }
}
