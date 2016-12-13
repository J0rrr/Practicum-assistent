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
import android.widget.Toast;

public class PracticumActivity extends AppCompatActivity implements AddGebeurtenisDialog.DialogListener{

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practicum);

        // Maak de titel en geef het weer (klas + naam van practicum)
        Bundle titleData = getIntent().getExtras();
        String klas = titleData.getString("klas");
        String naam = titleData.getString("naam");
        Toast.makeText(this, klas, Toast.LENGTH_SHORT).show();
        setTitle(klas + " - " + naam);


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
