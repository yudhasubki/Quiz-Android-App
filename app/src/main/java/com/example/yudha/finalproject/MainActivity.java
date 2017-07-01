package com.example.yudha.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox no2a, no2b, no2c, no2d;
    RadioButton no1a;
    RadioButton no3c;
    RadioButton no4a;
    RadioButton no5d;
    EditText nama;
    Boolean jawaban1, jawaban3, jawaban4, jawaban5;
    int score1, score2, score3, score4, score5;
    Boolean jawaban2a, jawaban2b, jawaban2c, jawaban2d;
    int total, totalNilai;
    String Nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
    }

    public void initComponent() {
        no1a = (RadioButton) findViewById(R.id.no1a);
        no2a = (CheckBox) findViewById(R.id.no2a);
        no2b = (CheckBox) findViewById(R.id.no2b);
        no2c = (CheckBox) findViewById(R.id.no2c);
        no2d = (CheckBox) findViewById(R.id.no2d);
        no3c = (RadioButton) findViewById(R.id.no3c);
        no4a = (RadioButton) findViewById(R.id.no4a);
        no5d = (RadioButton) findViewById(R.id.no5d);
        nama = (EditText) findViewById(R.id.nama);
    }

    public void jawab(View v) {
        Nama = nama.getText().toString();
        jawaban1 = no1a.isChecked();
        if (jawaban1) {
            score1 = 1;
        } else {
            score1 = 0;
        }

        jawaban2a = no2a.isChecked();
        jawaban2b = no2b.isChecked();
        jawaban2c = no2c.isChecked();
        jawaban2d = no2d.isChecked();
        if (!jawaban2a && jawaban2b && !jawaban2c && jawaban2d) {
            score2 = 1;
        } else {
            score2 = 0;
        }

        jawaban3 = no3c.isChecked();
        if (jawaban3) {
            score3 = 1;
        } else {
            score3 = 0;
        }

        jawaban4 = no4a.isChecked();
        if (jawaban4) {
            score4 = 1;
        } else {
            score4 = 0;
        }

        jawaban5 = no5d.isChecked();
        if (jawaban5) {
            score5 = 1;
        } else {
            score5 = 0;
        }

        total = score1 + score2 + score3 + score4 + score5;
        if (Nama.equals("")) {
            Toast.makeText(this, "Harap Isi Nama Terlebih Dahulu", Toast.LENGTH_SHORT).show();
        } else {
            if (total == 5) {
                Toast.makeText(this, "Selamat Nilai Anda 100!", Toast.LENGTH_SHORT).show();
                totalNilai = 100;
                totalNilai(totalNilai, Nama);
            } else if (total == 4) {
                Toast.makeText(this, "Selamat Nilai Anda 80!", Toast.LENGTH_SHORT).show();
                totalNilai = 80;
                totalNilai(totalNilai, Nama);
            } else if (total == 3) {
                Toast.makeText(this, "Selamat Nilai Anda 60!", Toast.LENGTH_SHORT).show();
                totalNilai = 60;
                totalNilai(totalNilai, Nama);
            } else if (total == 2) {
                Toast.makeText(this, "Selamat Nilai Anda 40!", Toast.LENGTH_SHORT).show();
                totalNilai = 40;
                totalNilai(totalNilai, Nama);
            } else if (total == 1) {
                Toast.makeText(this, "Selamat Nilai Anda 20!", Toast.LENGTH_SHORT).show();
                totalNilai = 20;
                totalNilai(totalNilai, Nama);
            } else {
                Toast.makeText(this, "Gagal! Nilai Anda 0", Toast.LENGTH_SHORT).show();
                totalNilai = 0;
                totalNilai(totalNilai, Nama);
            }
        }
    }

    public void totalNilai(int totalnilai, String namaAnda) {
        Intent i = new Intent(this, Score.class);
        i.putExtra("SCORE", totalnilai);
        i.putExtra("NAMA", namaAnda);
        startActivity(i);
        finish();
    }
}
