package nl.mprog.practicumassistent;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LeerlingenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leerlingen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Vul de ListView met Leerlingen
        ListView listView = (ListView) findViewById(R.id.listView);
        // TODO
        listView.setAdapter(new ArrayAdapter<>(LeerlingenActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.leerlingen)));



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getSupportFragmentManager();
                AddLeerlingDialog addLeerlingDialog = new AddLeerlingDialog();
                addLeerlingDialog.show(manager, "AddLeerlingDialog");
            }
        });

    }

}
