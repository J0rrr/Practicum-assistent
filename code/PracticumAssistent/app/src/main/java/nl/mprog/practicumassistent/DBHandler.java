package nl.mprog.practicumassistent;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "practicumassistent.db";
    public static final String TABLE_KLAS = "klas";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PRACTICUM = "practicum";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_KLAS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " +
                COLUMN_PRACTICUM + " TEXT " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KLAS);
        onCreate(db);
    }


    // Voeg een practicum toe aan de database
    public void addPracticum(Practica practicum){
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRACTICUM, practicum.get_practicumnaam());
        values.put(COLUMN_PRACTICUM, practicum.get_practicumdatum());
        values.put(COLUMN_PRACTICUM, practicum.get_practicumopmerking());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_KLAS, null, values);
        db.close();
    }

    // Verwijder een practicum uit de database ZOU HEEL GOED NIET KUNNEN WERKEN, ZIE THENEWBOSTON 52
    public void deletePracticum(Practica practicum){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_KLAS + " WHERE " + COLUMN_PRACTICUM + " = " + practicum + ";");
    }

}
