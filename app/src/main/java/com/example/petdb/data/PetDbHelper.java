package com.example.petdb.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.petdb.data.PetContract.PetEntry;

public class PetDbHelper extends SQLiteOpenHelper {
    Context ctx;
    String DBNAME;
    String DBPATH;

    public static final String LOG_TAG = PetDbHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "shelter.db";

    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_PETS_TABLE = "CREATE TABLE " +
            "pets" + " (" +
            PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL, " +
            PetEntry.COLUMN_PET_BREED + " TEXT, " +
            PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL, " +
            PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";

    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.ctx=context;
        this.DBNAME="shelter.db";
        this.DBPATH = this.ctx.getDatabasePath(DBNAME).getAbsolutePath();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
