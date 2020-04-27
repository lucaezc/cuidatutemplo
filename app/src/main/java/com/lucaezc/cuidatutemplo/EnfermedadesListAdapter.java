package com.lucaezc.cuidatutemplo;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class EnfermedadesListAdapter extends CursorAdapter {
    public EnfermedadesListAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_enfermedades, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvEnfermedadId = view.findViewById(R.id.tvEnfermedadId);
        TextView tvEnfermedadNombre = view.findViewById(R.id.tvEnfermedadNombre);

        int enfermedadId = cursor.getInt(0);
        String enfermedadNombre = cursor.getString(1);

        tvEnfermedadNombre.setText(enfermedadNombre);
        tvEnfermedadId.setText(String.valueOf(enfermedadId));
    }
}
