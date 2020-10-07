package com.example.manhinhchao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.manhinhchao.Adapter.AdapterND;
import com.example.manhinhchao.Adapter.AdapterTL;
import com.example.manhinhchao.DAOSQL.NguoiDungDao;
import com.example.manhinhchao.DAOSQL.TheLoaiDao;
import com.example.manhinhchao.SQL.MySQL;

import java.util.ArrayList;
import java.util.List;

import Model.NguoiDung;
import Model.TheLoai;
import ThemMoi.ThemTheLoai;

public class QLTheLoai extends AppCompatActivity {
ListView lvlist;
    List<TheLoai> productList;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_l_the_loai);
        setTitle("Quản Lý Thể Loại");


        MySQL mySQL = new MySQL(QLTheLoai.this);
        TheLoaiDao theLoaiDao = new TheLoaiDao(mySQL);
        lvlist = findViewById(R.id.lvtl);



//        productList = new ArrayList<>();
//
//        productList = theLoaiDao.getallTL();
//        AdapterTL a = new AdapterTL(productList);
//        lvlist.setAdapter(a);

    }







    @Override
    public  boolean onCreateOptionsMenu(android.view.Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return  super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.them){

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View view = LayoutInflater.from(this).inflate(R.layout.add_tl, null);
            builder.setView(view);
            final EditText edtma = view.findViewById(R.id.userName);
            final EditText edtten = view.findViewById(R.id.passWord);
            final EditText edtvitri = view.findViewById(R.id.phone);
            final EditText edtmota = view.findViewById(R.id.hoTen);

            Button them = view.findViewById(R.id.them);
            Button huy = view.findViewById(R.id.huy);
            final AlertDialog alertDialog = builder.show();
            huy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialog.dismiss();
                }
            });

            them.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TheLoai theLoai =new TheLoai();
                    theLoai.maTheLoai = edtma.getText().toString().trim();
                    theLoai.tenTheLoai= edtten.getText().toString().trim();
                    theLoai.moTa = edtmota.getText().toString().trim();
                   // theLoai.viTri = edtvitri.getText()..trim();
                    checkEmpty(theLoai.maTheLoai,edtma);
                    checkEmpty(theLoai.tenTheLoai,edtten);
                    checkEmpty(theLoai.moTa,edtmota);
                   // checkEmpty(nguoiDung.hoTen,edthoten);
                    MySQL mySQL = new MySQL(QLTheLoai.this);
                    TheLoaiDao theLoaiDao = new TheLoaiDao(mySQL);

                    boolean ketQua = theLoaiDao.LuuTL(theLoai);
                    if (!ketQua) {
                        Toast.makeText(QLTheLoai.this,
                                "KHONG THANH CONG!!!", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(QLTheLoai.this,
                                "THANH CONG!!!", Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();
                        List<TheLoai> theLoaiList = theLoaiDao.getallTL();
                        AdapterTL adapterTL = new AdapterTL(theLoaiList);
                        lvlist.setAdapter(adapterTL);

                    }
                }
            });

        }
        else if(item.getItemId()==R.id.thoat){
            Intent intent =new Intent(QLTheLoai.this, Menu.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
    public void checkEmpty(String data, EditText edt) {
        if (data.isEmpty()) {
            edt.setError("Nhap du thong tin...");
            return;
        }
    }
}