package nl.mprog.practicumassistent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class NieuwPracticumActivity extends Activity implements AdapterView.OnItemSelectedListener {

    Button maak_button;
    EditText practicum_naam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nieuw_practicum);
        setTitle("Nieuw Practicum");

        maak_button = (Button) findViewById(R.id.maak_button);
        maak_button.setEnabled(false);

        practicum_naam = (EditText) findViewById(R.id.practicum_naam);
        practicum_naam.addTextChangedListener(practicumNaamWatcher);

        // TODO dit niet hardgecode
        List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add("kies klas");
        spinnerArray.add("3C");
        spinnerArray.add("3D");
        spinnerArray.add("3E");

        // Vul de spinner met 'klassen'
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = (Spinner) findViewById(R.id.practicum_klas);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    private TextWatcher practicumNaamWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        if (pos == 0){
            maak_button.setEnabled(false);
        }
        else {
            maak_button.setEnabled(true);
        }

    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }



    // Gebruiker drukt op 'Maak practicum'
    public void maak_practicum(View view) {
        // Start een nieuwe activity
        Intent intent = new Intent(this, PracticumActivity.class);

        // Stop de naam en klas informatie bij de intent
        String naam = practicum_naam.getText().toString();
        Spinner sItems = (Spinner) findViewById(R.id.practicum_klas);
        String practicum_klas = sItems.getSelectedItem().toString();
        intent.putExtra("practicum_naam", naam);
        intent.putExtra("practicum_klas", practicum_klas);
        //String practicum_klas =
        startActivity(intent);
    }
}
