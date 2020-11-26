package com.lucaezc.cuidatutemplo;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Objects;

public class ContactoFragment extends Fragment {
    Button botonEnviar;
    EditText comentarios;
    Spinner asuntos;

    public ContactoFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.contacto, container, false);
        comentarios = rootview.findViewById(R.id.mltComentarios);
        botonEnviar = rootview.findViewById(R.id.btEnviar);
        asuntos = rootview.findViewById(R.id.spAsunto);
        return rootview;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        botonEnviar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (comentarios.getText().toString().matches("")){
                    Toast.makeText(getContext(), R.string.validacionContacto, Toast.LENGTH_SHORT).show();
                }else{
                    String asunto = getResources().getString(R.string.app_name) + " - " + asuntos.getSelectedItem().toString();
                    String cuerpoMail = comentarios.getText().toString();
                    String[] addresses = new String[]{"corbo.luca@gmail.com"};

                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:"));
                    intent.putExtra(Intent.EXTRA_EMAIL, addresses);
                    intent.putExtra(Intent.EXTRA_SUBJECT, asunto);
                    intent.putExtra(Intent.EXTRA_TEXT, cuerpoMail);
                    if (intent.resolveActivity(Objects.requireNonNull(getActivity()).getPackageManager()) != null) {
                        startActivity(intent);
                        getActivity().onBackPressed();
                        Toast.makeText(getContext(), R.string.contacto_5, Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
