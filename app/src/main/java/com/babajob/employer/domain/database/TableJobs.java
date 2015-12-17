package com.babajob.employer.domain.database;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class TableJobs {


    public static final String NAME = "table_images";

    public static void onCreate(SQLiteDatabase db) {
        final StringBuilder tableBuilder = new StringBuilder(DBConstants.CREATE_TABLE + NAME + DBConstants.PARANTHESIS_OPEN).append(BaseColumns._ID + DBConstants.DATA_INT_PK)
                .append(DBConstants.JobsColumns.COL_JOB_TITLE + DBConstants.DATA_TEXT).append(DBConstants.JobsColumns.COL_SALARY + DBConstants.DATA_TEXT)
                .append(DBConstants.JobsColumns.IMAGE_UPDATED_TIME + DBConstants.DATA_INTEGER_END);
        db.execSQL(tableBuilder.toString());
    }

    public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
