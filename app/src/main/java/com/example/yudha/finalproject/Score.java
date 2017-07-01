package com.example.yudha.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Score extends AppCompatActivity {
    int totalScore;
    String Nama;
    TextView score;
    TextView nama;
    Button explain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        intentValue();
        initComponent();
        nama.setText(Nama);
        score.setText(String.valueOf(totalScore));
        explain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Explain.class);
                startActivity(i);
            }
        });
    }

    public void initComponent(){
        score = (TextView)findViewById(R.id.score);
        nama = (TextView)findViewById(R.id.nama);
        explain = (Button)findViewById(R.id.explain);
    }

    public void intentValue(){
        totalScore = getIntent().getExtras().getInt("SCORE");
        Nama = getIntent().getExtras().getString("NAMA");
    }
}
