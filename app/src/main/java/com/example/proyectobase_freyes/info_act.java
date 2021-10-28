package com.example.proyectobase_freyes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class info_act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }


    //Intents Implicitos...

    public void Marcar(View View){

        Intent i = new Intent(Intent.ACTION_DIAL); // accion para marcado telefonico
        i.setData(Uri.parse("tel:"+"900112233")); // colocamos el número a marcar
        startActivity(i);

    }

    //Intent Explicito

    public void Maps(View View){
        Intent i = new Intent(this, map_act.class);
        startActivity(i);
    }
}