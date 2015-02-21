package com.mycompany.deep.p1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;

/**
 * Created by deep on 2/20/15.
 */
public class Database {

    public static final String KEY_ROWID = "_id";
    public static final String KEY_ENG = "english_word";
    public static final String KEY_UNICODE = "uni_code";
    public static final String KEY_PARTLANG = "pare_lang";


    private static final String DATABASE_NAME = "Databasedb";
    private static final String DATABASE_TABLE = "wordstable";
    private static final int DATABASE_VERSION = 1;

    private DbHelper ourhelper;
    private final Context con;
    private SQLiteDatabase ourdatabase;

    public Database(Context context) {
        con = context;
    }

    public String getData() {
        try {
            String[] columns = new String[]{KEY_ROWID, KEY_ENG, KEY_UNICODE, KEY_PARTLANG};
            Cursor c = ourdatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
            String s = "";
            int irow = c.getColumnIndex(KEY_ROWID);
            int ieng = c.getColumnIndex(KEY_ENG);
            int iunicode = c.getColumnIndex(KEY_UNICODE);
            int ipartlang = c.getColumnIndex(KEY_PARTLANG);

            for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
                s = s +  c.getString(ieng) + " " + c.getString(iunicode) + " " + c.getString(ipartlang) + "\n";
            }
            return s;
        }catch (Exception e){
            e.printStackTrace();
            return "aaa";
        }

    }

    public void delete() {
        for(int i=0;i<100;i++)
            ourdatabase.delete(DATABASE_TABLE,KEY_ROWID + "=" + i,null);
    }

    private static class DbHelper extends SQLiteOpenHelper {
        public DbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" +
                            KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            KEY_ENG + " TEXT NOT NULL, " +
                            KEY_UNICODE + " TEXT NOT NULL, " + KEY_PARTLANG + " TEXT NOT NULL);"
            );
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);
        }
    }
    public Database open() throws SQLException {
        ourhelper = new DbHelper(con);
        ourdatabase = ourhelper.getWritableDatabase();
        return this;
    }
    public void close(){
        ourhelper.close();
    }
    public long passdata(String name, String unicode,String partlang) {
        ContentValues cv =new ContentValues();
        cv.put(KEY_ENG, name);
        cv.put(KEY_UNICODE,unicode);
        cv.put(KEY_PARTLANG,partlang);
        return ourdatabase.insert(DATABASE_TABLE,null,cv);
    }

}