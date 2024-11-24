package com.example.pramy;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.widget.*;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.VideoView;

public class Animales extends AppCompatActivity {

    private VideoView videoView;
    private Button btnPlay, btnPause, btnStop;

    MediaPlayer mp; // Objeto MediaPlayer para reproducir los sonidos
    ImageButton[] animalButtons; // Array de botones de animales
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animales);
        RadioGroup radioGroup1 = findViewById(R.id.radioGroup1);
        RadioGroup radioGroup2 = findViewById(R.id.radioGroup2);
        RadioGroup radioGroup3 = findViewById(R.id.radioGroup3);
        RadioGroup radioGroup4 = findViewById(R.id.radioGroup4);
        Button btnSubmit = findViewById(R.id.btnSubmit);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[] correctAnswers = {
                        R.id.option1_2, // Fish
                        R.id.option2_3, // Bear
                        R.id.option3_2, // Toucan
                        R.id.option4_1  // Spider
                };

                int[] selectedAnswers = {
                        radioGroup1.getCheckedRadioButtonId(),
                        radioGroup2.getCheckedRadioButtonId(),
                        radioGroup3.getCheckedRadioButtonId(),
                        radioGroup4.getCheckedRadioButtonId()
                };

                int score = 0;
                StringBuilder feedback = new StringBuilder();

                for (int i = 0; i < selectedAnswers.length; i++) {
                    if (selectedAnswers[i] == correctAnswers[i]) {
                        score++;
                        feedback.append("Question ").append(i + 1).append(": Correct!\n");
                    } else {
                        feedback.append("Question ").append(i + 1).append(": Wrong!\n");
                    }
                }

                Toast.makeText(Animales.this, feedback.toString(), Toast.LENGTH_LONG).show();
            }
        });




        // Inicializar vistas
        videoView = findViewById(R.id.videoView);
        btnPlay = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);
        btnStop = findViewById(R.id.btnStop);

        // Configurar el video
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.vanimals); // Reemplaza "nombre_del_video" con el nombre real
        videoView.setVideoURI(videoUri);

        // Acción para el botón Play
        btnPlay.setOnClickListener(v -> {
            videoView.start(); // Inicia o reanuda el video
        });

        // Acción para el botón Pause
        btnPause.setOnClickListener(v -> {
            if (videoView.isPlaying()) {
                videoView.pause(); // Pausa el video si está reproduciéndose
            }
        });

        // Acción para el botón Terminar
        btnStop.setOnClickListener(v -> {
            videoView.stopPlayback(); // Detiene la reproducción
            videoView.setVideoURI(videoUri); // Reinicia el VideoView
            videoView.seekTo(0); // Posiciona el video al inicio
        });



        // Inicializar los botones de animales
        animalButtons = new ImageButton[]{
                findViewById(R.id.aarana),
                findViewById(R.id.aavestruz),
                findViewById(R.id.aaguila),
                findViewById(R.id.acerdo),
                findViewById(R.id.acebra),
                findViewById(R.id.acocodrilo),
                findViewById(R.id.aconejo),
                findViewById(R.id.aculebra),
                findViewById(R.id.aaperro),
                findViewById(R.id.agato),
                findViewById(R.id.ahipopotamo),
                findViewById(R.id.ajirafa),
                findViewById(R.id.aleon),
                findViewById(R.id.amono),
                findViewById(R.id.aoso),
                findViewById(R.id.apajaro),
                findViewById(R.id.ahormiga),
                findViewById(R.id.apescado),
                findViewById(R.id.apinguino),
                findViewById(R.id.aurana),
                findViewById(R.id.araton),
                findViewById(R.id.atiburon),
                findViewById(R.id.atortuga),
                findViewById(R.id.atucan)
        };

        // Listener para manejar los clics en los botones
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Liberar el recurso del MediaPlayer si ya está en uso
                if (mp != null) {
                    mp.release();
                    mp = null;
                }

                // Asignar el sonido correspondiente al botón presionado
                switch (view.getId()) {
                    case R.id.aarana:
                        mp = MediaPlayer.create(Animales.this, R.raw.aspider);
                        break;
                    case R.id.aavestruz:
                        mp = MediaPlayer.create(Animales.this, R.raw.aostrich);
                        break;
                    case R.id.aaguila:
                        mp = MediaPlayer.create(Animales.this, R.raw.aeagle);
                        break;
                    case R.id.acerdo:
                        mp = MediaPlayer.create(Animales.this, R.raw.apig);
                        break;
                    case R.id.acebra:
                        mp = MediaPlayer.create(Animales.this, R.raw.azebra);
                        break;
                    case R.id.acocodrilo:
                        mp = MediaPlayer.create(Animales.this, R.raw.acocodrile);
                        break;
                    case R.id.aconejo:
                        mp = MediaPlayer.create(Animales.this, R.raw.arabbit);
                        break;
                    case R.id.aculebra:
                        mp = MediaPlayer.create(Animales.this, R.raw.asnake);
                        break;
                    case R.id.aaperro:
                        mp = MediaPlayer.create(Animales.this, R.raw.adog);
                        break;
                    case R.id.agato:
                        mp = MediaPlayer.create(Animales.this, R.raw.acat);
                        break;
                    case R.id.ahipopotamo:
                        mp = MediaPlayer.create(Animales.this, R.raw.ahippo);
                        break;
                    case R.id.ajirafa:
                        mp = MediaPlayer.create(Animales.this, R.raw.agiraffe);
                        break;
                    case R.id.aleon:
                        mp = MediaPlayer.create(Animales.this, R.raw.alion);
                        break;
                    case R.id.amono:
                        mp = MediaPlayer.create(Animales.this, R.raw.achango);
                        break;
                    case R.id.aoso:
                        mp = MediaPlayer.create(Animales.this, R.raw.abear);
                        break;
                    case R.id.apajaro:
                        mp = MediaPlayer.create(Animales.this, R.raw.abird);
                        break;
                    case R.id.ahormiga:
                        mp = MediaPlayer.create(Animales.this, R.raw.aant);
                        break;
                    case R.id.apescado:
                        mp = MediaPlayer.create(Animales.this, R.raw.afish);
                        break;
                    case R.id.apinguino:
                        mp = MediaPlayer.create(Animales.this, R.raw.apenguin);
                        break;
                    case R.id.aurana:
                        mp = MediaPlayer.create(Animales.this, R.raw.afrog);
                        break;
                    case R.id.araton:
                        mp = MediaPlayer.create(Animales.this, R.raw.amouse);
                        break;
                    case R.id.atiburon:
                        mp = MediaPlayer.create(Animales.this, R.raw.ashark);
                        break;
                    case R.id.atortuga:
                        mp = MediaPlayer.create(Animales.this, R.raw.atortoise);
                        break;
                    case R.id.atucan:
                        mp = MediaPlayer.create(Animales.this, R.raw.atoucan);
                        break;
                }

                // Reproducir el sonido si el MediaPlayer no es nulo
                if (mp != null) {
                    mp.start();
                }
            }
        };

        // Asignar el listener a todos los botones
        for (ImageButton button : animalButtons) {
            button.setOnClickListener(listener);
        }
    }

    @Override
    protected void onDestroy() {
        // Liberar el MediaPlayer al cerrar la actividad para evitar fugas de memoria
        if (mp != null) {
            mp.release();
            mp = null;
        }
        super.onDestroy();





    }
    public void regresarAnimals (View view ){
        this.finish();
    }
}