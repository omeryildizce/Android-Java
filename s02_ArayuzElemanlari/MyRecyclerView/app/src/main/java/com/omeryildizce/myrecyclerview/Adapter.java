package com.omeryildizce.myrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Tanimla>{
    List<MesajModel> list;
    Context context;

    public Adapter(List<MesajModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Tanimla onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout, parent, false);

        return new Tanimla(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Tanimla holder, int position) {
        holder.message.setText(list.get(position).getMessage());
        holder.name.setText(list.get(position).getName());
        holder.image.setImageResource(list.get(position).getResimId());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class Tanimla extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        TextView message;
        public Tanimla(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            message = itemView.findViewById(R.id.message);
        }
    }
}
