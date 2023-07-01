package com.example.sqllearning.DAL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.sqllearning.model.Item;

import java.util.ArrayList;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ChiTieu.db";
    private static final int DATABASE_VERSION = 1;

    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql  = "Create table items (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "title TEXT, category TEXT, price TEXT,date TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    // get all order by disending
    public List<Item> getAll(){
        List<Item> list = new ArrayList<>();
        SQLiteDatabase  st = getReadableDatabase();
        String oder  = "date DESC";
        Cursor rs = st.query("items", null,null,
                null,null,null,oder);
        while (rs!= null && rs.moveToNext()){
            list.add(new Item(rs.getInt(0),rs.getString(1),rs.getString(2),
                    rs.getString(3),rs.getString(4)));
        }
        return list;
    }

    // add item to database
    public long addItem(Item item){
        ContentValues contentValues = new ContentValues();
        contentValues.put("title",item.getTitle());
        contentValues.put("category",item.getCategory());
        contentValues.put("price",item.getPrice());
        contentValues.put("date",item.getDate().trim());
        SQLiteDatabase db = getWritableDatabase();
        return db.insert("items",null,contentValues);
    }

    // get item by date
    public  List<Item> getByDate(String date){
        List<Item> list = new ArrayList<>();
        String whereClause = "date = ?";
        String [] whereArgs = {date};
        SQLiteDatabase db = getReadableDatabase();
        System.out.println(date);
        System.out.println("Hello");
        Cursor rs = db.query("items",null,whereClause,whereArgs,null,null,null);
        while (rs!= null && rs.moveToNext()){
            list.add(new Item(rs.getInt(0),rs.getString(1),rs.getString(2),
                    rs.getString(3),rs.getString(4)));
        }
        return list;
    }

    public  List<Item> getByTitle(String key){
        List<Item> list = new ArrayList<>();
        String whereClause = "title like ?";
        String [] whereArgs = {"%"+key+"%"};
        SQLiteDatabase db = getReadableDatabase();
        Cursor rs = db.query("items",null,whereClause,whereArgs,null,null,null);
        while (rs!= null && rs.moveToNext()){
            list.add(new Item(rs.getInt(0),rs.getString(1),rs.getString(2),
                    rs.getString(3),rs.getString(4)));
        }
        return list;
    }

    // update
    public int update(Item item){
        ContentValues contentValues = new ContentValues();
        contentValues.put("title",item.getTitle());
        contentValues.put("category",item.getCategory());
        contentValues.put("price",item.getPrice());
        contentValues.put("date",item.getDate().trim());
        SQLiteDatabase db = getWritableDatabase();
        String whereClause = "id = ?";
        String [] whereArgs = {Integer.toString(item.getId())};
        return db.update("items",contentValues,whereClause,whereArgs);
    }

    // delete
    public int delete(int id){
        SQLiteDatabase db = getWritableDatabase();
        String whereClause = "id = ?";
        String [] whereArgs = {Integer.toString(id)};
        return db.delete("items",whereClause,whereArgs);
    }
}
