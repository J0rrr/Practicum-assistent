package nl.mprog.practicumassistent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_NAME = "practicumassistent.db";
    public static final String TABLE_LEERLINGEN = "Leerlingen";
    public static final String TABLE_KLASSEN = "klassen";
    public static final String TABLE_GEBEURTENISSEN = "Gebeurtenissen";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_KLAS = "Klas";
    public static final String COLUMN_LEERLING_NAAM = "Naam";
    public static final String COLUMN_PRACTICUM_NAAM = "Practicum_naam";
    public static final String COLUMN_PRACTICUM_OPMERKINGEN = "Practicum_opmerkingen";
    public static final String COLUMN_DATUM = "Datum";
    public static final String COLUMN_GEBEURTENIS_NAAM = "Gebeurtenis_naam";
    public static final String COLUMN_GEBEURTENIS_WAARDE = "Gebeurtenis_waarde";

    private DatabaseHelper myDBHandler;
    private SQLiteDatabase db;


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // maak tabel met klassen
        db.execSQL("CREATE TABLE " + TABLE_KLASSEN + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_KLAS + " TEXT " +
                ");");

        // maak tabel met leerlingen
        db.execSQL("CREATE TABLE " + TABLE_LEERLINGEN + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_KLAS + " TEXT, " +
                COLUMN_LEERLING_NAAM + " TEXT " +
                ");");

        // maak tabel met gebeurtenissen
        db.execSQL("CREATE TABLE " + TABLE_GEBEURTENISSEN + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_KLAS + " TEXT, " +
                COLUMN_LEERLING_NAAM + " TEXT, " +
                COLUMN_DATUM + " TEXT, " +
                COLUMN_PRACTICUM_NAAM + " TEXT, " +
                COLUMN_PRACTICUM_OPMERKINGEN + " TEXT, " +
                COLUMN_GEBEURTENIS_NAAM + " TEXT, " +
                COLUMN_GEBEURTENIS_WAARDE + "TEXT " +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LEERLINGEN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GEBEURTENISSEN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KLASSEN);
        onCreate(db);
    }

    public DBHandler open() {
        db = myDBHandler.getWritableDatabase();
        return this;
    }

    public void close(){
        myDBHandler.close();
    }

    // return alle rijen uit de klassen database
    public Cursor getKlassenRows(){
        String table = TABLE_KLASSEN;
        String[] Columns = null; // geen selectie wil zeggen: alle columns
        String selection = null;
        String[] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = COLUMN_KLAS + " ASC";
        String limit = null;
        Cursor c = db.query(true, table, Columns, selection, selectionArgs, groupBy, having, orderBy, limit);

        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }


    // Voeg een Klas toe aan de database
    public void addKlas(String klas){
        ContentValues values = new ContentValues();
        values.put(COLUMN_KLAS, klas);
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_KLASSEN, null, values);
        db.close();
    }

    // Voeg een leerling toe aan de database
    public void addLeerling(String klas, String naam){
        ContentValues values = new ContentValues();
        values.put(COLUMN_KLAS, klas);
        values.put(COLUMN_LEERLING_NAAM, naam);
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_LEERLINGEN, null, values);
        db.close();
    }


    // Verwijder een leerling uit de database ZOU HEEL GOED NIET KUNNEN WERKEN, ZIE THENEWBOSTON 52
    public void deleteLeerling(String klas, String naam){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_LEERLINGEN +
                " WHERE " + COLUMN_KLAS + " =\"" + klas + "\"" +
                " AND " + COLUMN_LEERLING_NAAM + "=\"" + naam + "\";");
    }

}
*/