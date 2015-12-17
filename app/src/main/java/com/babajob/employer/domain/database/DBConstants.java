package com.babajob.employer.domain.database;

public class DBConstants {

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS ";
    public static final char PARANTHESIS_OPEN = '(';
    public static final String DATA_INT_PK = " INTEGER PRIMARY KEY AUTOINCREMENT, ";
    public static final String DATA_TEXT = " TEXT, ";
    public static final String DATA_INTEGER_END = " INTEGER ); ";

    static class JobsColumns {
        public static final String COL_JOB_TITLE = "job_title";
        public static final String COL_SALARY = "";
        public static final String IMAGE_UPDATED_TIME = "updated_time";
    }

}
