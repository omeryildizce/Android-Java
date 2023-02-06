package com.omeryildizce.webservis4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.omeryildizce.webservis4.models.Result;
import com.omeryildizce.webservis4.restApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {
    String id, postId;
    TextView postIdDetail, idDetail, nameDetail, bodyDetail, emailDetail;
    List<Result> liste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tanimla();
        al();
        istek();
    }

    private void istek() {
        liste = new ArrayList<>();
        Call<List<Result>> call = ManagerAll.getInstance().managerGetResult(postId, id);
        call.enqueue(new Callback<List<Result>>() {
            @Override
            public void onResponse(Call<List<Result>> call, Response<List<Result>> response) {
                if (response.isSuccessful()) {
                    liste = response.body();
                    atama(liste);
                }
            }

            @Override
            public void onFailure(Call<List<Result>> call, Throwable t) {

            }
        });
    }

    public void atama(List<Result> list) {
        idDetail.setText(list.get(0).getId()+"");
        postIdDetail.setText(list.get(0).getPostId()+"");
        nameDetail.setText(list.get(0).getName());
        bodyDetail.setText(list.get(0).getBody());
        emailDetail.setText(list.get(0).getEmail());

    }

    public void al() {
        Bundle bundle = getIntent().getExtras();
        id = bundle.getString("id");
        postId = bundle.getString("post_id");

    }

    public void tanimla() {
        idDetail = findViewById(R.id.idDetail);
        postIdDetail = findViewById(R.id.postIdDetail);
        nameDetail = findViewById(R.id.nameDetail);
        emailDetail = findViewById(R.id.emailDetail);
        bodyDetail = findViewById(R.id.bodyDetail);

    }
}