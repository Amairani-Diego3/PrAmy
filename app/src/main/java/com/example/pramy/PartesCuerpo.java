package com.example.pramy;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.MediaController;

public class PartesCuerpo extends AppCompatActivity {

    MediaPlayer mp;
    VideoView videoView;
    Button btnPlayPause, btnClose;
    LinearLayout controlsLayout;
    boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partes_cuerpo);
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

                Toast.makeText(PartesCuerpo.this, feedback.toString(), Toast.LENGTH_LONG).show();
            }
        });

        // Configurar ImageViews para las partes del cuerpo
        configureImageView(R.id.imageView27, "head");
        configureImageView(R.id.imageView28, "face");
        configureImageView(R.id.imageView29, "eye");
        configureImageView(R.id.imageView30, "nose");
        configureImageView(R.id.imageView31, "ear");
        configureImageView(R.id.imageView32, "neck");
        configureImageView(R.id.imageView33, "mouth");
        configureImageView(R.id.imageView34, "teeth");

        // Configurar VideoView y controles
        videoView = findViewById(R.id.videoView);
        btnPlayPause = findViewById(R.id.btnPlayPause);
        btnClose = findViewById(R.id.btnClose);
        controlsLayout = findViewById(R.id.controlsLayout);

        // Configurar el controlador del video
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        // Ruta del video
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.parts_of_body_video; // Asegúrate de tener el video adecuado
        videoView.setVideoPath(videoPath);

        // Configurar botón Play/Pause
        btnPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPlaying) {
                    videoView.pause();
                    btnPlayPause.setText("Continue");
                } else {
                    videoView.start();
                    btnPlayPause.setText("Pause");
                }
                isPlaying = !isPlaying;
            }
        });

        // Configurar botón Cerrar
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoView.stopPlayback();
                videoView.setVisibility(View.GONE);
                controlsLayout.setVisibility(View.GONE);
                btnPlayPause.setText("Continue");
                isPlaying = false;
            }
        });

        // Mostrar video al cargar la actividad (opcional)
        videoView.setVisibility(View.VISIBLE);
        controlsLayout.setVisibility(View.VISIBLE);
        videoView.start();
        isPlaying = true;
        btnPlayPause.setText("Pause");
    }

    private void configureImageView(int imageViewId, String partName) {
        ImageView imageView = findViewById(imageViewId);

        // Configurar el clic en la imagen
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int audioResource = getAudioResource(partName);

                if (audioResource != -1) {
                    // Reproducir el sonido asociado a la parte del cuerpo
                    MediaPlayer mediaPlayer = MediaPlayer.create(PartesCuerpo.this, audioResource);
                    mediaPlayer.start();

                    // Liberar el reproductor después de que el audio finalice
                    mediaPlayer.setOnCompletionListener(MediaPlayer::release);
                }
            }
        });
    }

    private int getAudioResource(String partName) {
        switch (partName) {
            case "head":
                return R.raw.ahead;  // Asegúrate de tener estos archivos en res/raw
            case "face":
                return R.raw.aface;
            case "eye":
                return R.raw.aeye;
            case "nose":
                return R.raw.anose;
            case "ear":
                return R.raw.aear;
            case "neck":
                return R.raw.aneck;
            case "mouth":
                return R.raw.amouth;
            case "teeth":
                return R.raw.teeth;
            default:
                return -1;  // Retorna -1 si no se encuentra la parte
        }
    }
    public void regresarBodyParts(View view) {
        this.finish();
    }
}
