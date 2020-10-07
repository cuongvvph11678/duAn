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
import com.example.manhinhchao.DAOSQL.TheLoaiDao;
import com.example.manhinhchao.R;
import com.example.manhinhchao.SQL.MySQL;

import java.util.List;

import Model.NguoiDung;
import Model.TheLoai;

public class AdapterTL extends BaseAdapter {
    List<TheLoai> theLoaiList;
    Button xoa,sua;
    public AdapterTL(List<TheLoai> theLoaiList){

        this.theLoaiList =theLoaiList;
    }

    @Override
    public int getCount() {
        return theLoaiList.size();
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
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tl,viewGroup,false);
        TextView ma= view.findViewById(R.id.user);
        TextView ten= view.findViewById(R.id.pass);
        TextView vitri =view.findViewById(R.id.sdt);
        TextView  mota=view.findViewById(R.id.hoten);
        xoa = view.findViewById(R.id.anh);
        sua = view.findViewById(R.id.anh);

        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TheLoai theLoai = theLoaiList.get(i);
                MySQL mySQL = new MySQL(viewGroup.getContext());
                TheLoaiDao theLoaiDao = new TheLoaiDao(mySQL);

                theLoaiDao.deleteTL(theLoai.getMaTheLoai());
                theLoaiList.remove(i);
                notifyDataSetChanged();

                //notifyDataSetChanged();
                Toast.makeText(viewGroup.getContext(),"Xoa Thanh Cong",Toast.LENGTH_LONG).show();
            }
        });

        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                AlertDialog.Builder builder = new AlertDialog.Builder(viewGroup.getContext());
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sua_tl, null);
                builder.setView(view);
                final EditText edtma = view.findViewById(R.id.userName);
                final EditText edtten = view.findViewById(R.id.passWord);
                final EditText edtvitri = view.findViewById(R.id.phone);
                final EditText edtmota = view.findViewById(R.id.hoTen);
                Button sua = view.findViewById(R.id.sua);
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
                        TheLoai theLoai = new TheLoai( edtma.getText().toString(),
                                edtten.getText().toString(),edtmota.getText().toString(),edtvitri.getText().charAt(i));
//                        nguoiDung.userName = edtusername.getText().toString().trim();
//                        nguoiDung.hoTen = edthoten.getText().toString().trim();
//                        nguoiDung.passWord = edtpassword.getText().toString().trim();
//                        nguoiDung.phone = edtphone.getText().toString().trim();
                        MySQL mySQL = new MySQL(viewGroup.getContext());
                        TheLoaiDao theLoaiDao = new TheLoaiDao(mySQL);
                        boolean sua = theLoaiDao.SuaTL(theLoai);
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


        TheLoai ql = theLoaiList.get(i);

        ma.setText(ql.getMaTheLoai());
        ten.setText(ql.getTenTheLoai());
        mota.setText(ql.getMoTa());
        vitri.setText(ql.getViTri());

        return view;
    }
}
