package com.example.manhinhchao.DAOSQL;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.manhinhchao.SQL.MySQL;

import java.util.ArrayList;
import java.util.List;

import Model.NguoiDung;

public class NguoiDungDao {
    private MySQL mySQL;

    public NguoiDungDao(MySQL mySQL) {
        this.mySQL = mySQL;
    }

    public boolean LuuND(NguoiDung sv){
        SQLiteDatabase sqLiteDatabase = mySQL.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put("userName",sv.getUserName());
        contentValues.put("passWord",sv.getPassWord());
        contentValues.put("phone",sv.getPhone());
        contentValues.put("hoTen",sv.getHoTen());



      long x =  sqLiteDatabase.insert("NguoiDung",null,contentValues);

        if(x<0){
            return false;
        }else {
            return  true;
        }

    }

    public  boolean SuaND(NguoiDung sv){
        SQLiteDatabase sqLiteDatabase = mySQL.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put("userName",sv.getUserName());
        contentValues.put("passWord",sv.getPassWord());
        contentValues.put("phone",sv.getPhone());
        contentValues.put("hoTen",sv.getHoTen());


  sqLiteDatabase.update("NguoiDung",contentValues,"userName =?",new String[]{sv.userName});

     return  true;


    }




    public List<NguoiDung> getallND(){
        List<NguoiDung> productsList =new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = mySQL.getWritableDatabase();
        String get_all = "SELECT * FROM NguoiDung";

        Cursor cursor = sqLiteDatabase.rawQuery(get_all,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String userName,passWord,phone,hoTen;


            userName =cursor.getString(0);
            passWord=cursor.getString(1);
            phone=cursor.getString(2);
            hoTen=cursor.getString(3);

            cursor.moveToNext();
            NguoiDung nguoiDung = new NguoiDung(userName,passWord,phone,hoTen);
            productsList.add(nguoiDung);

        }
        cursor.close();

        return productsList;
    }


    public  void  deleteND(String userName){
        SQLiteDatabase sqLiteDatabase = mySQL.getWritableDatabase();
        sqLiteDatabase.delete("NguoiDung","userName=?",new String[]{userName});

    }

}
