package nl.mprog.practicumassistent;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

import android.widget.ListView;
import android.widget.Toast;

public class KlassenActivity extends AppCompatActivity{

    DBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klassen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Klassen");

        // Open de database connectie
        dbAdapter = new DBAdapter(this);
        dbAdapter.open();

        // Vul de listview met klassen uit de database
        populateListView();

        // Implementeer de floating action button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            // Gebruiker drukt op de floating action button
            @Override
            public void onClick(View view) {
                // Open het dialoogvenster om een nieuwe klas in te voeren
                addKlasDialog();
            }
        });
    }

    // Sluit de database connectie als de activity wordt gesloopt (onDestroy)
    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbAdapter.close();
    }

    // Opent een dialoogvenster waarmee een nieuwe klas kan worden ingevoerd
    public void addKlasDialog(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(KlassenActivity.this);
            dialog.setTitle("Nieuwe klas")
            .setMessage("Voer een naam in voor de nieuwe klas");

        final EditText editText = new EditText(KlassenActivity.this);
        dialog.setView(editText);
        dialog.setPositiveButton("Toevoegen", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                // Lees het veld in en controleer of er wel iets in ingevoerd
                String klas = editText.getText().toString();
                if (klas.equals("")){
                    Toast.makeText(KlassenActivity.this, "Voer een klas in!", Toast.LENGTH_SHORT).show();
                }
                // Voeg de nieuwe klas toe aan de database
                else if (dbAdapter.addKlas(klas)){
                    populateListView();
                }
                else{
                    Toast.makeText(KlassenActivity.this, "Klas bestaat al!", Toast.LENGTH_SHORT).show();
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
        Cursor cursor = dbAdapter.getKlassen();

        String[] fromFieldNames = new String[]
                {DBAdapter.COLUMN_KLAS};

        int[] toViewIDs = new int[]
                {android.R.id.text1};

        SimpleCursorAdapter myCursorAdapter;
        myCursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, fromFieldNames, toViewIDs, 0);
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(myCursorAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String klas = dbAdapter.getKlas(id);
                // Start de LeerlingenActivity en voeg de geselecteerde klas bij
                Intent intent = new Intent(KlassenActivity.this, LeerlingenActivity.class);
                intent.putExtra("klas", klas);
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, final long id) {
                new AlertDialog.Builder(KlassenActivity.this)
                        .setTitle("Verwijder klas")
                        .setMessage("Weet je zeker dat je deze klas wilt verwijderen? Dit kan niet ongedaan worden.")
                        .setPositiveButton("Ja", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Verwijder de klas uit de db, en vul de listview opnieuw
                                dbAdapter.deleteKlas(id);
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
