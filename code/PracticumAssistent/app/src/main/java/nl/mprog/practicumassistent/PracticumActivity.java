package nl.mprog.practicumassistent;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PracticumActivity extends AppCompatActivity {

    ListView lstItems;

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
        lstItems = (ListView) findViewById(R.id.leerlingen_list);
        // TODO
        lstItems.setAdapter(new ArrayAdapter<>(PracticumActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.leeringen)));
    }
}
