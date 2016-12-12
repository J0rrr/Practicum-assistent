package nl.mprog.practicumassistent;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class LeerlingenActivity extends AppCompatActivity{

    DBAdapter dbAdapter;
    String klas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leerlingen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        klas = extras.getString("klas");

        setTitle(klas);

        // Open de database connectie
        dbAdapter = new DBAdapter(this);
        dbAdapter.open();

        // Vul de listview met klassen uit de database
        populateListView();

        // Implementeer de floating action button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addLeerlingDialog();
            }
        });

    }

    public void addLeerlingDialog(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(LeerlingenActivity.this);
        dialog.setTitle("Nieuwe leerling")
                .setMessage("Voer een naam in voor de nieuwe leerling");

        final EditText editText = new EditText(LeerlingenActivity.this);
        dialog.setView(editText);
        dialog.setPositiveButton("Toevoegen", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                // Lees het veld in en controleer of er wel iets in ingevoerd
                String leerling = editText.getText().toString();
                if (leerling.equals("")){
                    Toast.makeText(LeerlingenActivity.this, "Voer een klas in!", Toast.LENGTH_SHORT).show();
                }

                // Voeg de nieuwe klas toe aan de database
                else {
                    dbAdapter.addLeerling(klas, leerling);
                    populateListView();
                }
            }
        });
        dialog.setNegativeButton("Annuleren", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Doe niks
            }
        })
        .show();
    }

    // Vult de listview met data (de klassen) uit de database
    public void populateListView() {
        Cursor cursor = dbAdapter.getLeerlingenRows();

        String[] fromFieldNames = new String[]
                {DBAdapter.COLUMN_LEERLING_NAAM};

        int[] toViewIDs = new int[]
                {android.R.id.text1};

        SimpleCursorAdapter myCursorAdapter;
        myCursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, fromFieldNames, toViewIDs, 0);
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(myCursorAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(LeerlingenActivity.this, "onItemClick", Toast.LENGTH_SHORT).show();

            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, final long id) {
                new AlertDialog.Builder(LeerlingenActivity.this)
                        .setTitle("Verwijder Leerling")
                        .setMessage("Weet je zeker dat je deze leerling wilt verwijderen? Dit kan niet ongedaan worden.")
                        .setPositiveButton("Ja", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Verwijder de leerling uit de db, en vul de listview opnieuw
                                dbAdapter.deleteLeerling(id);
                                populateListView();
                            }
                        })
                        .setNegativeButton("Nee", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Doe niks
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();

                return true;
            }
        });
    }

}
