package com.example.proyectobase_freyes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import Objetos.Administrador;
import Objetos.Insumos;

public class MainActivity extends AppCompatActivity {

    private EditText user, pass;
    private TextView msj;
    private Administrador adm = new Administrador(); // Instancia de obj administrador
    private ProgressBar pb;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.txtUser);
        pass = findViewById(R.id.txtPass);
        msj = findViewById(R.id.txtMen);
        pb = findViewById(R.id.proBar);
        btn = findViewById(R.id.btnInicio);



        msj.setVisibility(View.INVISIBLE); // maneja la visibilidad de un elemento
        pb.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Aquí corre la tarea

                new Task().execute();
            }
        });


    }

    //tarea asincrona

    class Task extends AsyncTask<String,Void,String>{

        @Override // configuracion inicial de la tarea
        protected void onPreExecute() {
            super.onPreExecute();
            pb.setVisibility(View.VISIBLE);
        }

        @Override // encagado de procesar en segundo plano la tarea pesada
        protected String doInBackground(String... strings) {


            try {
                for(int i = 0; i<= 10; i++){
                    Thread.sleep(500);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override // finaliza la tarea asincrona
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            pb.setVisibility(View.INVISIBLE);


            String usuario = user.getText().toString().trim();
            String contrasena = pass.getText().toString().trim();

            String userObj = adm.getUser().trim();
            String passObj = adm.getPass().trim();

            switch(usuario)
            {
                case "Francisco":
                    if(usuario.equals(userObj) && contrasena.equals(passObj)){
                        //Inicio de sesion

                        Intent i = new Intent(getBaseContext(), Home_act.class);
                        startActivity(i);

                    }
                    break;

                case "":
                    if(usuario.equals("") && contrasena.equals(""))
                    {
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("Campos vacios");
                    }
                    break;

                default:
                    if(!usuario.equals(userObj) && !contrasena.equals(passObj))
                    {
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("Usuario o contraseña incorrectos"); //campos incorrectos
                    }
                    break;

            }

        }
    }

    public void Facebook(View View){

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.facebook.com"));
        startActivity(i);
    }

    public void Youtube(View View){

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.youtube.com"));
        startActivity(i);
    }

    public void Twitter(View View){

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.twitter.com"));
        startActivity(i);
    }

    public void Info(View View){
        Intent i = new Intent(this, info_act.class);
        startActivity(i);
    }








}