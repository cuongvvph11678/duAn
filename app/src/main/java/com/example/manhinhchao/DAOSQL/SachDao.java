package com.example.manhinhchao.DAOSQL;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.manhinhchao.SQL.MySQL;

import java.util.ArrayList;
import java.util.List;

import Model.NguoiDung;
import Model.Sach;

public class SachDao {
    private MySQL mySQL;

    public SachDao(MySQL mySQL) {
        this.mySQL = mySQL;
    }
    public  boolean LuuSach(Sach sv){
        SQLiteDatabase sqLiteDatabase = mySQL.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put("maSach",sv.getMaSach());
        contentValues.put("maTheLoai",sv.getMaTheLoai());
        contentValues.put("tacGia",sv.getTacGia());
        contentValues.put("NXB",sv.getNXB());
        contentValues.put("giaBan",sv.getGiaBan());
        contentValues.put("soLuong",sv.getSoLuong());



      long x=  sqLiteDatabase.insert("mySQL",null,contentValues);
        if(x==-1){
            return false;
        }else {
            return  true;
        }
    }

    public  boolean SuaSach(Sach sv){
        SQLiteDatabase sqLiteDatabase = mySQL.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put("maSach",sv.getMaSach());
        contentValues.put("maTheLoai",sv.getMaTheLoai());
        contentValues.put("tacGia",sv.getTacGia());
        contentValues.put("NXB",sv.getNXB());
        contentValues.put("giaBan",sv.getGiaBan());
        contentValues.put("soLuong",sv.getSoLuong());


        sqLiteDatabase.update("mySQL",contentValues,
                "maSach =?",new String[]{sv.getMaSach()});
return  true;

    }




    public List<Sach> getallSach(){
        List<Sach> productsList =new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = mySQL.getWritableDatabase();
        String get_all = "SELECT * FROM Sach";

        Cursor cursor = sqLiteDatabase.rawQuery(get_all,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String maSach,maTheLoai,tacGia,NXB;
            int soLuong;
            double giaBan;


            maSach =cursor.getString(0);
            maTheLoai=cursor.getString(1);
            tacGia=cursor.getString(2);
            NXB=cursor.getString(3);
            giaBan=cursor.getDouble(4);
            soLuong=cursor.getInt(5);

            cursor.moveToNext();
            Sach sach = new Sach(maSach,maTheLoai,tacGia,NXB, soLuong, giaBan);
            productsList.add(sach);

        }
        cursor.close();

        return productsList;
    }


    public  void  deleteSach(String maSach){
        SQLiteDatabase sqLiteDatabase = mySQL.getWritableDatabase();
        sqLiteDatabase.delete("MySQL","maSach=?",new String[]{maSach});

    }

}
