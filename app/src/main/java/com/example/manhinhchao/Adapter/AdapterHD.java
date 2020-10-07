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

import com.example.manhinhchao.DAOSQL.HoaDonDao;
import com.example.manhinhchao.DAOSQL.TheLoaiDao;
import com.example.manhinhchao.R;
import com.example.manhinhchao.SQL.MySQL;

import java.util.List;

import Model.HoaDon;
import Model.TheLoai;

public class AdapterHD extends BaseAdapter {
    List<HoaDon> theLoaiList;
    Button xoa,sua;
    public AdapterHD(List<HoaDon> theLoaiList){

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
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hd,viewGroup,false);
        TextView mahd= view.findViewById(R.id.user);
        TextView ngay= view.findViewById(R.id.pass);

        xoa = view.findViewById(R.id.xoahd);
        sua = view.findViewById(R.id.suahd);

        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HoaDon hoaDon =theLoaiList.get(i);
                MySQL mySQL = new MySQL(viewGroup.getContext());
                HoaDonDao hoaDonDao = new HoaDonDao(mySQL);

                hoaDonDao.deleteHD(hoaDon.getMaHoaDon());
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
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sua_hd, null);
                builder.setView(view);
                final EditText edtma = view.findViewById(R.id.userName);
                final EditText edtngay = view.findViewById(R.id.passWord);

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
                       // HoaDon hoaDon = new HoaDon( edtma.getText().toString(),edtngay.getText().);

                        MySQL mySQL = new MySQL(viewGroup.getContext());
                        HoaDonDao hoaDonDao = new HoaDonDao(mySQL);
//                        boolean sua = hoaDonDao.SuaHD(hoaDon);
//                        if(sua){
//                            notifyDataSetChanged();
//                            Toast.makeText(viewGroup.getContext(),"Sua Thanh Cong",Toast.LENGTH_LONG).show();
//                            alertDialog.dismiss();
//                        }else {
//                            Toast.makeText(viewGroup.getContext(),"Sua Khong Thanh Cong",Toast.LENGTH_LONG).show();
//                        }

                    }
                });

            }
        });


        HoaDon ql = theLoaiList.get(i);

        mahd.setText(ql.getMaHoaDon());
        ngay.setText((CharSequence) ql.getNgayMua());


        return view;
    }
}
