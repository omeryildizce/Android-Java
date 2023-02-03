package com.omeryildizce.activityornekuygulama;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class Adapter extends BaseAdapter {
    List<Model> list;
    Context context;
    Activity activity;

    public Adapter(List<Model> list, Context context, Activity activity) {
        this.list = list;
        this.context = context;
        this.activity = activity;
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
        TextView isim = convertView.findViewById(R.id.isim);
        TextView soyisim = convertView.findViewById(R.id.soyisim);
        TextView numara = convertView.findViewById(R.id.telNo);
        LinearLayout linearLayout = convertView.findViewById(R.id.anaLayout);

        isim.setText(list.get(position).getIsim());
        soyisim.setText(list.get(position).getSoyisim());
        numara.setText(list.get(position).getNumara());

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PersonActivity.class);
                intent.putExtra("isim", isim.getText());
                intent.putExtra("soyisim", soyisim.getText());
                intent.putExtra("numara", numara.getText());
                activity.startActivity(intent);

            }

        });
        return convertView;
    }
}
