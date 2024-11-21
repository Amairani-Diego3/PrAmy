package com.example.pramy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class PartesCuerpo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partes_cuerpo);
    }
    public void regresarBodyParts (View view ){
        this.finish();
    }
}