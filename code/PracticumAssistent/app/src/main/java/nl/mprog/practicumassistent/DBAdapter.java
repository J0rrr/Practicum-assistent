package nl.mprog.practicumassistent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter {

	private static final int DATABASE_VERSION = 5;
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

	/*
	// Field Names:
	public static final String KEY_ROWID = "_id";
	public static final String KEY_TASK = "task";
	public static final String KEY_DATE = "date";
	
	public static final String[] ALL_KEYS = new String[] {KEY_ROWID, KEY_TASK, KEY_DATE};
	
	// Column Numbers for each Field Name:
	public static final int COL_ROWID = 0;
	public static final int COL_TASK = 1;
	public static final int COL_DATE = 2;

	// DataBase info:
	public static final String DATABASE_NAME = "dbToDo";
	public static final String DATABASE_TABLE = "mainToDo";
	public static final int DATABASE_VERSION = 2; // The version number must be incremented each time a change to DB structure occurs.
		
	*/

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
	public long addKlas(String klas){
		ContentValues values = new ContentValues();
		values.put(COLUMN_KLAS, klas);
		return db.insert(TABLE_KLASSEN, null, values);
	}

	// Voeg een leerling toe aan de database
	public long addLeerling(String klas, String naam){
		ContentValues values = new ContentValues();
		values.put(COLUMN_KLAS, klas);
		values.put(COLUMN_LEERLING_NAAM, naam);
		return db.insert(TABLE_LEERLINGEN, null, values);
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

	/*
	// Get a specific row (by rowId)
	public Cursor getRow(long rowId) {
		String where = KEY_ROWID + "=" + rowId;
		Cursor c = 	db.query(true, DATABASE_TABLE, ALL_KEYS, 
						where, null, null, null, null, null);
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
	}


}

