package com.omeryildizce.dbjson;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;

import com.omeryildizce.dbjson.models.Result;
import com.omeryildizce.dbjson.restApi.ManagerAll;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DialogClass {
    Activity activity;
    Context context;

    public DialogClass(Activity activity, Context context) {
        this.activity = activity;
        this.context = context;
    }

    public void goster(String id) {

        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_layout, null);
        Button hayirButton = view.findViewById(R.id.btnHayir);
        Button evetButton = view.findViewById(R.id.btEvet);

        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setView(view);
        alert.setCancelable(false);
        AlertDialog alertDialog = alert.create();
        hayirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.cancel();
            }
        });
        evetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<Result> sil = ManagerAll.getInstance().deleteFromDb(id);
                sil.enqueue(new Callback<Result>() {
                    @Override
                    public void onResponse(Call<Result> call, Response<Result> response) {

                    }

                    @Override
                    public void onFailure(Call<Result> call, Throwable t) {

                    }
                });
                alertDialog.cancel();
            }
        });
        alertDialog.show();
    }

}

