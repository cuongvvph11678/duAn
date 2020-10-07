package com.example.manhinhchao.DAOSQL;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.manhinhchao.SQL.MySQL;

import java.util.ArrayList;
import java.util.List;

import Model.TheLoai;

public class TheLoaiDao {
    private MySQL mySQL;

    public TheLoaiDao(MySQL mySQL) {
        this.mySQL = mySQL;
    }
    public  boolean LuuTL(TheLoai sv){
        SQLiteDatabase sqLiteDatabase = mySQL.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put("maTheLoai",sv.getMaTheLoai());
        contentValues.put("tenTheLoai",sv.getTenTheLoai());
        contentValues.put("moTa",sv.getMoTa());
        contentValues.put("viTri",sv.getViTri());


//sqLiteDatabase.update("",contentValues,"userName =?",new String[sv.]);

       long x= sqLiteDatabase.insert("TheLoai",null,contentValues);
        if(x==-1){
            return false;
        }else {
            return  true;
        }
    }

    public boolean SuaTL(TheLoai sv){
        SQLiteDatabase sqLiteDatabase = mySQL.getWritableDatabase();
        ContentValues contentValues =new ContentValues();

        contentValues.put("maTheLoai",sv.getMaTheLoai());
        contentValues.put("tenTheLoai",sv.getTenTheLoai());
        contentValues.put("moTa",sv.getMoTa());
        contentValues.put("viTri",sv.getViTri());


        sqLiteDatabase.update("TheLoai", contentValues,
                "maTheLoai =?",new String[]{sv.getMaTheLoai()});

        //   sqLiteDatabase.insert("NguoiDung",null,contentValues);
        return false;
    }




    public List<TheLoai> getallTL(){
        List<TheLoai> productsList =new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = mySQL.getWritableDatabase();
        String get_all = "SELECT * FROM TheLoai";

        Cursor cursor = sqLiteDatabase.rawQuery(get_all,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String maTheLoai,tenTheLoai,moTa;
            int viTri;


            maTheLoai =cursor.getString(0);
            tenTheLoai=cursor.getString(1);
            moTa=cursor.getString(2);
            viTri=cursor.getInt(3);

            cursor.moveToNext();
            TheLoai theLoai = new TheLoai
                    (maTheLoai,tenTheLoai,moTa,viTri);
            productsList.add(theLoai);

        }
        cursor.close();

        return productsList;
    }


    public  void  deleteTL(String maTheLoai){
        SQLiteDatabase sqLiteDatabase = mySQL.getWritableDatabase();
        sqLiteDatabase.delete("TheLoai",
                "maTheLoai=?",new String[]{maTheLoai});

    }

}
