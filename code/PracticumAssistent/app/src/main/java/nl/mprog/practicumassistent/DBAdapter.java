//
// Code sterk geïnspireerd door een tuturial van 'Lecture Snippets'.
// https://www.youtube.com/watch?v=c-7sW6UJHw0 TODO goede referentie maken
//
package nl.mprog.practicumassistent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

public class DBAdapter {

	private static final int DATABASE_VERSION = 6;
	private static final String DATABASE_NAME = "practicumassistent.db";

	// Tabellen
	public static final String TABLE_KLASSEN = "klassen";
	public static final String TABLE_LEERLINGEN = "Leerlingen";
	public static final String TABLE_PRACTICA = "Practica";
	public static final String TABLE_GEBEURTENISSEN = "Gebeurtenissen";

	// Kolommen in de 'klassen' tabel
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_LEERLING_ID = "_id_leerling";
	public static final String COLUMN_PRACTICUM_ID = "_id_practicum";
	public static final String COLUMN_KLAS = "Klas";
	public static final String COLUMN_NAAM = "Naam";
	public static final String COLUMN_OPMERKING = "Practicum_opmerking";
	public static final String COLUMN_DATUM = "Datum";
	public static final String COLUMN_WAARDE = "Gebeurtenis_waarde";

	private final Context context;
	private DatabaseHelper myDBHelper;
	private SQLiteDatabase db;


	public DBAdapter(Context ctx) {
		this.context = ctx;
		myDBHelper = new DatabaseHelper(context);
	}
	
	// Open the database connection.
	public DBAdapter open() {
		db = myDBHelper.getWritableDatabase();
		return this;
	}
	
	// Close the database connection.
	public void close() {
		myDBHelper.close();
	}

	// Voeg een Klas toe aan de database
	public boolean addKlas(String klas) {
		ContentValues values = new ContentValues();
		values.put(COLUMN_KLAS, klas);

		// Voeg alleen toe als de ingevoerde klas nog niet bestaat, return anders false
		String query = "SELECT * FROM " + TABLE_KLASSEN + " WHERE " + COLUMN_KLAS + " = \"" + klas + "\"";
		Cursor cursor = db.rawQuery(query, null);
		if (cursor != null && cursor.getCount() != 0) {
			return false;
		} else {
			db.insert(TABLE_KLASSEN, null, values);
			return true;
		}
	}

	// Voeg een leerling toe aan de database
	public boolean addLeerling(String klas, String naam){
		ContentValues values = new ContentValues();
		values.put(COLUMN_KLAS, klas);
		values.put(COLUMN_NAAM, naam);

		// Voeg alleen toe als de ingevoerde leerling-klas combi nog niet bestaat, return anders false
		String query = "SELECT * FROM " + TABLE_LEERLINGEN + " WHERE "
				+ COLUMN_KLAS + " = \"" + klas + "\" AND "
				+ COLUMN_NAAM + " = \"" + naam + "\"";
		Cursor cursor = db.rawQuery(query, null);
		if (cursor != null && cursor.getCount() != 0) {
			return false;
		} else {
			db.insert(TABLE_LEERLINGEN, null, values);
			return true;
		}
	}

	// Voeg een practicum toe aan de database
	public boolean addPracticum(String klas, String naam, String datum, String opmerking){
		ContentValues values = new ContentValues();
		values.put(COLUMN_KLAS, klas);
		values.put(COLUMN_NAAM, naam);
		values.put(COLUMN_DATUM, datum);
		values.put(COLUMN_OPMERKING, opmerking);

		// Voeg alleen toe als de ingevoerde naam-klas combi nog niet bestaat, return anders false
		String query = "SELECT * FROM " + TABLE_PRACTICA + " WHERE "
				+ COLUMN_KLAS + " = \"" + klas + "\" AND "
				+ COLUMN_NAAM + " = \"" + naam + "\"";
		Cursor cursor = db.rawQuery(query, null);
		if (cursor != null && cursor.getCount() != 0) {
			return false;
		} else {
			db.insert(TABLE_PRACTICA, null, values);
			return true;
		}
	}
	
	// Verwijder een klas uit de tabel met klassen
	public boolean deleteKlas(long rowId) {
		String where = COLUMN_ID + "=" + rowId;
		return db.delete(TABLE_KLASSEN, where, null) != 0;
	}

