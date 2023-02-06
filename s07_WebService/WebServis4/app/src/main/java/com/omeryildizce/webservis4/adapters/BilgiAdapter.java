package com.omeryildizce.webservis4.adapters;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.omeryildizce.webservis4.DetailActivity;
import com.omeryildizce.webservis4.R;
import com.omeryildizce.webservis4.models.Bilgi;

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
        LinearLayout layoutList = convertView.findViewById(R.id.layoutList);

        TextView postId = convertView.findViewById(R.id.postId);
        TextView id = convertView.findViewById(R.id.id);
        TextView name = convertView.findViewById(R.id.name);
        TextView email = convertView.findViewById(R.id.email);
        TextView body = convertView.findViewById(R.id.body);

        postId.setText(bilgiList.get(position).getPostId()+"");
        id.setText(bilgiList.get(position).getId()+"");
        name.setText(bilgiList.get(position).getName());
        email.setText(bilgiList.get(position).getEmail());
        body.setText(bilgiList.get(position).getBody());
        String post = bilgiList.get(position).getPostId() + "";
        String idm = bilgiList.get(position).getId()+"";
        layoutList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("post_id", post);
                intent.putExtra("id", idm);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}