package br.com.fleme.pacoteviagens.ui.activity;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

import br.com.fleme.pacoteviagens.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        apresentarSplashScreen();

    }

    private void apresentarSplashScreen() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarLogin();
            }
        }, 4000);
    }

    private void mostrarLogin() {
        Intent intent = new Intent(this, ListaPacotesActivity.class);
        startActivity(intent);
        finish();
    }
}
