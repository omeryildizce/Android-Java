package com.omeryildizce.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();

    }

    private void dialogAc() {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.alert_layout, null, false);
        EditText etMail = view.findViewById(R.id.mailadresi);
        EditText etName = view.findViewById(R.id.kullanici);
        EditText etSifre = view.findViewById(R.id.sifre);
        Button buttonUyeOl = view.findViewById(R.id.btnUyeOl);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setView(view);
        alert.setCancelable(false);
        AlertDialog dialog = alert.create();
        buttonUyeOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, String.format("%s %s", etMail.getText(), etName.getText()), Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        dialog.show();
    }



    private void tanimla() {
        button = findViewById(R.id.btDialogAc);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAc();
            }
        });
    }
}