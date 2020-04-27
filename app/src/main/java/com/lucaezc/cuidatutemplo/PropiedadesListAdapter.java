package com.lucaezc.cuidatutemplo;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class PropiedadesListAdapter extends CursorAdapter {
    public PropiedadesListAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_propiedades, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvPropiedadNombre = view.findViewById(R.id.tvPropiedadNombre);
        TextView tvPropiedadDesc = view.findViewById(R.id.tvPropiedadDesc);

        String propiedadNombre = cursor.getString(1);
        String propiedadDesc = cursor.getString(2);

        tvPropiedadNombre.setText(propiedadNombre);
        tvPropiedadDesc.setText(propiedadDesc);
    }
}
