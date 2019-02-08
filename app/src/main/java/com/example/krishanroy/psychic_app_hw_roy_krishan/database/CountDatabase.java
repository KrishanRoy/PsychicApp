package com.example.krishanroy.psychic_app_hw_roy_krishan.database;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.krishanroy.psychic_app_hw_roy_krishan.model.TrackAverage;

import java.util.ArrayList;
import java.util.List;

import static com.example.krishanroy.psychic_app_hw_roy_krishan.fragments.MainFragment.TAG;

public class CountDatabase extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "count";
    private static final int SCHEMA_VERSION = 1;
    private static final String DATABASE_NAME = "countProgress.db";
    private static CountDatabase countDatabaseInstance;

    public static synchronized CountDatabase getInstance(Context context) {
        if (countDatabaseInstance == null) {
            countDatabaseInstance = new CountDatabase(context.getApplicationContext());
        }
        return countDatabaseInstance;
    }

    private CountDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE " + TABLE_NAME +
                        " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "user_selection TEXT, computer_selection TEXT, result INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void addSelections(TrackAverage trackAverage) {
        getWritableDatabase().execSQL("INSERT INTO " + TABLE_NAME +
                "(user_selection, computer_selection, result) VALUES('" +
                trackAverage.getUserSelection() + "', '" +
                trackAverage.getComputerSelection() + "', '" +
                trackAverage.getResult() + "');");
    }

    public int getProfilesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public int getSuccessCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(" SELECT * FROM "
                + TABLE_NAME + " WHERE result = '" + 1 + "'", null);
        return cursor.getCount();
    }

    public List<TrackAverage> getInputNotesList() {
        List<TrackAverage> inputNotesList = new ArrayList<>();
        TrackAverage trackAverage = null;
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME + ";", null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    trackAverage = new TrackAverage(
                            cursor.getInt(cursor.getColumnIndex("user_selection")),
                            cursor.getInt(cursor.getColumnIndex("computer_selection")),
                            cursor.getInt(cursor.getColumnIndex("result")));
                    inputNotesList.add(trackAverage);
                } while (cursor.moveToNext());
            }
        }
        return inputNotesList;
    }

}


