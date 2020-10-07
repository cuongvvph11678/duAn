package com.example.manhinhchao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DangNhap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
setTitle("Đăng Nhập");
    }
    public  void Dangnhap(View view){
        Intent intent =new Intent(DangNhap.this,Menu.class);
        startActivity(intent);
    }
    public  void Dangki(View view){
        Intent intent =new Intent(DangNhap.this,DangKi.class);
        startActivity(intent);
    }
}