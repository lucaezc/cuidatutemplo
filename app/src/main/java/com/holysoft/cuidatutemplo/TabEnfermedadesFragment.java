package com.holysoft.cuidatutemplo;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class TabEnfermedadesFragment extends Fragment {
    Integer alimentoId;
    ListView lv;

    public TabEnfermedadesFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_enfermedades, container, false);
        alimentoId = getArguments().getInt("alimentoId");
        lv = v.findViewById(R.id.lvEnfAlimento);
        return v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        DbHelper db = new DbHelper(getActivity());

        Cursor cEnfermedadesAlimento = db.queryListEnfermedadesAlimento(alimentoId);
        EnfermedadesListAdapter enfermedadesAlimentoAdapter = new EnfermedadesListAdapter(getActivity(), cEnfermedadesAlimento);
        lv.setAdapter(enfermedadesAlimentoAdapter);
        lv.setDivider(null);
        lv.setDividerHeight(0);
    }
}
