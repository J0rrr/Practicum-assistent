package nl.mprog.practicumassistent;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

public class HomeActivity extends AppCompatActivity {
    //private Toolbar toolbar;

    ListView lstItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        // Vul de ListView
        lstItems = (ListView) findViewById(R.id.lv_practica);
        // TODO
        lstItems.setAdapter(new ArrayAdapter<>(HomeActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.practica)));
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
}
