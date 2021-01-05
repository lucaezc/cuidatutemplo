package com.holysoft.cuidatutemplo;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class PropiedadesFragment extends Fragment {

    ListView lv;

    public PropiedadesFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.lista_elementos, container, false);
        lv = rootView.findViewById(R.id.listViewElementos);
        return rootView;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        DbHelper db = new DbHelper(getActivity());

        Cursor cursorPropiedades = db.queryListPropiedades();
        PropiedadesListAdapter propiedadAdapter = new PropiedadesListAdapter(getActivity(), cursorPropiedades);
        lv.setAdapter(propiedadAdapter);
    }
}
