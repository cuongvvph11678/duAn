package com.example.manhinhchao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
setTitle("Màn Hình Chào");
    }
    public  void  Di(View view)
    {
        Intent intent =new Intent(MainActivity.this,DangNhap.class);
        startActivity(intent);
    }}