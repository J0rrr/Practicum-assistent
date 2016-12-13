package nl.mprog.practicumassistent;

import android.app.ActionBar;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

public class HomeActivity extends AppCompatActivity {
    //private Toolbar toolbar;

    ListView lstItems;
    DBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Open de database connectie
        dbAdapter = new DBAdapter(this);
        dbAdapter.open();

        // Vul de listview met practica uit de database
        populateListView();
        }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    public void onClickLeerlingen(MenuItem mi) {
        // handle click here
        Intent intent = new Intent(this, KlassenActivity.class);
        startActivity(intent);
    }
    public void onClickNieuwPracticum(MenuItem mi) {
        // handle click here
        // Start een nieuwe activity
        Intent intent = new Intent(this, NieuwPracticumActivity.class);
        startActivity(intent);
    }
    public void onClickNieuwePeriode(MenuItem mi) {
        // handle click here
    }
    public void onClickInfo(MenuItem mi) {
        // handle click here
    }

    public void fabClick (View v){
        // Start een nieuwe activity
        Intent intent = new Intent(this, NieuwPracticumActivity.class);
        startActivity(intent);
    }

    // Vult de listview met data (de klassen) uit de database
    public void populateListView() {
        Cursor cursor = dbAdapter.getPractica();

        String[] fromFieldNames = new String[]
                {DBAdapter.COLUMN_KLAS, DBAdapter.COLUMN_NAAM, DBAdapter.COLUMN_DATUM};

        int[] toViewIDs = new int[]
                {R.id.klas, R.id.naam, R.id.datum};

        SimpleCursorAdapter myCursorAdapter;
        myCursorAdapter = new SimpleCursorAdapter(this, R.layout.listitem_practicum, cursor, fromFieldNames, toViewIDs, 0);
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(myCursorAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String klas = dbAdapter.getKlas(id);
//                // Start de LeerlingenActivity en voeg de geselecteerde klas bij
//                Intent intent = new Intent(KlassenActivity.this, LeerlingenActivity.class);
//                intent.putExtra("klas", klas);
//                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, final long id) {
//                new AlertDialog.Builder(KlassenActivity.this)
//                        .setTitle("Verwijder klas")
//                        .setMessage("Weet je zeker dat je deze klas wilt verwijderen? Dit kan niet ongedaan worden.")
//                        .setPositiveButton("Ja", new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int which) {
//                                // Verwijder de klas uit de db, en vul de listview opnieuw
//                                dbAdapter.deleteKlas(id);
//                                populateListView();
//                            }
//                        })
//                        .setNegativeButton("Nee", new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int which) {
//                                // Doe niks
//                            }
//                        })
//                        .setIcon(android.R.drawable.ic_dialog_alert)
//                        .show();

                return true;
            }
        });
    }
}
