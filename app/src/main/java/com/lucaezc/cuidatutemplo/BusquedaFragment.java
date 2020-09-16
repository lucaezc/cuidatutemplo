package com.lucaezc.cuidatutemplo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class BusquedaFragment extends Fragment {
    Button botonBuscar;
    EditText campoBusqueda;
    RadioGroup rGroup;

    public BusquedaFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.busqueda, container, false);
        campoBusqueda = rootview.findViewById(R.id.stringBusqueda);
        botonBuscar = rootview.findViewById(R.id.buscar);
        rGroup = rootview.findViewById(R.id.radioGroup);
        return rootview;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        botonBuscar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String stringBusqueda = null;
                if (campoBusqueda.getText().toString().matches("")){
                    Toast.makeText(getContext(), R.string.validacionBusqueda, Toast.LENGTH_SHORT).show();
                }else{
                    stringBusqueda = campoBusqueda.getText().toString();
                    Integer tipoBusqueda = 0;
                    switch (rGroup.getCheckedRadioButtonId()){
                        case R.id.rbAlimentos:
                            tipoBusqueda = R.id.rbAlimentos;
                            break;
                        case R.id.rbEnfermedades:
                            tipoBusqueda = R.id.rbEnfermedades;
                            break;
                        case R.id.rbPropiedades:
                            tipoBusqueda = R.id.rbPropiedades;
                            break;
                        default:
                            Toast.makeText(getContext(), R.string.validacionBusqueda_1, Toast.LENGTH_SHORT).show();
                            break;
                    }

                    if (!tipoBusqueda.equals(0)){
                        Intent intent = new Intent(getContext(), ResultadoBusquedaActivity.class);
                        intent.putExtra("tipoBusqueda", tipoBusqueda);
                        intent.putExtra("stringBusqueda", stringBusqueda);
                        startActivity(intent);
                    }
                }
            }
        });
    }

}
