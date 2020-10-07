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

import com.example.manhinhchao.Adapter.AdapterHD;
import com.example.manhinhchao.Adapter.AdapterND;
import com.example.manhinhchao.DAOSQL.HoaDonDao;
import com.example.manhinhchao.DAOSQL.NguoiDungDao;
import com.example.manhinhchao.SQL.MySQL;

import java.util.List;

import Model.HoaDon;
import Model.NguoiDung;
import ThemMoi.ThemHoaDon;

public class QLHoaDon extends AppCompatActivity {
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_l_hoa_don);
        setTitle("Quản Lý Hóa Đơn");
        listView =findViewById(R.id.lvhd);
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
            View view = LayoutInflater.from(this).inflate(R.layout.add_hd, null);
            builder.setView(view);
            final EditText edtmahd = view.findViewById(R.id.userName);
            final EditText edtngay = view.findViewById(R.id.passWord);

            Button themhd = view.findViewById(R.id.them);
            Button huyhd = view.findViewById(R.id.huy);
            final AlertDialog alertDialog = builder.show();
            huyhd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialog.dismiss();
                }
            });


            themhd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    HoaDon hoaDon =new HoaDon();

                    hoaDon.maHoaDon = edtmahd.getText().toString().trim();

                   // hoaDon.ngayMua = edtngay.getText().toString().trim();

                    checkEmpty(hoaDon.maHoaDon,edtmahd);
                   // checkEmpty(hoaDon.ngayMua,edtngay);

                    MySQL mySQL = new MySQL(QLHoaDon.this);
                    HoaDonDao hoaDonDao =new HoaDonDao(mySQL);

                    boolean ketQua = hoaDonDao.LuuHD(hoaDon);
                    if (!ketQua) {
                        Toast.makeText(QLHoaDon.this,
                                "KHONG THANH CONG!!!", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(QLHoaDon.this,
                                "THANH CONG!!!", Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();
                        List<HoaDon> nguoiDungList = hoaDonDao.getallHD();
                        AdapterHD nguoiDungAdapter = new AdapterHD(nguoiDungList);
                        listView.setAdapter(nguoiDungAdapter);

                    }
                }
            });
        }


        else if(item.getItemId()==R.id.thoat){
            Intent intent =new Intent(QLHoaDon.this, Menu.class);
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