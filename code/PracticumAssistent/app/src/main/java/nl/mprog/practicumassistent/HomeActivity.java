package nl.mprog.practicumassistent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toolbar;

public class HomeActivity extends Activity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    public void onClickLeerlingen(MenuItem mi) {
        // handle click here
    }
    public void onClickNieuwPracticum(MenuItem mi) {
        // handle click here
    }
    public void onClickNieuwePeriode(MenuItem mi) {
        // handle click here
    }
    public void onClickInfo(MenuItem mi) {
        // handle click here
    }

    // Gebruiker drukt op 'nieuw practicum'
    public void nieuw_practicum(View view) {
        // Start een nieuwe activity
        Intent intent = new Intent(this, NieuwPracticumActivity.class);
        startActivity(intent);
    }
}
