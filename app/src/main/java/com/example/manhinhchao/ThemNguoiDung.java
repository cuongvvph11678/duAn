package com.example.manhinhchao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.manhinhchao.DAOSQL.NguoiDungDao;
import com.example.manhinhchao.SQL.MySQL;

import Model.NguoiDung;

public class ThemNguoiDung extends AppCompatActivity {
EditText user,pass,sdt,ten,pass2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_nguoi_dung);
        setTitle("Thêm Người Dùng");
        user =findViewById(R.id.userName);
        pass =findViewById(R.id.passWord);
        sdt =findViewById(R.id.phone);
        ten =findViewById(R.id.hoTen);

    }

    public  void  Huynd(View view){
        Intent intent =new Intent(ThemNguoiDung.this,QLNguoiDung.class);
        startActivity(intent);
    }
    public void Luu (View view){

        NguoiDung quanly = new NguoiDung();
        quanly.setUserName(user.getText().toString());
        quanly.setPassWord(pass.getText().toString());
        quanly.setHoTen(ten.getText().toString());
        quanly.setPhone(sdt.getText().toString());

        MySQL mySQL = new MySQL(ThemNguoiDung.this);
        NguoiDungDao nguoiDungDao = new NguoiDungDao(mySQL);

        nguoiDungDao.LuuND(quanly);


        Toast.makeText(ThemNguoiDung.this,"Thêm thành công",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ThemNguoiDung.this,QLNguoiDung.class);
        startActivity(intent);
    }
}