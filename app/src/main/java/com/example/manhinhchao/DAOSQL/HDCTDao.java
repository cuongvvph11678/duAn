package com.example.manhinhchao.DAOSQL;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.manhinhchao.SQL.MySQL;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Model.HoaDon;
import Model.HoaDonChiTiet;

public class HDCTDao {
    private MySQL mySQL;

    public HDCTDao(MySQL mySQL) {
        this.mySQL = mySQL;
    }
    public  void LuuHDCT(HoaDonChiTiet sv){
        SQLiteDatabase sqLiteDatabase = mySQL.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put("maHDCT",sv.getMaHDCT());
        contentValues.put("maHoaDon",sv.getMaHoaDon());
        contentValues.put("maSach",sv.getMaSach());
        contentValues.put("soLuongMua",sv.getSoLuongMua());



        sqLiteDatabase.insert("mySQL",null,
                contentValues);
    }

    public  void SuaHDCT(HoaDonChiTiet sv){
        SQLiteDatabase sqLiteDatabase = mySQL.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put("maHDCT",sv.getMaHDCT());
        contentValues.put("maHoaDon",sv.getMaHoaDon());
        contentValues.put("maSach",sv.getMaSach());
        contentValues.put("soLuongMua",sv.getSoLuongMua());




        sqLiteDatabase.update("mySQL",contentValues,
                "maHDCT =?",new String[]{sv.getMaHDCT()});

        //   sqLiteDatabase.insert("NguoiDung",null,contentValues);
    }




    public List<HoaDonChiTiet> getallNDCT(){
        List<HoaDonChiTiet> productsList =new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = mySQL.getWritableDatabase();
        String get_all = "SELECT * FROM HoaDonChiTiet";

        Cursor cursor = sqLiteDatabase.rawQuery(get_all,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String maHDCT,maHoaDon,maSach;
            int soLuongMua;

            maHDCT =cursor.getString(0);
            maHoaDon=cursor.getString(1);
            maSach=cursor.getString(2);
            soLuongMua=cursor.getInt(3);



            cursor.moveToNext();
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet
                    (maHDCT,maHoaDon,maSach,soLuongMua);
            productsList.add(hoaDonChiTiet);

        }
        cursor.close();

        return productsList;
    }


    public  void  deleteHDCT(String maHDCT){
        SQLiteDatabase sqLiteDatabase = mySQL.getWritableDatabase();
        sqLiteDatabase.delete("mySQL",
                "maHDCT=?",new String[]{maHDCT});

    }

}
