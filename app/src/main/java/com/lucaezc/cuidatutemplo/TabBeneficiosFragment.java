package com.lucaezc.cuidatutemplo;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class TabBeneficiosFragment extends Fragment {
    Integer alimentoId;
    ListView lv;

    public TabBeneficiosFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_beneficios, container, false);
        alimentoId = getArguments().getInt("alimentoId");
        lv = v.findViewById(R.id.lvBenAlimento);
        return v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        DbHelper db = new DbHelper(getActivity());

        Cursor cBeneficiosAlimento = db.queryListBeneficiosAlimento(alimentoId);
        BeneficiosListAdapter beneficiosAlimentoAdapter = new BeneficiosListAdapter(getActivity(), cBeneficiosAlimento);
        lv.setAdapter(beneficiosAlimentoAdapter);
        lv.setDivider(null);
        lv.setDividerHeight(0);
    }
}
