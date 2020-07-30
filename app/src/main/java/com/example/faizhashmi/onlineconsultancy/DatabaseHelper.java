package com.example.faizhashmi.onlineconsultancy;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    //SQLiteDatabase sqldb;

    public final static String DATABASE_NAME = "onlineconsultancy.db";
    public final static String TABLE_NAME = "Country";
    public static final String CCOL_1 = "Country_id";
    public static final String CCOL_2 = "Country_name";
    public static final String CCOL_3 = "No_of_Unis";
    public static final String CCOL_4 = "Uni_id";


    public final static String TABLE_NAME2 = "University";
    public static final String UCOL_1 = "Uni_id";
    public static final String UCOL_2 = "Uni_name";
    public static final String UCOL_3 = "Uni_address";
    public static final String UCOL_4 = "Uni_contact";
    public static final String UCOL_5 = "Uni_weblink";
    public static final String UCOL_6 = "Uni_country";
    public static final String UCOL_7 = "Uni_region";
    public static final String UCOL_8 = "Scholarship_id";

    public final static String TABLE_NAME3 = "Scholarship";
    public static final String SCOL_1 = "Scholarship_id";
    public static final String SCOL_2 = "Scholarship_name";
    public static final String SCOL_3 = "Scholarship_type";
    public static final String SCOL_4 = "Scholarship_weblink";
    public static final String SCOL_5 = "Starting_data";
    public static final String SCOL_6 = "Ending_data";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        onCreate(db);
    }


    public Cursor getData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query="SELECT * FROM "+TABLE_NAME+" WHERE ID='"+id+"'";
        Cursor  cursor = db.rawQuery(query,null);
        return cursor;
    }


    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
        return res;
    }



}