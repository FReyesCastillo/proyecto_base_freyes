package com.example.proyectobase_freyes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import Objetos.Insumos;

public class Insumos_act extends AppCompatActivity {

    private Spinner insumos;
    private TextView result;
    private RatingBar calificar;
    private Insumos in = new Insumos(); // Instancia de la clase

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos);

        insumos = findViewById(R.id.spInsumos);
        result = findViewById(R.id.txtRes);
        calificar = findViewById(R.id.ratingBar);

        //Recibo extras

        Bundle bun = getIntent().getExtras();
        String[] listado = bun.getStringArray("insumos");

        ArrayAdapter adaptInsumos = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
        insumos.setAdapter(adaptInsumos);
    }

    public void Calcular (View View){

        String opcion = insumos.getSelectedItem().toString(); // obtengo la selección del spinner en una variable.
        int resultado = 0;

        for(int i = 0; i< opcion.length(); i++){

            if(opcion.equals(in.getInsumos()[i])){ // pregunto por la seleccion del spinner (index)

                //resultado = in.getPrecios()[i]; // obtengo resultado del precio según índice

                resultado = in.anadirAdicional(in.getPrecios()[i], 350); // obtengo regla adicional
                calificar.setRating(i+1); // pinta las estrellas del rating bar
                break;
            }
        }

        result.setText("La opción seleccionada es " + opcion +"\ny su precio es " + resultado);


    }

}