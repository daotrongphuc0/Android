package com.example.exampletest.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.exampletest.model.LopHoc;
import com.example.exampletest.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SQLiteLopHoc extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "LopHoc.db";
    private static final int DATABASE_VERSION = 1;
    public SQLiteLopHoc(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table LopHoc ("
                +"maLop INTEGER primary key autoincrement,"
                +"tenLop TEXT, moTa TEXT"
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
    public List<LopHoc> getAll(){
        List<LopHoc> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor rs =  db.query("LopHoc",null,null,null,
                null,null,null);
        while (rs!=null && rs.moveToNext()){
            list.add(new LopHoc(rs.getInt(0),rs.getString(1),rs.getString(2)));
        }
        return list;
    }

    public LopHoc getByMaLop(int maLop){
        SQLiteDatabase db = getReadableDatabase();
        String where = "maLop = ?";
        String [] whereArgs = {Integer.toString(maLop)};
        Cursor rs =  db.query("LopHoc",null,where,whereArgs,
                null,null,null);
        while (rs!=null && rs.moveToNext()){
           return new LopHoc(rs.getInt(0),rs.getString(1),rs.getString(2));
        }
        return null;
    }

    public long add(LopHoc lh){
        ContentValues cv =  new ContentValues();
        cv.put("tenLop",lh.getTenLop());
        cv.put("moTa",lh.getMoTa());
        SQLiteDatabase db = getWritableDatabase();
        return db.insert("LopHoc",null,cv);
    }
}
