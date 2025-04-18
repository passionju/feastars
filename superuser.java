package com.example.feastarfeed;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class superuser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.superuser);

        Button button1 = findViewById(R.id.button1);//返回
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(superuser.this, login.class);
                startActivity(intent);
                finish();
            }
        });

        Button button2 = findViewById(R.id.button2);//近期熱門tag
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(superuser.this, barchart.class);
                startActivity(intent);
                finish();
            }
        });

        Button button3 = findViewById(R.id.button3);//近期熱門店家
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(superuser.this, shopbarchart.class);
                startActivity(intent);
                finish();
            }
        });

        Button button4 = findViewById(R.id.button4);//最受喜愛tag
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(superuser.this, favoritebarchart.class);
                startActivity(intent);
                finish();
            }
        });

        Button button5 = findViewById(R.id.button5);//廣告瀏覽狀況
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(superuser.this, adchart.class);
                startActivity(intent);
                finish();
            }
        });

        Button button6 = findViewById(R.id.button6);//調整喜好參數
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(superuser.this, shopbarchart.class);
                startActivity(intent);
                finish();
            }
        });

    }
}