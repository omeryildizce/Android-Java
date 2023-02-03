package com.omeryildizce.mesajgonderme;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {
    List<Model> list;
    Context context;

    public Adapter(List<Model> list, Context context) {
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
        convertView = LayoutInflater.from(context).inflate(R.layout.mesaj_layout, parent, false);
        EditText mesaj = convertView.findViewById(R.id.mesajIcerik);
        TextView isim = convertView.findViewById(R.id.isimMl);
        TextView numara = convertView.findViewById(R.id.numaraMl);
        Button gonder = convertView.findViewById(R.id.buttonMl);
        isim.setText(list.get(position).getIsim());
        numara.setText(list.get(position).getTelefon());
        gonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = mesaj.getText().toString();
                 Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:"+ list.get(position).getTelefon()));
                 intent.putExtra("sms_body", message);
                 context.startActivity(intent);
            }
        });
        return convertView;
    }
}
