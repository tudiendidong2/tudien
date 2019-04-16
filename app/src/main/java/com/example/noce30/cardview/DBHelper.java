package com.example.noce30.cardview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Tudien.db";
    public static final String TABLE_NAME="tudien_table";
    public static final String TABLE_NAME_TU_DA_TRA="tu_da_tra_table";
    public static final String COL_1="ID";
    public static final String COL_2="TU_TA";
    public static final String COL_3="TU_TV";
    public static final String COL_4="HINH";
    public static final String COL_5="VI_DU";
    public static final String COL_6="VI_DU_TV";

    Context context1;
    static long dbInsert ;
    private SQLiteDatabase database;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 6);
        context1 = context.getApplicationContext();
    }
    //open db
    public DBHelper open() {
        //database = new  DBHelper(context);
        SQLiteDatabase db = this.getWritableDatabase();
        return this;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,TU_TA TEXT,TU_TV TEXT,HINH BLOB, VI_DU TEXT )");
        db.execSQL("create table " + TABLE_NAME_TU_DA_TRA +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,TU_TA TEXT,TU_TV TEXT,HINH BLOB, VI_DU TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    //insert tu
    public void createDefaultNotesIfNeed() {
        int count = this.getCount();
        if(count == 0 ) {
            this.insertData("hello", "xin chao", this.getImagePath(R.drawable.hello), "In this morning, He say hello me.");
            this.insertData("tiger", "con ho", this.getImagePath(R.drawable.tiger), "In this morning, He meet tiger in the zoo.");
            this.insertData("chicken", "con ga", this.getImagePath(R.drawable.chicken), "In this diner, we eat chiken.");
        }
    }

    public int getCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        cursor.close();

        // return count
        return count;
    }

    public boolean insertData(String anh, String viet, byte[] hinh, String viDu) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,anh);
        contentValues.put(COL_3,viet);
        contentValues.put(COL_4,hinh);
        contentValues.put(COL_5,viDu);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    //insert tu da tra
    public boolean insertDataTDT(String anh, String viet, byte[] hinh, String viDu) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,anh);
        contentValues.put(COL_3,viet);
        contentValues.put(COL_4,hinh);
        contentValues.put(COL_5,viDu);
        long result = db.insert(TABLE_NAME_TU_DA_TRA,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    //kiem tra tu da tra
    public boolean kiemTraDataTDT(String anh) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME_TU_DA_TRA + " where TU_TA = ? ", new String[] {anh});
        return ((res != null) && (res.getCount() > 0));
    }

    //query tieng anh- viet
    public Cursor getAllData(String keyWord) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME + " where TU_TA = ? ", new String[] {keyWord});
        return res;
    }

    //query tieng viet- anh
    public Cursor getTV(String keyWord) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME + " where TU_TV = ? ", new String[] {keyWord});
        return res;
    }

    public boolean updateData(String id,String name,String surname,String marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    //query tieng anh- viet
    public Cursor getAllDataTDT() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME_TU_DA_TRA , null);
        return res;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }

    public byte[] getImagePath(int r){
        Bitmap bitmap = BitmapFactory.decodeResource(context1.getResources(), r);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] bitMapData = stream.toByteArray();
        return bitMapData;
    }

}
