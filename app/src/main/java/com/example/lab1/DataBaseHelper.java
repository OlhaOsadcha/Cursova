package com.example.lab1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String USER_TABLE = "USER_TABLE";
    public static final String COLUMN_USER_NAME = "USER_NAME";
    public static final String COLUMN_USER_SURNAME = "USER_SURNAME";
    public static final String COLUMN_USER_AGE = "USER_AGE";
    public static final String COLUMN_ACTIVE_USER = "ACTIVE_USER";
    public static final String COLUMN_ID = "ID";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "user.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement =
                "CREATE TABLE " +
                        USER_TABLE +
                        " (" +
                        COLUMN_ID +
                        " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_USER_NAME +
                        " TEXT, " +
                        COLUMN_USER_SURNAME +
                        " TEXT, " +
                        COLUMN_USER_AGE +
                        " INT, " +
                        COLUMN_ACTIVE_USER +
                        " BOOL)";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    public boolean addOne(UserModel userModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_USER_NAME, userModel.getName());
        cv.put(COLUMN_USER_SURNAME, userModel.getSurname());
        cv.put(COLUMN_USER_AGE, userModel.getAge());
        cv.put(COLUMN_ACTIVE_USER, userModel.isActive());

        long insert = db.insert(USER_TABLE, null, cv);

        if (insert == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    public List<UserModel> getEveryone() {
        List<UserModel> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + USER_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do {
                int userId = cursor.getInt(0);
                String userName = cursor.getString(1);
                String userSurname = cursor.getString(2);
                int userAge = cursor.getInt(3);
                boolean userActive = cursor.getInt(4) == 1 ? true : false;

                UserModel userModel = new UserModel(
                        userId,
                        userName,
                        userSurname,
                        userAge,
                        userActive
                );

                returnList.add(userModel);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return returnList;
    }

}
