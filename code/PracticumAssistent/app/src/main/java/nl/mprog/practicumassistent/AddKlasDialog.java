package nl.mprog.practicumassistent;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddKlasDialog  extends DialogFragment {

    DBAdapter dbAdapter;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        View layout = inflater.inflate(R.layout.dialog_add_klas, null);
        builder.setView(layout);
        final EditText editText = (EditText)layout.findViewById(R.id.editText);
        builder.setTitle("Nieuwe klas")
                // Stel de 'bevestigen' knop in
                .setPositiveButton("Toevoegen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        // Lees het veld in en controleer of er wel iets in ingevoerd
                        String klas = editText.getText().toString();
                        if (klas.equals("")){
                            Toast.makeText(getActivity(), "Voer een klas in!", Toast.LENGTH_SHORT).show();
                        }

                        // Voeg de nieuwe klas toe aan de database
                        else {
                            // Voeg de klas toe aan de database
                            dbAdapter = new DBAdapter(getActivity());
                            dbAdapter.open();
                            dbAdapter.addKlas(klas);
                            dbAdapter.close();

                            // Geef aan KlassenActivity door dat de dialog klaar is
                            if (getActivity() instanceof DialogInterface.OnDismissListener) {
                                ((DialogInterface.OnDismissListener) getActivity()).onDismiss(dialog);
                            }
                        }
                    }
                })

                // Stel de 'annuleren' knop in (doet niks)
                .setNegativeButton("Annuleren", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });

        return builder.create();
    }
}
