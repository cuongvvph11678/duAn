package com.example.manhinhchao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.manhinhchao.Adapter.AdapterND;
import com.example.manhinhchao.DAOSQL.NguoiDungDao;
import com.example.manhinhchao.SQL.MySQL;

import java.util.ArrayList;
import java.util.List;

import Model.NguoiDung;

public class QLSachBanChay extends AppCompatActivity {
ListView lvlist;
   List<NguoiDung> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_l_sach_ban_chay);
        setTitle("Quản Lý Bán Chạy");
        lvlist = findViewById(R.id.lvbanchay);
        EditText edtTim = findViewById(R.id.tim);
        MySQL mySQL = new MySQL(QLSachBanChay.this);
        final NguoiDungDao nguoiDungDao = new NguoiDungDao(mySQL);
        productList = new ArrayList<>();

        productList = nguoiDungDao.getallND();
        AdapterND a = new AdapterND(productList);
        lvlist.setAdapter(a);
        edtTim.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 0) {
//                    List<NguoiDung> nguoiDungList =nguoiDungDao.getallND();
//                    AdapterND a = new AdapterND(nguoiDungList);
//                    lvlist.setAdapter(a);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }



    public void searchUserName(View view) {
        EditText edtTim = findViewById(R.id.tim);
        String username = edtTim.getText().toString().trim();
        if (username.isEmpty()) {
            edtTim.setError("NHAP DU LIEU TRC");
            return;
        }
//        MySQL mySQL =new MySQL(QLSachBanChay.this);
//        NguoiDungDao nguoiDungDao = new NguoiDungDao(mySQL);
//        List<NguoiDung> nguoiDungList = nguoiDungDao.timKiemUsername(username);
//
//        if (nguoiDungList.size() == 0) {
//            edtTim.setError("KHONG TIM THAY USER NAO!!!!");
//        } else {
//            AdapterND nguoiDungAdapter = new AdapterND(nguoiDungList);
//            lvlist.setAdapter(nguoiDungAdapter);
//        }

    }
}