package com.example.exampletest.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.exampletest.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SQLiteSinhVien extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "SinhVien.db";
    private static final int DATABASE_VERSION = 1;
    public SQLiteSinhVien(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table SinhVien ("
                +"msv INTEGER primary key autoincrement,"
                +"ten TEXT, namSinh TEXT, queQuan TEXT, namHoc TEXT"
                +")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    // get all
    public List<SinhVien> getAll(){
        List<SinhVien> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String order = "msv DESC";
        Cursor rs =  db.query("SinhVien",null,null,null,
                null,null,order);
        while (rs!=null && rs.moveToNext()){
            list.add(new SinhVien(rs.getInt(0),rs.getString(1),rs.getString(2)
                    ,rs.getString(3),rs.getString(4)));
        }
        return list;
    }

    public SinhVien getByMsv(int msv){
        SQLiteDatabase db = getReadableDatabase();
        String where = "msv = ?";
        String [] whereArgs = {Integer.toString(msv)};
        Cursor rs =  db.query("SinhVien",null,where,whereArgs,
                null,null,null);
        while (rs!=null && rs.moveToNext()){
            return new SinhVien(rs.getInt(0),rs.getString(1),rs.getString(2)
                    ,rs.getString(3),rs.getString(4));
        }
        return null;
    }

    public long add(SinhVien sv){
        ContentValues cv =  new ContentValues();
        cv.put("ten",sv.getTen());
        cv.put("namSinh",sv.getNamSinh());
        cv.put("queQuan",sv.getQueQuan());
        cv.put("namHoc",sv.getNamHoc());
        SQLiteDatabase db = getWritableDatabase();
        return db.insert("SinhVien",null,cv);
    }
}
