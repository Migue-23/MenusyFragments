package com.example.miscontactos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
//import android.widget.Toolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);



        listaContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializaAdaptador();

    }



        public ContactoAdaptador adaptador;
        private void inicializaAdaptador(){
            adaptador = new ContactoAdaptador(contactos, this);
            listaContactos.setAdapter(adaptador);
        }


    public void inicializarListaContactos(){

        contactos = new  ArrayList<Contacto>();


        contactos.add(new Contacto(R.drawable.dog_01,"Lola", "1", "Labrador retriever, es una de las razas más populares del mundo."));
        contactos.add(new Contacto(R.drawable.dog_02,"Paco", "2","Pastor belga, es el nombre de cuatro razas o variedades de perros originarias de Bélgica."));
        contactos.add(new Contacto(R.drawable.dog_03,"Lucky", "3","Husky siberiano, ideal para cuidar la heladera o pasear en trineo."));
        contactos.add(new Contacto(R.drawable.dog_04,"Pity", "4", "Yorky mini, sabe varios idiomas, entre ellos el pekines."));
        contactos.add(new Contacto(R.drawable.dog_05,"Peludo", "5", "Bulldog frances, su raza fue criada por primera vez en Inglaterra"));
        contactos.add(new Contacto(R.drawable.dog_06,"Laika", "6", " Border Terrier es una raza de perro originaria del Reino Unido ."));
        contactos.add(new Contacto(R.drawable.dog_07,"Rocky", "7", "Beagle, es una raza de tamaño pequeño a mediano de aspecto similar al foxhound."));
        contactos.add(new Contacto(R.drawable.dog_08,"Lenard", "8", "Boxer, es una raza canina alemana de trabajo, tamaño grande."));
        contactos.add(new Contacto(R.drawable.dog_09,"Edu", "9", "El gran danés o dogo alemán es una raza canina conocida por su gran tamaño."));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.mAbout:
                Intent intent = new Intent(this, ActivityAbout.class);
                startActivity(intent);
                break;

            case R.id.mSettings:
                Intent i = new Intent(this, ActivitySettings.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}