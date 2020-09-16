package com.lucaezc.cuidatutemplo;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class BeneficiosListAdapter extends CursorAdapter {
    public BeneficiosListAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_beneficios, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvBeneficioId = view.findViewById(R.id.tvBeneficioId);
        TextView tvBeneficioNombre = view.findViewById(R.id.tvBeneficioNombre);

        int beneficioId = cursor.getInt(0);
        String beneficioNombre = cursor.getString(1);

        tvBeneficioNombre.setText(beneficioNombre);
        tvBeneficioId.setText(String.valueOf(beneficioId));
        tvBeneficioId.setVisibility(View.INVISIBLE);
    }
}
