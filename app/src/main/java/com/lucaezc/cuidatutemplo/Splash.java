package com.lucaezc.cuidatutemplo;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends Activity {
    private Timer timer;
    private ProgressBar barra;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.splash);
        ImageView imagen = findViewById(R.id.logoApp);
        imagen.setImageResource(R.drawable.logo);

        barra = (ProgressBar) findViewById(R.id.barraProgreso);
        barra.setProgress(0);
        final long intervalo = 15;
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
            if (i < 100){
                barra.setProgress(i);
                i++;
            }else{
                timer.cancel();
                Intent intent = new Intent(Splash.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
            }
        },0,intervalo);

    }

}
