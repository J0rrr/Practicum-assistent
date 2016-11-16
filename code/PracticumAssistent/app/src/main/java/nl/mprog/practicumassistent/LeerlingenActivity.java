package nl.mprog.practicumassistent;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LeerlingenActivity extends AppCompatActivity implements AddLeerlingDialog.DialogListener{

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
                niuweLeerlingDialog();
            }
        });

    }

    public void niuweLeerlingDialog(){
        DialogFragment dialog = new AddLeerlingDialog();
        dialog.show(getSupportFragmentManager(), "AddLeerlingDialog");
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
