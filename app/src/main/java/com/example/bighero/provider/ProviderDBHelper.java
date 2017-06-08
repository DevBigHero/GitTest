package com.example.bighero.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by bighero on 2017/4/25.
 */

public class ProviderDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "test.db";
    private static final int DATABASE_VERSION = 1;

    public ProviderDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_CONTACT_TABLE = "create table " + ProviderContract.TestEntry.TABLE_NAME + "(" + ProviderContract.TestEntry._ID + " text primary key," + ProviderContract.TestEntry.COLUMN_NAME + " text not null);";
        db.execSQL(SQL_CREATE_CONTACT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists"+ProviderContract.TestEntry.TABLE_NAME);
        onCreate(db);
    }
}
