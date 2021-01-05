package com.holysoft.cuidatutemplo;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class PropiedadesAlimentosListAdapter extends CursorAdapter {
    public PropiedadesAlimentosListAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_propiedad_alimentos, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvPropiedadId = view.findViewById(R.id.tvPropiedadId);
        TextView tvPropiedadNombre = view.findViewById(R.id.tvPropiedadNombre);
        TextView tvListadoAlimentos = view.findViewById(R.id.tvAlimentosConPropiedad);

        int propiedadId = cursor.getInt(0);
        String propiedadNombre = cursor.getString(1);

        tvPropiedadNombre.setText(propiedadNombre);
        tvPropiedadId.setText(String.valueOf(propiedadId));

        DbHelper db = new DbHelper(context);
        Cursor cAlimentos = db.queryListAlimentosPropiedad(propiedadId);
        String listadoAlimentos = "";
        while (cAlimentos.moveToNext()) {
            listadoAlimentos = listadoAlimentos + "\u2022 " + cAlimentos.getString(1) + System.getProperty("line.separator");
        }
        cAlimentos.close();
        tvListadoAlimentos.setText(listadoAlimentos);
    }
}
