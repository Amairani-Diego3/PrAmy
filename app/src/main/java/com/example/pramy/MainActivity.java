package com.example.pramy;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void iniciarColors(View view){
        Intent vtr= new Intent (MainActivity.this, Colores.class);
        startActivity(vtr);
    }
    public void iniciarAlphabet(View view){
        Intent vtr= new Intent (MainActivity.this, Abecedario.class);
        startActivity(vtr);
    }
    public void iniciarAnimals(View view){
        Intent vtr= new Intent (MainActivity.this, Animales.class);
        startActivity(vtr);
    }
    public void iniciarForms(View view){
        Intent vtr= new Intent (MainActivity.this, Formas.class);
        startActivity(vtr);
    }
    public void IniciarNumbers(View view){
        Intent vtr= new Intent (MainActivity.this, Numeros.class);
        startActivity(vtr);
    }
    public void IniciarBodyParts(View view){
        Intent vtr= new Intent (MainActivity.this, PartesCuerpo.class);
        startActivity(vtr);
    }
}