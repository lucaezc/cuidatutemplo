package com.lucaezc.cuidatutemplo;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class AlimentosListAdapter extends CursorAdapter {
    public AlimentosListAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_alimentos, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvAlimentoId = view.findViewById(R.id.tvAlimentoId);
        TextView tvAlimentoNombre = view.findViewById(R.id.tvAlimentoNombre);

        int alimentoId = cursor.getInt(0);
        String alimentoNombre = cursor.getString(1);

        tvAlimentoNombre.setText(alimentoNombre);
        tvAlimentoId.setText(String.valueOf(alimentoId));
    }
}
