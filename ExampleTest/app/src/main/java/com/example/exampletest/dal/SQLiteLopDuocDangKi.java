package com.example.exampletest.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.exampletest.model.LopDuocDangKi;

import java.util.ArrayList;
import java.util.List;

public class SQLiteLopDuocDangKi extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "LopDuocDangKi.db";
    private static final int DATABASE_VERSION = 1;
    public SQLiteLopDuocDangKi(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table LopDuocDangKi ("
                +"id INTEGER primary key autoincrement,"
                +"maSinhVien INTEGER, maLopHoc INTEGER, kiHoc TEXT, soTinChi INTEGER, "
                +"foreign key (idSinhVien) references SinhVien(msv), "
                +"foreign key (idLopHoc) references LopHoc(maLop) "
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
    public List<LopDuocDangKi> getAll(){
        List<LopDuocDangKi> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor rs =  db.query("SinhVien",null,null,null,
                null,null,null);

        while (rs!=null && rs.moveToNext()){
            list.add(new LopDuocDangKi(rs.getInt(0),rs.getInt(1),rs.getInt(2),
                    rs.getString(3),rs.getInt(4)));
        }
        return list;
    }

    public long add(LopDuocDangKi lddk){
        ContentValues cv =  new ContentValues();
        cv.put("id",lddk.getId());
        cv.put("msv",lddk.getMaLopHoc());
        cv.put("maLop",lddk.getMaSinhVien());
        cv.put("kiHoc",lddk.getKiHoc());
        cv.put("soTinChi",lddk.getSoTinChi());
        SQLiteDatabase db = getWritableDatabase();
        return db.insert("LopDuocDangKi",null,cv);
    }
}
