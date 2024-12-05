package com.example.pramy;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.media.MediaPlayer;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Formas extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private Button btnPlay, btnPause, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formas);
        Button btnSubmit = findViewById(R.id.btnSubmit);
        RadioGroup radioGroup1 = findViewById(R.id.radioGroup1);
        RadioGroup radioGroup2 = findViewById(R.id.radioGroup2);
        RadioGroup radioGroup3 = findViewById(R.id.radioGroup3);
        RadioGroup radioGroup4 = findViewById(R.id.radioGroup4);

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

                Toast.makeText(Formas.this, feedback.toString(), Toast.LENGTH_LONG).show();
            }
        });



        btnPlay = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);
        btnStop = findViewById(R.id.btnStop);


        mediaPlayer = MediaPlayer.create(this, R.raw.aforms);


        btnPlay.setOnClickListener(v -> {
            if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
                mediaPlayer.start();
            }
        });

        btnPause.setOnClickListener(v -> {
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            }
        });


        btnStop.setOnClickListener(v -> {
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.reset();
                mediaPlayer.release();
                mediaPlayer = null;
            }
        });


        setupShapeButtons();
    }

    private void setupShapeButtons() {
        ImageButton buttonSquare = findViewById(R.id.buttonSquare);
        ImageButton buttonCircle = findViewById(R.id.buttonCircle);
        ImageButton buttonRectangle = findViewById(R.id.buttonRectangle);
        ImageButton buttonTriangle = findViewById(R.id.buttonTriangle);
        ImageButton buttonTrapezoid = findViewById(R.id.buttonTrapezoid);
        ImageButton buttonOval = findViewById(R.id.buttonOval);
        ImageButton buttonHeptagon = findViewById(R.id.buttonHeptagon);
        ImageButton buttonHexagon = findViewById(R.id.buttonHexagon);
        ImageButton buttonPentagon = findViewById(R.id.buttonPentagon);
        ImageButton buttonDiamond = findViewById(R.id.buttonDiamond);
        ImageButton p1 = findViewById(R.id.p1);
        ImageButton p2 = findViewById(R.id.p2);
        ImageButton p3 = findViewById(R.id.p3);
        ImageButton p4 = findViewById(R.id.p4);

        buttonSquare.setOnClickListener(v -> playShape("square"));
        buttonCircle.setOnClickListener(v -> playShape("circle"));
        buttonRectangle.setOnClickListener(v -> playShape("rectangle"));
        buttonTriangle.setOnClickListener(v -> playShape("triangle"));
        buttonTrapezoid.setOnClickListener(v -> playShape("trapezoid"));
        buttonOval.setOnClickListener(v -> playShape("oval"));
        buttonHeptagon.setOnClickListener(v -> playShape("heptagon"));
        buttonHexagon.setOnClickListener(v -> playShape("hexagon"));
        buttonPentagon.setOnClickListener(v -> playShape("pentagon"));
        buttonDiamond.setOnClickListener(v -> playShape("diamond"));
        p1.setOnClickListener(v -> playShape("p1"));
        p2.setOnClickListener(v -> playShape("p2"));
        p3.setOnClickListener(v -> playShape("p3"));
        p4.setOnClickListener(v -> playShape("p4"));

    }

    private void playShape(String shapeName) {

        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.reset();
            mediaPlayer.release();
        }


        int audioResId = getAudioResource(shapeName);
        if (audioResId != -1) {
            mediaPlayer = MediaPlayer.create(this, audioResId);
            mediaPlayer.setOnCompletionListener(mp -> {
                mp.release();
                mediaPlayer = null;
            });
            mediaPlayer.start();
        } else {
            Toast.makeText(this, "Audio no encontrado", Toast.LENGTH_SHORT).show();
        }



    }

    private int getAudioResource(String shapeName) {
        switch (shapeName) {
            case "square":
                return R.raw.square;
            case "circle":
                return R.raw.circle;
            case "rectangle":
                return R.raw.rectangle;
            case "triangle":
                return R.raw.triangle;
            case "diamond":
                return R.raw.diamond;
            case "pentagon":
                return R.raw.pentagon;
            case "hexagon":
                return R.raw.hexagon;
            case "heptagon":
                return R.raw.heptagon;
            case "trapezoid":
                return R.raw.trapezoid;
            case "oval":
                return R.raw.oval;
            case "p1":
                return R.raw.preg1fo;
            case "p2":
                return R.raw.preg2fo;
            case "p3":
                return R.raw.preg3fo;
            case "p4":
                return R.raw.preg4fo;
            default:
                return -1;
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    public void regresarForms(View view) {
        this.finish();
    }
}
