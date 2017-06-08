package com.example.bighero.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by bighero on 2017/4/25.
 */

public class ProviderUser extends ContentProvider {
    ProviderDBHelper dbHelper;

    @Override
    public boolean onCreate() {
        dbHelper = new ProviderDBHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        final SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = null;
        switch (buildUriMatcher().match(uri)) {
            case TEST: {
                cursor = db.query(ProviderContract.TestEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
            }
            break;
        }
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        final SQLiteDatabase db = dbHelper.getWritableDatabase();
        Uri returnUri = null;
        long id;
        switch (buildUriMatcher().match(uri)) {
            case TEST: {
                id = db.insert(ProviderContract.TestEntry.TABLE_NAME, null, values);
                if (id > 0) {
                    returnUri = ProviderContract.TestEntry.buildUri(id);
                } else {
                    throw new SQLException("Failed to insert row into" + uri);
                }
            }
            break;
        }
        return returnUri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    private final static int TEST = 100;

    static UriMatcher buildUriMatcher() {
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = ProviderContract.CONTENT_AUTHORITY;

        matcher.addURI(authority, ProviderContract.PATH_TEST, TEST);
        return matcher;
    }

}