	// Verwijder een leerling uit de tabel met leerlingen
	public boolean deleteLeerling(long rowId) {
		String where = COLUMN_ID + "=" + rowId;
		return db.delete(TABLE_LEERLINGEN, where, null) != 0;
	}

	// return alle rijen uit de klassen database
	public Cursor getKlassen(){
		String table = TABLE_KLASSEN;
		String[] Columns = null; // geen selectie wil zeggen: alle columns
		String selection = null;
		String[] selectionArgs = null;
		String groupBy = null;
		String having = null;
		String orderBy = COLUMN_KLAS + " ASC";
		String limit = null;
		Cursor cursor = db.query(true, table, Columns, selection, selectionArgs, groupBy, having, orderBy, limit);

		if (cursor != null) {
			cursor.moveToFirst();
		}
		return cursor;
	}

	// return alle rijen uit de practica database
	public Cursor getPractica(){
		String table = TABLE_PRACTICA;
		String[] Columns = null; // geen selectie wil zeggen: alle columns
		String selection = null;
		String[] selectionArgs = null;
		String groupBy = null;
		String having = null;
		String orderBy = COLUMN_DATUM + " DESC";
		String limit = null;
		Cursor cursor = db.query(true, table, Columns, selection, selectionArgs, groupBy, having, orderBy, limit);

		if (cursor != null) {
			cursor.moveToFirst();
		}
		return cursor;
	}

	// return alle leerlingen uit de klassen database van een bepaalde klas
	public Cursor getLeerlingen(String klas){
		String table = TABLE_LEERLINGEN;
		String[] Columns = null; // geen selectie wil zeggen: alle columns
		String selection = COLUMN_KLAS + " = \"" + klas + "\"";
		String[] selectionArgs = null;
		String groupBy = null;
		String having = null;
		String orderBy = COLUMN_NAAM + " ASC";
		String limit = null;
		Cursor c = db.query(true, table, Columns, selection, selectionArgs, groupBy, having, orderBy, limit);

		if (c != null) {
			c.moveToFirst();
		}
		return c;
	}


	// Get a specific row (by rowId)
	public String getKlas(long rowId) {
		String selection = COLUMN_ID + "=" + rowId;
		Cursor cursor = db.query(true, TABLE_KLASSEN, null, selection, null, null, null, null, null);
		if (cursor.moveToFirst()){
			return cursor.getString(cursor.getColumnIndex(COLUMN_KLAS));
		}
		return null;
	}

	/*


		// Get a specific row (by rowId)
	public Cursor getRow(String table, long rowId) {
		String selection = COLUMN_ID + "=" + rowId;
		Cursor c = 	db.query(true, table, null,
						selection, null, null, null, null, null);
		if (c != null) {
			c.moveToFirst();
		}
		return c;
	}

	// Change an existing row to be equal to new data.
	public boolean updateRow(long rowId, String task, String date) {
		String where = KEY_ROWID + "=" + rowId;
		ContentValues newValues = new ContentValues();
		newValues.put(KEY_TASK, task);
		newValues.put(KEY_DATE, date);
		// Insert it into the database.
		return db.update(DATABASE_TABLE, newValues, where, null) != 0;
	}

	*/
	private static class DatabaseHelper extends SQLiteOpenHelper
	{
		DatabaseHelper(Context context) {
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
					COLUMN_NAAM + " TEXT " +
					");");

			// maak tabel met practica
			db.execSQL("CREATE TABLE " + TABLE_PRACTICA + "(" +
					COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
					COLUMN_KLAS + " TEXT, " +
					COLUMN_NAAM + " TEXT, " +
					COLUMN_DATUM + " TEXT, " +
					COLUMN_OPMERKING + " TEXT " +
					");");

			// maak tabel met gebeurtenissen
			db.execSQL("CREATE TABLE " + TABLE_GEBEURTENISSEN + "(" +
					COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
					COLUMN_LEERLING_ID + " TEXT, " +
					COLUMN_PRACTICUM_ID + " TEXT, " +
					COLUMN_NAAM + " TEXT, " +
					COLUMN_WAARDE + "TEXT " +
					");");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_KLASSEN);
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_LEERLINGEN);
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRACTICA);
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_GEBEURTENISSEN);
			onCreate(db);
		}
	}
}

