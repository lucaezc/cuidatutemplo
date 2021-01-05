package com.holysoft.cuidatutemplo;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class TabPropiedadesFragment extends Fragment {
    Integer alimentoId;
    ListView lv;

    public TabPropiedadesFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_propiedades, container, false);
        alimentoId = getArguments().getInt("alimentoId");
        lv = v.findViewById(R.id.lvPropAlimento);
        return v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        DbHelper db = new DbHelper(getActivity());

        Cursor cPropiedadesAlimento = db.queryListPropiedadesAlimento(alimentoId);
        PropiedadesListAdapter propsAlimentoAdapter = new PropiedadesListAdapter(getActivity(), cPropiedadesAlimento);
        lv.setAdapter(propsAlimentoAdapter);
    }
}
