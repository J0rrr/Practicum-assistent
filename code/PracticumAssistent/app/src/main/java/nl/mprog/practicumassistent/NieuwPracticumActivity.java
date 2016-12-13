package nl.mprog.practicumassistent;

import android.content.Intent;
import android.database.Cursor;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;


public class NieuwPracticumActivity extends AppCompatActivity{

    DBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nieuw_practicum);
        setTitle("Nieuw Practicum");

        // Open de database connectie
        dbAdapter = new DBAdapter(this);
        dbAdapter.open();


        //getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        populateSpinner();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_nieuw_practicum, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        MenuItem item = menu.findItem(R.id.action_maak_practicum);
//
//        if (containsText(practicum_naam)) {
//            item.setEnabled(true);
//            item.getIcon().setAlpha(255);
//        } else {
//            // disabled
//            item.setEnabled(false);
//            item.getIcon().setAlpha(100);
//        }
        return true;
    }

    // Vult de spinner met data (de klassen) uit de database
    public void populateSpinner() {
        DBAdapter dbAdapter = new DBAdapter(this);
        dbAdapter.open();
        Cursor cursor = dbAdapter.getKlassen();

        String[] fromFieldNames = new String[]
                {DBAdapter.COLUMN_KLAS};

        int[] toViewIDs = new int[]
                {android.R.id.text1};

        SimpleCursorAdapter myCursorAdapter;
        myCursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_spinner_item, cursor, fromFieldNames, toViewIDs, 0);
        myCursorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = (Spinner) findViewById(R.id.practicum_klas);
        spinner.setAdapter(myCursorAdapter);
    }

    public void onClickMaakPracticum(MenuItem mi) {

        // Haal de naam, klas en opmerkingen informatie uit de velden
        EditText edt_naam = (EditText) findViewById(R.id.practicum_naam);
        String naam = edt_naam.getText().toString();
        Spinner spn = (Spinner) findViewById(R.id.practicum_klas);
        Cursor cursor = (Cursor) spn.getSelectedItem();
        String klas = cursor.getString(cursor.getColumnIndex("Klas"));
        EditText edt_opmerkingen = (EditText) findViewById(R.id.practicum_opmerkingen);
        String opmerkingen = edt_opmerkingen.getText().toString();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String datum = simpleDateFormat.format(new Date());

        // Controleer of er wel een naam is ingevoerd
        if (naam.equals("")) {
            Toast.makeText(this, "Voer een naam in!", Toast.LENGTH_SHORT).show();
        }

        // Start een nieuwe activity
        else {
            // Bewaar de info uit de velden in de database
            // Bij succes: start een nieuwe activity
            if(dbAdapter.addPracticum(klas, naam, datum, opmerkingen)){
                Intent intent = new Intent(this, PracticumActivity.class);
                intent.putExtra("klas", klas);
                intent.putExtra("naam", naam);
                startActivity(intent);
            }

            // Anders: waarschijnlijk bestaat het practicum al, geef dit door
            else{
                Toast.makeText(this, "Practicum bestaat al!", Toast.LENGTH_SHORT).show();
            }


        }
    }
}
