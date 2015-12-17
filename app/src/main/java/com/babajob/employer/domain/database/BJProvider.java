package com.babajob.employer.domain.database;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class BJProvider extends ContentProvider {

    public static final String URI_PREFIX = "content://com.babajob.employer.provider/";

    public static final String AUTHORITY = "com.babajob.employer.provider";

    public static final int DB_VERSION_V_1_0 = 1;
    public static final Uri URI_HOME = Uri.parse(URI_PREFIX + TableJobs.NAME);
    private static final String DB_NAME = "bjemployer.db";
    private static final int DB_VERSION = DB_VERSION_V_1_0;
    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
    private static final int CONTENT_HOME = 100;

    static {
        URI_MATCHER.addURI(AUTHORITY, TableJobs.NAME, CONTENT_HOME);
    }

    /**
     * DatabaseHelper instance.
     */
    private BJSQLiteOpenHelper mTestSQLiteOpenHelper;

    public static String getTableName(final int contentType) {
        switch (contentType) {

            case CONTENT_HOME:
                return TableJobs.NAME;
            default:
                return null;

        }
    }

    @Override
    public boolean onCreate() {
        mTestSQLiteOpenHelper = new BJSQLiteOpenHelper(getContext(), DB_NAME, null, DB_VERSION);
        return false;
    }

    @Override
    public String getType(Uri arg0) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        final SQLiteDatabase database = mTestSQLiteOpenHelper.getWritableDatabase();
        final String tableName = getTableName(URI_MATCHER.match(uri));
        long rowId = database.insert(tableName, null, values);
        if (rowId != -1) {
            return ContentUris.withAppendedId(uri, rowId);
        }
        return null;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        final SQLiteDatabase database = mTestSQLiteOpenHelper.getWritableDatabase();
        final String tableName = getTableName(URI_MATCHER.match(uri));
        Cursor cursor = database.query(tableName, projection, selection, selectionArgs, null, null, sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        final SQLiteDatabase database = mTestSQLiteOpenHelper.getWritableDatabase();
        int count = 0;
        final String tableName = getTableName(URI_MATCHER.match(uri));
        count = database.update(tableName, values, selection, selectionArgs);
        return count;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        final SQLiteDatabase database = mTestSQLiteOpenHelper.getWritableDatabase();
        int count = 0;

        final String tableName = getTableName(URI_MATCHER.match(uri));
        count = database.delete(tableName, selection, selectionArgs);
        return count;
    }

}
