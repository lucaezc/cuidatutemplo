package com.holysoft.cuidatutemplo;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class BeneficiosFragment extends Fragment {
    ListView lv;

    public BeneficiosFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.lista_elementos, container, false);
        lv = rootView.findViewById(R.id.listViewElementos);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        DbHelper db = new DbHelper(getActivity());

        Cursor cursorBeneficios = db.queryListBeneficios();
        BeneficiosListAdapter beneficioAdapter = new BeneficiosListAdapter(getActivity(), cursorBeneficios);
        lv.setAdapter(beneficioAdapter);
    }
}
