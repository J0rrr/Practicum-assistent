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

    // Use this instance of the interface to deliver action events
    AddLeerlingDialog.DialogListener mListener;
    DBHandler dbHandler;

    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (AddLeerlingDialog.DialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        dbHandler = new DBHandler(getActivity());


        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        View layout = inflater.inflate(R.layout.dialog_add_klas, null);
        builder.setView(layout);
        final EditText editText = (EditText)layout.findViewById(R.id.klas);
        builder.setTitle("Nieuwe klas")
                // Stel de 'bevestigen' knop in
                .setPositiveButton("Bevestigen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        // Lees het veld in en controleer of er wel iets in ingevoerd
                        String klas = editText.getText().toString();
                        if (klas.equals("")){
                            Toast.makeText(getActivity(), "Voer een klas in!", Toast.LENGTH_SHORT).show();
                        }

                        // Voeg de nieuwe klas toe aan de database
                        else {
                            dbHandler.addKlas(klas);
                            Toast.makeText(getActivity(), klas, Toast.LENGTH_SHORT).show();
                        }
                    }
                })

                // Stel de 'annuleren' knop in
                .setNegativeButton("Annuleren", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getActivity(), "TESTN!", Toast.LENGTH_SHORT).show();
                    }
                });
        return builder.create();
    }
}
