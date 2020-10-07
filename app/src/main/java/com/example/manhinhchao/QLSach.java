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
import com.example.manhinhchao.Adapter.AdapterSach;
import com.example.manhinhchao.DAOSQL.NguoiDungDao;
import com.example.manhinhchao.DAOSQL.SachDao;
import com.example.manhinhchao.SQL.MySQL;

import java.util.List;

import Model.NguoiDung;
import Model.Sach;
import ThemMoi.ThemSach;

public class QLSach extends AppCompatActivity {
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_l_sach);
        setTitle("Quản Lý Sách");
        listView = findViewById(R.id.lvsach);
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
            View view = LayoutInflater.from(this).inflate(R.layout.add_sach, null);
            builder.setView(view);
            final EditText edtmasach= view.findViewById(R.id.masach);
            final EditText edttheloai= view.findViewById(R.id.theloai);
            final EditText edttacgia = view.findViewById(R.id.tacgia);
            final EditText edtnxb = view.findViewById(R.id.NXB);
            final EditText edtsoluong = view.findViewById(R.id.soluong);
            final EditText edtgiaban = view.findViewById(R.id.giaban);

            Button them = view.findViewById(R.id.anh);
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
                    Sach sach =new Sach();
//                    nguoiDung.setUserName(edtusername.getText().toString());
//                    nguoiDung.setHoTen(edthoten.getText().toString());
//                    nguoiDung.setPassWord(edtpassword.getText().toString());
//                    nguoiDung.setPhone(edtphone.getText().toString());
                    sach.maSach = edtmasach.getText().toString().trim();
                    sach.maTheLoai = edttheloai.getText().toString().trim();
                    sach.tacGia = edttacgia.getText().toString().trim();
                    sach.NXB = edtnxb.getText().toString().trim();
//                    sach.soLuong = edtsoluong.getText().toString().trim();
//                    sach.giaBan = edtgiaban.getText().toString().trim();
//                    checkEmpty(nguoiDung.userName,edtusername);
//                    checkEmpty(nguoiDung.passWord, edtpassword);
//                    checkEmpty(nguoiDung.phone, edtphone);
//                    checkEmpty(nguoiDung.hoTen,edthoten);
                    MySQL mySQL = new MySQL(QLSach.this);
                    SachDao sachDao = new SachDao(mySQL);

                    boolean ketQua = sachDao.LuuSach(sach);
                    if (!ketQua) {
                        Toast.makeText(QLSach.this,
                                "KHONG THANH CONG!!!", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(QLSach.this,
                                "THANH CONG!!!", Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();
                        List<Sach> nguoiDungList = sachDao.getallSach();
                        AdapterSach nguoiDungAdapter = new AdapterSach(nguoiDungList);
                        listView.setAdapter(nguoiDungAdapter);

                    }
                }
            });
        }


        else if(item.getItemId()==R.id.thoat){
            Intent intent =new Intent(QLSach.this, Menu.class);
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