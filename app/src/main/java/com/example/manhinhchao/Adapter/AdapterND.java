package com.example.manhinhchao.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.manhinhchao.DAOSQL.NguoiDungDao;
import com.example.manhinhchao.R;
import com.example.manhinhchao.SQL.MySQL;

import java.util.List;

import Model.NguoiDung;

public class AdapterND extends BaseAdapter {
    List<NguoiDung> nguoiDungList;
    Button xoa,sua;
    public AdapterND(List<NguoiDung> nguoiDungList){

        this.nguoiDungList = nguoiDungList;
    }

    @Override
    public int getCount() {
        return nguoiDungList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, final ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nd,viewGroup,false);
        TextView user= view.findViewById(R.id.user);
        TextView pass= view.findViewById(R.id.pass);
        TextView phone =view.findViewById(R.id.sdt);
        TextView  hoten=view.findViewById(R.id.hoten);
        xoa = view.findViewById(R.id.xoand);
        sua = view.findViewById(R.id.suand);

        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NguoiDung quanly = nguoiDungList.get(i);
                MySQL mySQL = new MySQL(viewGroup.getContext());
                NguoiDungDao nguoiDungDao = new NguoiDungDao(mySQL);

                nguoiDungDao.deleteND(quanly.getUserName());
                nguoiDungList.remove(i);
notifyDataSetChanged();

                //notifyDataSetChanged();
                Toast.makeText(viewGroup.getContext(),"Xoa Thanh Cong",Toast.LENGTH_LONG).show();
            }
        });

        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                AlertDialog.Builder builder = new AlertDialog.Builder(viewGroup.getContext());
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sua_nd, null);
                builder.setView(view);
                final EditText edtusername = view.findViewById(R.id.userName);
                final EditText edtpassword = view.findViewById(R.id.passWord);
                final EditText edtphone = view.findViewById(R.id.phone);
                final EditText edthoten = view.findViewById(R.id.hoTen);
                Button sua = view.findViewById(R.id.anh);
                Button huy = view.findViewById(R.id.huy);
                final AlertDialog alertDialog = builder.show();
                huy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });
                sua.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        NguoiDung nguoiDung = new NguoiDung( edtusername.getText().toString(),
//                                edthoten.getText().toString(),edtpassword.getText().toString(),edtphone.getText().toString());
                        NguoiDung nguoiDung = new NguoiDung();
                        nguoiDung.userName = edtusername.getText().toString().trim();
                        nguoiDung.hoTen = edthoten.getText().toString().trim();
                        nguoiDung.passWord = edtpassword.getText().toString().trim();
                        nguoiDung.phone = edtphone.getText().toString().trim();
                        MySQL mySQL = new MySQL(viewGroup.getContext());
                        NguoiDungDao userDAO = new NguoiDungDao(mySQL);
                       boolean sua = userDAO.SuaND(nguoiDung);
                       if(sua){
                           notifyDataSetChanged();
                           Toast.makeText(viewGroup.getContext(),"Sua Thanh Cong",Toast.LENGTH_LONG).show();
                           alertDialog.dismiss();
                       }else {
                           Toast.makeText(viewGroup.getContext(),"Sua Khong Thanh Cong",Toast.LENGTH_LONG).show();
                       }

                    }
                });

            }
        });


        NguoiDung student2 = nguoiDungList.get(i);

        user.setText(student2.getUserName());
        pass.setText(student2.getPassWord());
        hoten.setText(student2.getHoTen());
        phone.setText(student2.getPhone());

        return view;
    }
}


