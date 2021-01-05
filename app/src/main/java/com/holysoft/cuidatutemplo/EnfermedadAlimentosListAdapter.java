package com.holysoft.cuidatutemplo;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class EnfermedadAlimentosListAdapter extends CursorAdapter {
    public EnfermedadAlimentosListAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_enfermedad_alimentos, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvEnfermedadId = view.findViewById(R.id.tvEnfermedadId);
        TextView tvEnfermedadNombre = view.findViewById(R.id.tvEnfermedadNombre);
        TextView tvListadoAlimentos = view.findViewById(R.id.tvAlimentosSirvenPara);

        int enfermedadId = cursor.getInt(0);
        String enfermedadNombre = cursor.getString(1);

        tvEnfermedadNombre.setText(enfermedadNombre);
        tvEnfermedadId.setText(String.valueOf(enfermedadId));

        DbHelper db = new DbHelper(context);
        Cursor cAlimentos = db.queryListAlimentosEnfermedad(enfermedadId);
        String listadoAlimentos = "";
        while (cAlimentos.moveToNext()) {
            listadoAlimentos = listadoAlimentos + "\u2022 " + cAlimentos.getString(1) + System.getProperty("line.separator");
        }
        cAlimentos.close();
        tvListadoAlimentos.setText(listadoAlimentos);
    }
}
