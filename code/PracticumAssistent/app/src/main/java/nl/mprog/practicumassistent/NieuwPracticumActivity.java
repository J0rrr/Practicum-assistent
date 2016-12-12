package nl.mprog.practicumassistent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


public class NieuwPracticumActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText practicum_naam;
    boolean spinState = false;
    boolean txtState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nieuw_practicum);
        setTitle("Nieuw Practicum");

        //getSupportActionBar().setHomeButtonEnabled(true);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        practicum_naam = (EditText) findViewById(R.id.practicum_naam);
        practicum_naam.addTextChangedListener(practicumNaamWatcher);

        // Vul de spinner met 'klassen'
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.klassen));

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = (Spinner) findViewById(R.id.practicum_klas);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_nieuw_practicum, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        MenuItem item = menu.findItem(R.id.action_maak_practicum);

        if (spinState && containsText(practicum_naam)) {
            item.setEnabled(true);
            item.getIcon().setAlpha(255);
        } else {
            // disabled
            item.setEnabled(false);
            item.getIcon().setAlpha(100);
        }
        return true;
    }

    public void onClickMaakPracticum(MenuItem mi) {
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

    private TextWatcher practicumNaamWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            invalidateOptionsMenu();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public boolean containsText(EditText editText) {
        if (editText.getText().toString().trim().length() > 0)
            return true;

        return false;
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        if (pos == 0){
            spinState = false;
        }
        else {
            spinState = true;
        }
        invalidateOptionsMenu();

    }

    public void onNothingSelected(AdapterView<?> parent){

    }
}
