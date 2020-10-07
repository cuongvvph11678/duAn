package com.example.manhinhchao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DangKi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki);
        setTitle("Đăng Kí");
    }
    public  void DK(View view){
        Intent intent =new Intent(DangKi.this,DangNhap.class);
        startActivity(intent);
    }
    public  void Huy(View view){
        Intent intent =new Intent(DangKi.this,DangNhap.class);
        startActivity(intent);
    }
}