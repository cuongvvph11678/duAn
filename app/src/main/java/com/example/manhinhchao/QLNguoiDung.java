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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.manhinhchao.Adapter.AdapterND;
import com.example.manhinhchao.DAOSQL.NguoiDungDao;
import com.example.manhinhchao.SQL.MySQL;

import java.util.ArrayList;
import java.util.List;

import Model.NguoiDung;

public class QLNguoiDung extends AppCompatActivity {
ListView lvlist;
List<NguoiDung> productList;
ImageView xoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_l_nguoi_dung);
        setTitle("Quản Lý Người Dùng");

        MySQL mySQL = new MySQL(QLNguoiDung.this);
        NguoiDungDao nguoiDungDao = new NguoiDungDao(mySQL);
        lvlist = findViewById(R.id.lvnguoidung);
        xoa= findViewById(R.id.anh);


        productList = new ArrayList<>();

        productList = nguoiDungDao.getallND();
        AdapterND a = new AdapterND(productList);
        lvlist.setAdapter(a);


//
//        lvlist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                NguoiDung quanly = productList.get(position);
//                MySQL mySQL = new MySQL(QLNguoiDung.this);
//                NguoiDungDao nguoiDungDao = new NguoiDungDao(mySQL);
//
//                nguoiDungDao.deleteND(quanly.getUserName());
//                productList.clear();
//                productList = nguoiDungDao.getallND();
//                AdapterND a = new AdapterND(productList);
//                lvlist.setAdapter(a);
//                Toast.makeText(QLNguoiDung.this,"Xoa Thanh Cong",Toast.LENGTH_LONG).show();
//                return true;
//
//            }
//        });
//


    }

    @Override
    public  boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return  super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.them) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View view = LayoutInflater.from(this).inflate(R.layout.add_nd, null);
            builder.setView(view);
            final EditText edtusername = view.findViewById(R.id.userName);
            final EditText edtpassword = view.findViewById(R.id.passWord);
            final EditText edtphone = view.findViewById(R.id.phone);
            final EditText edthoten = view.findViewById(R.id.hoTen);
            Button button3 = view.findViewById(R.id.anh);
            Button button4 = view.findViewById(R.id.huy);
            final AlertDialog alertDialog = builder.show();
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialog.dismiss();
                }
            });


            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NguoiDung nguoiDung = new NguoiDung();
//                    nguoiDung.setUserName(edtusername.getText().toString());
//                    nguoiDung.setHoTen(edthoten.getText().toString());
//                    nguoiDung.setPassWord(edtpassword.getText().toString());
//                    nguoiDung.setPhone(edtphone.getText().toString());
                    nguoiDung.userName = edtusername.getText().toString().trim();
                    nguoiDung.hoTen = edthoten.getText().toString().trim();
                    nguoiDung.passWord = edtpassword.getText().toString().trim();
                    nguoiDung.phone = edtphone.getText().toString().trim();
                    checkEmpty(nguoiDung.userName,edtusername);
                    checkEmpty(nguoiDung.passWord, edtpassword);
                    checkEmpty(nguoiDung.phone, edtphone);
                    checkEmpty(nguoiDung.hoTen,edthoten);
                    MySQL mySQL = new MySQL(QLNguoiDung.this);
                    NguoiDungDao userDAO = new NguoiDungDao(mySQL);

                    boolean ketQua = userDAO.LuuND(nguoiDung);
                      if (ketQua) {
                          Toast.makeText(QLNguoiDung.this,
                                  "THANH CONG!!!", Toast.LENGTH_SHORT).show();
                          alertDialog.dismiss();
                          List<NguoiDung> nguoiDungList = userDAO.getallND();
                          AdapterND nguoiDungAdapter = new AdapterND(nguoiDungList);
                          lvlist.setAdapter(nguoiDungAdapter);

                     } else {
                          Toast.makeText(QLNguoiDung.this,
                                  "KHONG THANH CONG!!!", Toast.LENGTH_SHORT).show();


                     }
                }
            });
            }
                if(item.getItemId()==R.id.thoat){
                Intent intent =new Intent(QLNguoiDung.this,Menu.class);
                startActivity(intent);
            }
            return super.onOptionsItemSelected(item);
        }

        public void checkEmpty(String data, EditText edt) {
            if (data.isEmpty()) {
                edt.setError("Nhap du thong tin...");
                return ;
            }
        }


    }
