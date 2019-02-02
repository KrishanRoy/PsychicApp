package com.example.krishanroy.psychic_app_hw_roy_krishan.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.example.krishanroy.psychic_app_hw_roy_krishan.model.TrackAverage;

import java.util.ArrayList;
import java.util.List;

public class CountDatabase extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "count";
    private static final int SCHEMA_VERSION = 1;
    private static final String DATABASE_NAME = "countProgress.db";
    private static CountDatabase countDatabaseInstance;

    public static synchronized CountDatabase getInstance(Context context){
        if(countDatabaseInstance == null){
            countDatabaseInstance = new CountDatabase(context.getApplicationContext());
        }
        return countDatabaseInstance;
    }


    //constructor...
    private CountDatabase(@Nullable Context context) {
        //factories are ways to construct objects in java and
        // another class will do it for us. [Factory design pattern]
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE " + TABLE_NAME +
                        " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "trial_number INTEGER, success_number INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //non operational. It upgrades the entire database.
    }

    /*
    public DogImage getDogImage(String breed) {
        TrackAverage trackAverage = null;
        Cursor cursor = getReadableDatabase().rawQuery(
                //make sure to put spaces before and after the quotation mark.
                "SELECT " + "breed_url" + " FROM " + TABLE_NAME + " WHERE breed_name " + "= '" + breed + "'';", null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {

                trackAverage = new TrackAverage(
                        cursor.getString(cursor.getColumnIndex("breed_name")),
                        cursor.getString(cursor.getColumnIndex("breed_url")));


            }
        }
        return dogImage;
    }
    */

    public void addNumberOfGamesAndSuccess(int numberOfGames, int numberOfSuccess) {
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME + " WHERE number_of_games = '" + numberOfGames +
                        "' AND number_of_success = '" + numberOfSuccess + "';", null);
        if (cursor.getCount() == 0) {
            getWritableDatabase().execSQL("INSERT INTO " + TABLE_NAME +
                    "(breed_name, breed_url) VALUES('" +
                    numberOfGames + "', '" +
                    numberOfSuccess + "');");
        }
        cursor.close();
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
}


