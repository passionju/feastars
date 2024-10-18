package com.example.feastarfeed;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class adchart extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> adList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adchart);

        listView = findViewById(R.id.listView);
        adList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, adList);
        listView.setAdapter(adapter);

        // 獲取Firebase實例
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference notagRef = database.getReference("TotalWatch/Advertise/notag");
        DatabaseReference withtagRef = database.getReference("TotalWatch/Advertise/withtag");

        // 監聽notag節點的變化
        notagRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                adList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    adList.add(snapshot.getKey());
                }

                // 監聽withtag節點的變化
                withtagRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        //adList.clear();
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            adList.add(snapshot.getKey());
                        }
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        // 處理錯誤
                    }
                });

                //adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // 處理錯誤
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedAd = adList.get(position);
                Intent intent = new Intent(adchart.this, PieChartActivity.class);
                intent.putExtra("selectedAd", selectedAd);
                startActivity(intent);
            }
        });

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(adchart.this, superuser.class);
                startActivity(intent);
                finish();
            }
        });

    }
}