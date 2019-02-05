package com.example.krishanroy.psychic_app_hw_roy_krishan.database;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.example.krishanroy.psychic_app_hw_roy_krishan.model.TrackAverage;

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
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME + " WHERE user_selection = '" + trackAverage.getUserSelection() +
                        "' AND computer_selection = '" + trackAverage.getComputerSelection() + "' AND result = '" + trackAverage.getResult() +
                        "';", null);
        if (cursor.getCount() == 0) {
            getWritableDatabase().execSQL("INSERT INTO " + TABLE_NAME +
                    "(user_selection, computer_selection, result) VALUES('" +
                    trackAverage.getUserSelection() + "', '" +
                    trackAverage.getComputerSelection() + "', '" +
                    trackAverage.getResult() + "');");
        }
        cursor.close();
    }

    public long getProfilesCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return count;
    }

    public long getSuccessCount() {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(" SELECT COUNT(*) FROM "
//                + TABLE_NAME + " WHERE result = '" + 1 + "'", null);
//        return cursor.getCount();
        int a = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(" SELECT COUNT(*) FROM "
                + TABLE_NAME + " WHERE result = '" + 1 + "';", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            a = cursor.getCount();
        }
        cursor.close();
        db.close();
        return a;
    }
    //now we will create a method that will return a List with all the dogImageUrls and then we will pass it into the
    /*
    public List<TrackAverage> getNumberOfSuccessList(){
        List<TrackAverage> trackAverageList = new ArrayList<>();
        TrackAverage trackAverage = null;
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME + ";", null);
        if(cursor != null) {
            if(cursor.moveToFirst()) {
                do {
                    trackAverage = new TrackAverage(
                            cursor.getInt(cursor.getColumnIndex("number_of_games")),
                            cursor.getInt(cursor.getColumnIndex("number_of_success")));
                    trackAverageList.add(trackAverage);
                } while (cursor.moveToNext());
            }
        }
        return trackAverageList;
    }
*/

    /*public TrackAverage getSelectionResult(String computerSelection) {
        TrackAverage trackAverage = null;
        Cursor cursor = getReadableDatabase().rawQuery(
                //make sure to put spaces before and after the quotation mark.
                "SELECT " + "user_selection" + " FROM " + TABLE_NAME + " WHERE computer_selection " + "= '" + computerSelection + "'';", null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {

                trackAverage = new TrackAverage(
                        cursor.getString(cursor.getColumnIndex("user_selection")),
                        cursor.getString(cursor.getColumnIndex("computer_selection")));

            }
        }
        return trackAverage;
    }*/

}


