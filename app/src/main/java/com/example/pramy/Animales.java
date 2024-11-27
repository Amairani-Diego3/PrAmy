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

    MediaPlayer mp;
    ImageButton[] animalButtons;
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
                        R.id.option1_2,
                        R.id.option2_3,
                        R.id.option3_2,
                        R.id.option4_1
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




        videoView = findViewById(R.id.videoView);
        btnPlay = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);
        btnStop = findViewById(R.id.btnStop);


        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.vanimals); // Reemplaza "nombre_del_video" con el nombre real
        videoView.setVideoURI(videoUri);


        btnPlay.setOnClickListener(v -> {
            videoView.start();
        });

        btnPause.setOnClickListener(v -> {
            if (videoView.isPlaying()) {
                videoView.pause();
            }
        });


        btnStop.setOnClickListener(v -> {
            videoView.stopPlayback();
            videoView.setVideoURI(videoUri);
            videoView.seekTo(0);
        });




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


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mp != null) {
                    mp.release();
                    mp = null;
                }


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


                if (mp != null) {
                    mp.start();
                }
            }
        };


        for (ImageButton button : animalButtons) {
            button.setOnClickListener(listener);
        }
    }

    @Override
    protected void onDestroy() {

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