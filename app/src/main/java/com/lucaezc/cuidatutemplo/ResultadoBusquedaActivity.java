package com.lucaezc.cuidatutemplo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ResultadoBusquedaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado_busqueda);
        ListView lvResultados = findViewById(R.id.lvResultados);
        TextView tvSinResultados = findViewById(R.id.tvSinResultados);

        DbHelper db = new DbHelper(this);
        Intent intent = getIntent();
        String stringBusqueda = intent.getStringExtra("stringBusqueda");
        int tipoBusqueda = intent.getIntExtra("tipoBusqueda", 0);
        Cursor c = null;

        switch (tipoBusqueda){
            case R.id.rbAlimentos:
                c = db.BusquedaAlimentos(stringBusqueda);
                AlimentosListAdapter adapter = new AlimentosListAdapter(this, c);
                lvResultados.setAdapter(adapter);
                lvResultados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Cursor c = (SQLiteCursor) parent.getItemAtPosition(position);
                        String[] aux = c.getColumnName(1).split("_");
                        String tipoAlimento = aux[0].toUpperCase();
                        int idAlimento = c.getInt(0);
                        String nombreAlimento = c.getString(1);
                        String infoAlimento = c.getString(2);
                        Integer imagenAlimento = c.getInt(3);

                        Intent intent = new Intent(getApplicationContext(), DetalleAlimentoActivity.class);
                        intent.putExtra("tipoAlimento", tipoAlimento);
                        intent.putExtra("idAlimento", idAlimento);
                        intent.putExtra("nombreAlimento", nombreAlimento);
                        intent.putExtra("infoAlimento", infoAlimento);
                        intent.putExtra("imagenAlimento", imagenAlimento);

                        startActivity(intent);
                    }
                });
                break;
            case R.id.rbEnfermedades:
                c = db.BusquedaEnfermedades(stringBusqueda);
                EnfermedadAlimentosListAdapter adapter1 = new EnfermedadAlimentosListAdapter(this, c);
                lvResultados.setAdapter(adapter1);
                break;
            case R.id.rbPropiedades:
                c = db.BusquedaPropiedades(stringBusqueda);
                PropiedadesAlimentosListAdapter adapter2 = new PropiedadesAlimentosListAdapter(this, c);
                lvResultados.setAdapter(adapter2);
                break;
            default:
                break;
        }
        assert c != null;
        if (c.getCount() == 0){
            tvSinResultados.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }
}
