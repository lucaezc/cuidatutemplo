package com.lucaezc.cuidatutemplo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

public class AlimentosFragment extends Fragment {
    ListView lv;
    SearchView sv;
    Cursor cursorSearch;

    public AlimentosFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.lista_elementos, container, false);
        lv = rootView.findViewById(R.id.listViewElementos);
        sv = rootView.findViewById(R.id.searchBar);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final DbHelper db = new DbHelper(getActivity());

        final Cursor cursorAlimentos = db.queryListAlimentos();
        final AlimentosListAdapter alimentosAdapter = new AlimentosListAdapter(getActivity(), cursorAlimentos);
        lv.setAdapter(alimentosAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor c = (SQLiteCursor) parent.getItemAtPosition(position);
                String[] aux = c.getColumnName(1).split("_");
                String tipoAlimento = aux[0].toUpperCase();
                int idAlimento = c.getInt(0);
                String nombreAlimento = c.getString(1);
                String infoAlimento = c.getString(2);
                Integer imagenAlimento = c.getInt(3);

                Intent intent = new Intent(getContext(), DetalleAlimentoActivity.class);
                intent.putExtra("tipoAlimento", tipoAlimento);
                intent.putExtra("idAlimento", idAlimento);
                intent.putExtra("nombreAlimento", nombreAlimento);
                intent.putExtra("infoAlimento", infoAlimento);
                intent.putExtra("imagenAlimento", imagenAlimento);

                startActivity(intent);
            }
        });

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                cursorSearch = db.queryListAlimentosFiltro(s);
                alimentosAdapter.changeCursor(cursorSearch);
                return false;
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        sv.clearFocus();
        sv.setQuery(null,false);
    }
}
