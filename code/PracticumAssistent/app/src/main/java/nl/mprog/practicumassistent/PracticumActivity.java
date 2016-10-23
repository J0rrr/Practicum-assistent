package nl.mprog.practicumassistent;

import android.app.Activity;
import android.os.Bundle;

public class PracticumActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practicum);

        //
        Bundle titleData = getIntent().getExtras();
        String practicum_klas = titleData.getString("practicum_klas");
        String practicum_naam = titleData.getString("practicum_naam");
        setTitle(practicum_klas + " - " + practicum_naam);
    }
}
