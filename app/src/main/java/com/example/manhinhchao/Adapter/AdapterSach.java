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
import com.example.manhinhchao.DAOSQL.SachDao;
import com.example.manhinhchao.R;
import com.example.manhinhchao.SQL.MySQL;

import java.util.List;

import Model.HoaDon;
import Model.Sach;

public class AdapterSach extends BaseAdapter {
    List<Sach> theLoaiList;
    Button xoa,sua;
    public AdapterSach(List<Sach> theLoaiList){

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
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sach,viewGroup,false);
        TextView masach= view.findViewById(R.id.masach);
        TextView theloai= view.findViewById(R.id.theloai);
        TextView tacgia = view.findViewById(R.id.tacgia);
        TextView nxb = view.findViewById(R.id.NXB);
        TextView soluong = view.findViewById(R.id.soluong);
        TextView giaban = view.findViewById(R.id.giaban);
        xoa = view.findViewById(R.id.xoahd);
        sua = view.findViewById(R.id.suahd);

        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sach sach =theLoaiList.get(i);
                MySQL mySQL = new MySQL(viewGroup.getContext());
                SachDao sachDao = new SachDao(mySQL);

                sachDao.deleteSach(sach.getMaSach());
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
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sua_sach, null);
                builder.setView(view);
                final EditText edtmasach= view.findViewById(R.id.masach);
                final EditText edttheloai= view.findViewById(R.id.theloai);
                final EditText edttacgia = view.findViewById(R.id.tacgia);
                final EditText edtnxb = view.findViewById(R.id.NXB);
                final EditText edtsoluong = view.findViewById(R.id.soluong);
                final EditText edtgiaban = view.findViewById(R.id.giaban);

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
                     //   Sach sach = new Sach( edtmasach.getText().toString());

                        MySQL mySQL = new MySQL(viewGroup.getContext());
                        SachDao sachDao = new SachDao(mySQL);
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


        Sach ql = theLoaiList.get(i);

        masach.setText(ql.getMaSach());
        theloai.setText(ql.getMaTheLoai());
        tacgia.setText(ql.getTacGia());
        nxb.setText(ql.getNXB());
        soluong.setText(ql.getSoLuong());
        //giaban.setText(ql.getGiaBan());




        return view;
    }
}
