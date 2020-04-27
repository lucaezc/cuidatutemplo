package com.lucaezc.cuidatutemplo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TabInfoFragment extends Fragment {
    public TabInfoFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String infoAlimento = getArguments().getString("infoAlimento");

        View v = inflater.inflate(R.layout.tab_info, container, false);
        TextView tvInfoAlimento = v.findViewById(R.id.tvInfoAlimento);
        tvInfoAlimento.setText(infoAlimento);
        return v;
    }

}
