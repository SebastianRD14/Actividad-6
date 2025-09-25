package com.srd14.actividad6;

import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Scene escenaInicial;
    private Scene escenaFinal;
    private boolean showingInitial = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewGroup sceneRoot = findViewById(R.id.root_escenas);
        escenaInicial = Scene.getSceneForLayout(sceneRoot, R.layout.escena_1, this);
        escenaFinal   = Scene.getSceneForLayout(sceneRoot, R.layout.escena_2, this);
        escenaInicial.enter();

        Button btn = findViewById(R.id.Boton);
        btn.setOnClickListener(v -> toggleScene(sceneRoot));
    }
    private void toggleScene(ViewGroup sceneRoot) {
        Transition explode = new Explode();
        Transition slide   = new Slide(Gravity.BOTTOM);
        Transition fade    = new Fade();

        TransitionSet set = new TransitionSet()
                .addTransition(explode)
                .addTransition(fade)
                .setDuration(300);

        if (showingInitial) {
            TransitionManager.go(escenaFinal, set);
        } else {
            TransitionManager.go(escenaInicial, set);
        }
        showingInitial = !showingInitial;
    }
}