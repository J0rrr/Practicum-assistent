package nl.mprog.practicumassistent;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddLeerlingDialog extends DialogFragment {

    DBAdapter dbAdapter;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        View layout = inflater.inflate(R.layout.dialog_add_leerling, null);
        builder.setView(layout);
        final EditText editText = (EditText)layout.findViewById(R.id.editText);
        builder.setTitle("Nieuwe leerling")
                // Add action buttons
                .setPositiveButton("Toevoegen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // Lees het veld in en controleer of er wel iets in ingevoerd
                        String leerling = editText.getText().toString();
                        if (leerling.equals("")){
                            Toast.makeText(getActivity(), "Voer een klas in!", Toast.LENGTH_SHORT).show();
                        }

                        // Voeg de nieuwe leerling toe aan de database
                        else {
                            // Voeg de leerling toe aan de database
//                            dbAdapter = new DBAdapter(getActivity());
//                            dbAdapter.open();
//                            dbAdapter.addLeerling(LeerlingenActivity.klas , leerling);
//                            dbAdapter.close();

                            // Geef aan LeerlingenActivity door dat de dialog klaar is
                            if (getActivity() instanceof DialogInterface.OnDismissListener) {
                                ((DialogInterface.OnDismissListener) getActivity()).onDismiss(dialog);
                            }
                        }
                    }
                })

                .setNegativeButton("Annuleren", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        return builder.create();
    }
}
