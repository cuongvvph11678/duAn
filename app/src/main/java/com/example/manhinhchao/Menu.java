package com.example.manhinhchao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setTitle("MENU");
    }
    public void NguoiDung(View view){
        Intent intent =new Intent(Menu.this,QLNguoiDung.class);
        startActivity(intent);
    }
    public void TheLoai(View view){
        Intent intent =new Intent(Menu.this,QLTheLoai.class);
        startActivity(intent);
    }
    public void Sach(View view){
        Intent intent =new Intent(Menu.this,QLSach.class);
        startActivity(intent);
    }
    public void HoaDon(View view){
        Intent intent =new Intent(Menu.this,QLHoaDon.class);
        startActivity(intent);
    }
    public void BanChay(View view){
        Intent intent =new Intent(Menu.this,QLSachBanChay.class);
        startActivity(intent);
    }
    public void ThongKe(View view){
        Intent intent =new Intent(Menu.this,QLThongKe.class);
        startActivity(intent);
    }

}