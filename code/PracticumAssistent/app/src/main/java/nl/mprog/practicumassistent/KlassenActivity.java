package nl.mprog.practicumassistent;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class KlassenActivity extends AppCompatActivity implements DialogInterface.OnDismissListener{

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

        populateListView();

        // TODO voeg klas toe
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nieuweKlasDialog();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbAdapter.close();
    }



    public void nieuweKlasDialog(){
        DialogFragment dialog = new AddKlasDialog();
        dialog.show(getSupportFragmentManager(), "AddKlasDialog");
    }

    // wordt aangeroepen als er op 'bevestigen' van de dialog wordt gedrukt
    @Override
    public void onDismiss(final DialogInterface dialog) {
        // Vul de listview opnieuw (met de nieuwe data)
        populateListView();
    }

    // Vult de listview met data (de klassen) uit de database
    public void populateListView() {
        Cursor cursor = dbAdapter.getKlassenRows();

        String[] fromFieldNames = new String[]
                {DBAdapter.COLUMN_KLAS};

        int[] toViewIDs = new int[]
                {android.R.id.text1};

        SimpleCursorAdapter myCursorAdapter;
        myCursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, fromFieldNames, toViewIDs, 0);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(myCursorAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(KlassenActivity.this, LeerlingenActivity.class);
                startActivity(intent);
            }
        });
    }



}
