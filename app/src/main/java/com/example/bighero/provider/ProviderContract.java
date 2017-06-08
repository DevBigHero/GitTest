package com.example.bighero.provider;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by bighero on 2017/4/25.
 */

public class ProviderContract {
    public static final String CONTENT_AUTHORITY = "com.example.bighero.provider";
    private static final Uri BASE_CONTENT_URI = Uri.parse("content://"+CONTENT_AUTHORITY);
    protected static final String PATH_TEST = "user";

    public static class TestEntry implements BaseColumns{
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_TEST).build();
        protected static Uri buildUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI,id);
        }

        protected static final String TABLE_NAME = "test";
        public static final String COLUMN_NAME = "name";

    }


}
