package com.lucaezc.cuidatutemplo;

import android.content.Intent;
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
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleAlimentoActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_alimento);

        Intent intent = getIntent();
        String nombreAlimento = intent.getStringExtra("nombreAlimento");
        final int idAlimento = intent.getIntExtra("idAlimento", 0);
        //String tipoAlimento = intent.getStringExtra("tipoAlimento");
        final String infoAlimento = intent.getStringExtra("infoAlimento");

        int imagenResourceId = intent.getIntExtra("imagenAlimento",0);
        ImageView imagen = findViewById(R.id.imagenAlimento);
        imagen.setImageResource(imagenResourceId);

        TextView tvNombreAlimento = findViewById(R.id.nombreAlimento);
        tvNombreAlimento.setText(nombreAlimento);

        TabLayout tbAlimento = findViewById(R.id.tbAlimento);

        // TAB POR DEFAULT
        Fragment fragment = null;
        Bundle bundle = new Bundle();
        bundle.putString("infoAlimento", infoAlimento);
        fragment = new TabInfoFragment();
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frameTab, fragment).commit();

        tbAlimento.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                Bundle bundle = new Bundle();

                switch (tab.getPosition()){
                    case 0:
                        bundle.putString("infoAlimento", infoAlimento);
                        fragment = new TabInfoFragment();
                        fragment.setArguments(bundle);
                        break;
                    case 1:
                        bundle.putInt("alimentoId", idAlimento);
                        fragment = new TabPropiedadesFragment();
                        fragment.setArguments(bundle);
                        break;
                    case 2:
                        bundle.putInt("alimentoId", idAlimento);
                        fragment = new TabBeneficiosFragment();
                        fragment.setArguments(bundle);
                        break;
                    case 3:
                        bundle.putInt("alimentoId", idAlimento);
                        fragment = new TabEnfermedadesFragment();
                        fragment.setArguments(bundle);
                        break;
                    default:
                        break;
                }

                if (fragment != null) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.frameTab, fragment).commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) { // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;
        switch (id){
            case R.id.alimentos:
                fragment = new AlimentosFragment();
                break;
            case R.id.busqueda_avanzada:
                fragment = new BusquedaFragment();
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
