package com.example.manhinhchao.SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import Model.NguoiDung;

public class MySQL extends SQLiteOpenHelper {
    public MySQL(@Nullable Context context) {
        super(context,"DuAnMau", null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String Nguoidung="CREATE TABLE NguoiDung("+"" +
                "userName NVARCHAR(50) PRIMARY KEY,"+"" +
                "passWord NVARCHAR(50),"+"" +
                "phone NCHAR(10),"+"" +
                "hoTen NVARCHAR(50))";
        String Theloai="CREATE TABLE TheLoai("+"" +
                "maTheLoai  NCHAR(10) PRIMARY KEY,"+"" +
                "tenTheLoai  NVARCHAR(50),"+"" +
                " moTa  NVARCHAR(50) ,"+"" +
                " viTri  INT)";
        String Sach="CREATE TABLE Sach("+"" +
                "maSach  NCHAR(10) PRIMARY KEY,"+"" +
                "maTheLoai  NCHAR(10),"+" " +
                "tacGia  NVARCHAR(50),"+" " +
                "NXB  NVARCHAR(50),"+"" +
                " giaBan FLOAT,"+"" +
                " soLuong INT)";
        String Hoadon="CREATE TABLE HoaDon("+"" +
                " maHoaDon  NCHAR(10) PRIMARY KEY,"+" " +
                "ngayMua  DATE)";
        String HDCT="CREATE TABLE HDCT("+"" +
                " maHDCT  NCHAR(10) PRIMARY KEY,"+"" +
                " maHoaDon  NCHAR(10) ,"+"" +
                " maSach  NCHAR(10),"+"" +
                " soLuongMua INT)";

        sqLiteDatabase.execSQL(Nguoidung);
        sqLiteDatabase.execSQL(Theloai);
        sqLiteDatabase.execSQL(Sach);
        sqLiteDatabase.execSQL(Hoadon);
        sqLiteDatabase.execSQL(HDCT);
    }





    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
