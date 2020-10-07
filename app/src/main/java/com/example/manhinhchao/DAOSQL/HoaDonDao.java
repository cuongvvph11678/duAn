package com.example.manhinhchao.DAOSQL;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

import com.example.manhinhchao.SQL.MySQL;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Model.HoaDon;
import Model.NguoiDung;

public class HoaDonDao {
    private MySQL mySQL;

    public HoaDonDao(MySQL mySQL) {
        this.mySQL = mySQL;
    }

    public  boolean LuuHD(HoaDon sv){
        SQLiteDatabase sqLiteDatabase = mySQL.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put("maHoaDon",sv.getMaHoaDon());
        //contentValues.put("ngayMua",sv.getNgayMua());



       long x= sqLiteDatabase.insert("mySQL",null,
                contentValues);
        if(x==-1){
            return false;
        }else {
            return  true;
        }
    }

    public  boolean SuaHD(HoaDon sv){
        SQLiteDatabase sqLiteDatabase = mySQL.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put("maHoaDon",sv.getMaHoaDon());
      //  contentValues.put("ngayMua",sv.getNgayMua());



        sqLiteDatabase.update("mySQL",contentValues,
                "maMaHoaDon =?",new String[]{sv.getMaHoaDon()});
return  true;
        //   sqLiteDatabase.insert("NguoiDung",null,contentValues);
    }




    public List<HoaDon> getallHD(){
        List<HoaDon> productsList =new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = mySQL.getWritableDatabase();
        String get_all = "SELECT * FROM HoaDon";

        Cursor cursor = sqLiteDatabase.rawQuery(get_all,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String maHoaDon;
            Date ngayMua;


            maHoaDon =cursor.getString(0);
           // ngayMua=cursor.(1);


            cursor.moveToNext();
//            HoaDon hoaDon = new HoaDon
//                    (maHoaDon,ngayMua);
//            productsList.add(hoaDon);

        }
        cursor.close();

        return productsList;
    }


    public  void  deleteHD(String maHoaDon){
        SQLiteDatabase sqLiteDatabase = mySQL.getWritableDatabase();
        sqLiteDatabase.delete("mySQL",
                "maHoaDon=?",new String[]{maHoaDon});

    }

}
