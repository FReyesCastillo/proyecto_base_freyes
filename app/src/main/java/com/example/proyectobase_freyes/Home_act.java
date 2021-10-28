package com.example.proyectobase_freyes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import Objetos.Insumos;

public class Home_act extends AppCompatActivity {

    private Insumos in = new Insumos();
    private VideoView video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        video = findViewById(R.id.vw);  // llamo al video

        //Obtener ruta del video

        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;

        Uri uri = Uri.parse(ruta); // parseo de ruta

        video.setVideoURI(uri);  // le paso mi ruta al videView

        video.start(); // iniciar video al iniciar sesión

        // Controles para el video

        //MediaController media = new MediaController(this);
        //video.setMediaController(media);


    }

    public void Task(View View){

        try { for (int i = 0; i<=10;i++){

            Thread.sleep(2000);
            Toast.makeText(this,"Este es un gran proceso", Toast.LENGTH_SHORT).show();
        }

        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }

    public void Insumos(View View){
        //preparo los extras
        Intent i = new Intent(this, Insumos_act.class);
        Bundle bun = new Bundle(); // necesario para enviar arreglos
        bun.putStringArray("insumos", in.getInsumos());
        i.putExtras(bun);
        startActivity(i);
    }
}