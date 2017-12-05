package com.michael.carsensor.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DB_NAME = "sensor.db";
    private static DbHelper instance;

    public static DbHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DbHelper(context);
        }
        return instance;
    }

    private DbHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_sql = "CREATE TABLE IF NOT EXISTS sensor_test ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "type INTEGER NOT NULL,"
                + "x FLOAT NOT NULL,"
                + "y FLOAT NOT NULL,"
                + "z FLOAT NOT NULL,"
                + "timeline INTEGER NOT NULL)";

        db.execSQL(create_sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
