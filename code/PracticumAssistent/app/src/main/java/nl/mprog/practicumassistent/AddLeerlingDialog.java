package nl.mprog.practicumassistent;

import android.support.v4.app.DialogFragment;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class AddLeerlingDialog extends DialogFragment implements View.OnClickListener {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_add_leerling, null);

        Button annuleren = (Button) view.findViewById(R.id.annuleren);
        annuleren.setOnClickListener(this);
        Button bevestigen = (Button) view.findViewById(R.id.bevestigen);
        bevestigen.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.annuleren){
            dismiss();
        }
        else if(v.getId()==R.id.bevestigen){
            Toast.makeText(getActivity(), "OK!", Toast.LENGTH_SHORT).show();
        }
    }
}
