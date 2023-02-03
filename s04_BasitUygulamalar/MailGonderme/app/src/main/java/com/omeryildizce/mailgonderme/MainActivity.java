package com.omeryildizce.mailgonderme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText konu;
    EditText mail;
    EditText icerik;
    Button gonder;
    String konuText, icerikText, mailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        mailGonder();
    }

    private void mailGonder() {
        gonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                bilgiAl();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, mailText);
                intent.putExtra(Intent.EXTRA_SUBJECT, konuText);
                intent.putExtra(Intent.EXTRA_TEXT, icerikText);
                startActivity(Intent.createChooser(intent, "Mail Gönderiniz!"));
                }catch(Exception e)
                {
                    Log.e("Mesaj", "Mail gönderirken bir hata oluştu;");
                }
            }
        });
    }

    private void bilgiAl() {
        icerikText = icerik.getText().toString();
        mailText = mail.getText().toString();
        konuText = konu.getText().toString();

    }

    private void tanimla() {
        icerik = findViewById(R.id.etMailIcerik);
        konu = findViewById(R.id.etMailKonu);
        mail = findViewById(R.id.etMailAdress);
        gonder = findViewById(R.id.mailAt);


    }
}