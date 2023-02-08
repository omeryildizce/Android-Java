package com.omeryildizce.urunlerilisteleme.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.omeryildizce.urunlerilisteleme.R;
import com.omeryildizce.urunlerilisteleme.models.Urunler;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UrunAdapter extends BaseAdapter {
    List<Urunler> list;
    Context context;

    public UrunAdapter(List<Urunler> list, Context context) {
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
        ImageView urunResmi;
        TextView urunadi, urunfiyati, urunid;
        urunResmi = convertView.findViewById(R.id.urunResmi);
        urunid = convertView.findViewById(R.id.id);
        urunadi = convertView.findViewById(R.id.urunismi);
        urunfiyati = convertView.findViewById(R.id.urunfiyati);

         urunfiyati.setText("Ürün  Fiyatı: "+list.get(position).getUrunfiyati());
        urunadi.setText("Ürün Adı: "+list.get(position).getUrunadi());
        urunid.setText("Ürün id "+list.get(position).getId());
        Picasso.get().load("http://10.0.2.2/proje/resimler/"+list.get(position).getUrunresimi()).into(urunResmi);
        return convertView;
    }
}
