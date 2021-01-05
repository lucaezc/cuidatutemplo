package com.holysoft.cuidatutemplo;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
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
        View layout = view.findViewById(R.id.layoutAlimentos);
        ImageView imagen = view.findViewById(R.id.ivAlimento);

        int alimentoId = cursor.getInt(0);
        String alimentoNombre = cursor.getString(1);
        int tipoAlimento = cursor.getInt(4);
        int imagenId = cursor.getInt(3);
        imagen.setImageResource(imagenId);
        switch (tipoAlimento){
            case 1: //Hierba
                layout.setBackgroundColor(context.getResources().getColor(R.color.hierbas));
                break;
            case 2: // Planta
                layout.setBackgroundColor(context.getResources().getColor(R.color.plantas));
                break;
            case 3: // Verdura
                layout.setBackgroundColor(context.getResources().getColor(R.color.verduras));
                break;
            case 4: // Fruta
                layout.setBackgroundColor(context.getResources().getColor(R.color.frutas));
                break;
            case 5: // Legumbre
                layout.setBackgroundColor(context.getResources().getColor(R.color.legumbre));
                break;
            case 6: // Semilla
                layout.setBackgroundColor(context.getResources().getColor(R.color.semilla));
                break;
            case 7: // Fruto seco
                layout.setBackgroundColor(context.getResources().getColor(R.color.fruto_seco));
                break;
            default:
                break;
        }

        tvAlimentoNombre.setText(alimentoNombre);
        tvAlimentoId.setText(String.valueOf(alimentoId));
    }
}
