package nl.mprog.practicumassistent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PracticumActivity extends AppCompatActivity implements AddGebeurtenisDialog.DialogListener{

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practicum);

        // Maak de titel en geef het weer( klas + naam van practicum)
        Bundle titleData = getIntent().getExtras();
        String practicum_klas = titleData.getString("practicum_klas");
        String practicum_naam = titleData.getString("practicum_naam");
        setTitle(practicum_klas + " - " + practicum_naam);


        // Vul de ListView
        listView = (ListView) findViewById(R.id.leerlingen_list);
        // TODO
        listView.setAdapter(new ArrayAdapter<>(PracticumActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.leerlingen)));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                nieuweGebeurtenisDialog();
            }
        });

    }

    public void nieuweGebeurtenisDialog(){
        DialogFragment dialog = new AddGebeurtenisDialog();
        dialog.show(getSupportFragmentManager(), "AddGebeurtenisDialog");
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        // User touched the dialog's positive button

    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        // User touched the dialog's negative button

    }
}
