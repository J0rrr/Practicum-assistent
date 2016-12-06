package nl.mprog.practicumassistent;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBHandler extends SQLiteOpenHelper {

    SQLiteDatabase db;

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "practicumassistent.db";
    public static final String TABLE_KLAS = "testklas";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PRACTICUM_NAAM = "Naam practicum";
    public static final String COLUMN_PRACTICUM_DATUM = "Datum practicum";
    public static final String COLUMN_PRACTICUM_OPMERKINGEN = "Opmerkingen practicum";


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_KLAS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PRACTICUM_NAAM + " TEXT, " +
                COLUMN_PRACTICUM_DATUM + " TEXT, " +
                COLUMN_PRACTICUM_OPMERKINGEN + " TEXT " +
                ");");
        db.close();
    }

    public void createTable(String klas){
        db = this.getWritableDatabase();
        db.execSQL("CREATE TABLE " + klas + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PRACTICUM_NAAM + " TEXT, " +
                COLUMN_PRACTICUM_DATUM + " TEXT, " +
                COLUMN_PRACTICUM_OPMERKINGEN + " TEXT " +
                ");");
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    // Voeg een practicum toe aan de database
    public void addPracticum(Practicum practicum){
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRACTICUM_NAAM, practicum.get_practicumnaam());
        values.put(COLUMN_PRACTICUM_DATUM, practicum.get_practicumdatum());
        values.put(COLUMN_PRACTICUM_OPMERKINGEN, practicum.get_practicumopmerking());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_KLAS, null, values);
        db.close();
    }

    // Verwijder een practicum uit de database ZOU HEEL GOED NIET KUNNEN WERKEN, ZIE THENEWBOSTON 52
    public void deletePracticum(Practicum practicum){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_KLAS + " WHERE " + COLUMN_PRACTICUM_NAAM + " =\"" + practicum.get_practicumnaam() + "\";");
    }

}
