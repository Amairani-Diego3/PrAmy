package com.example.pramy;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

public class Numeros extends AppCompatActivity {
    MediaPlayer mp;
    VideoView videoView;
    Button btnPlayPause, btnClose;
    LinearLayout controlsLayout;
    boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numeros);

        // Configurar ImageViews para los números
        configureImageView(R.id.imageView6, "one");
        configureImageView(R.id.imageView7, "two");
        configureImageView(R.id.three, "three");
        configureImageView(R.id.imageView9, "four");
        configureImageView(R.id.imageView11, "five");
        configureImageView(R.id.imageView10, "six");
        configureImageView(R.id.imageView12, "seven");
        configureImageView(R.id.imageView13, "eight");
        configureImageView(R.id.imageView14, "nine");
        configureImageView(R.id.imageView15, "ten");

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
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.numbers; // Cambia `vnumbers` por el nombre de tu archivo de video
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

    private void configureImageView(int imageViewId, String numberName) {
        ImageView imageView = findViewById(imageViewId);

        // Configurar el clic en el ImageView
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int audioResource = getAudioResource(numberName);

                if (audioResource != -1) {
                    // Reproducir el sonido asociado al número
                    MediaPlayer mediaPlayer = MediaPlayer.create(Numeros.this, audioResource);
                    mediaPlayer.start();

                    // Liberar el reproductor después de que el audio finalice
                    mediaPlayer.setOnCompletionListener(MediaPlayer::release);
                }
            }
        });
    }

    private int getAudioResource(String numberName) {
        switch (numberName) {
            case "one":
                return R.raw.one;
            case "two":
                return R.raw.two;
            case "three":
                return R.raw.three;
            case "four":
                return R.raw.four;
            case "five":
                return R.raw.five;
            case "six":
                return R.raw.six;
            case "seven":
                return R.raw.seven;
            case "eight":
                return R.raw.eight;
            case "nine":
                return R.raw.nine;
            case "ten":
                return R.raw.ten;
            default:
                return -1;
        }
    }
}
