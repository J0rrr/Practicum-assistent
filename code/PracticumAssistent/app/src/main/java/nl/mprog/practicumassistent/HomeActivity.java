package nl.mprog.practicumassistent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    // Gebruiker drukt op 'nieuw practicum'
    public void nieuw_practicum(View view) {
        // Start een nieuwe activity
        Intent intent = new Intent(this, NieuwPracticumActivity.class);
        startActivity(intent);
    }
}
