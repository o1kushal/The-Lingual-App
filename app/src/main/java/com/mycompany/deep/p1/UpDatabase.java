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
public class UpDatabase {

    public static final String KEY_ROWID = "_id";
    public static final String KEY_PARTLANG = "pare_lang";

    private static final String DATABASE_NAME = "UpDatabasedb";
    private static final String DATABASE_TABLE = "wordstable";
    private static final int DATABASE_VERSION = 1;

    private DbHelper ourhelper;
    private final Context con;
    private SQLiteDatabase ourdatabase;

    public UpDatabase(Context context) {
        con = context;
    }

    public String getData() {
        try {
            String[] columns = new String[]{KEY_ROWID,  KEY_PARTLANG};
            Cursor c = ourdatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
            String s = "";
            int irow = c.getColumnIndex(KEY_ROWID);
            int ipartlang = c.getColumnIndex(KEY_PARTLANG);

            for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
                s = s +" " + c.getString(ipartlang) + "\n";
            }
            return s;
        }catch (Exception e){
            e.printStackTrace();
            return "aaa";
        }

    }

    public void delete() {
        for(int i=0;i<10;i++)
        ourdatabase.delete(DATABASE_TABLE,KEY_ROWID + "=" + i,null);
    }

    private static class DbHelper extends SQLiteOpenHelper {
        public DbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" +
                            KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_PARTLANG + " TEXT NOT NULL);"
            );
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);
        }
    }
    public UpDatabase open() throws SQLException {
        ourhelper = new DbHelper(con);
        ourdatabase = ourhelper.getWritableDatabase();
        return this;
    }
    public void close(){
        ourhelper.close();
    }
    public long passdata(String partlang) {
        ContentValues cv =new ContentValues();

        cv.put(KEY_PARTLANG,partlang);
        return ourdatabase.insert(DATABASE_TABLE,null,cv);
    }

}