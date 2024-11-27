package com.example.pramy;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.net.Uri;

import androidx.appcompat.app.AppCompatActivity;

public class Abecedario extends AppCompatActivity {

    private VideoView videoView;
    private LinearLayout controlsLayout;
    private Button btnPlayPause;
    private Button btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abecedario);

        // Inicializar VideoView y controles
        videoView = findViewById(R.id.videoView);
        controlsLayout = findViewById(R.id.controlsLayout);
        btnPlayPause = findViewById(R.id.btnPlayPause);
        btnClose = findViewById(R.id.btnClose);

        // Botón para mostrar el VideoView
        ImageView videoButton = findViewById(R.id.videoAlfabeto);
        videoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showVideo();
            }
        });

        // Configurar ImageViews para cada letra
        configureImageView(R.id.imageViewA, "a");
        configureImageView(R.id.imageViewB, "b");
        configureImageView(R.id.imageViewC, "c");
        configureImageView(R.id.imageViewD, "d");
        configureImageView(R.id.imageViewE, "e");
        configureImageView(R.id.imageViewF, "f");
        configureImageView(R.id.imageViewG, "g");
        configureImageView(R.id.imageViewH, "h");
        configureImageView(R.id.imageViewI, "i");
        configureImageView(R.id.imageViewJ, "j");
        configureImageView(R.id.imageViewK, "k");
        configureImageView(R.id.imageViewL, "l");
        configureImageView(R.id.imageViewM, "m");
        configureImageView(R.id.imageViewN, "n");
        configureImageView(R.id.imageViewO, "o");
        configureImageView(R.id.imageViewP, "p");
        configureImageView(R.id.imageViewQ, "q");
        configureImageView(R.id.imageViewR, "r");
        configureImageView(R.id.imageViewS, "s");
        configureImageView(R.id.imageViewT, "t");
        configureImageView(R.id.imageViewU, "u");
        configureImageView(R.id.imageViewV, "v");
        configureImageView(R.id.imageViewW, "w");
        configureImageView(R.id.imageViewX, "x");
        configureImageView(R.id.imageViewY, "y");
        configureImageView(R.id.imageViewZ, "z");
    }

    private void configureImageView(int imageViewId, String letter) {
        ImageView imageView = findViewById(imageViewId);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int audioResource = getAudioResource(letter);

                if (audioResource != -1) {
                    // Reproducir el sonido asociado a la letra
                    MediaPlayer mediaPlayer = MediaPlayer.create(Abecedario.this, audioResource);
                    mediaPlayer.start();

                    // Liberar el reproductor después de que el audio finalice
                    mediaPlayer.setOnCompletionListener(MediaPlayer::release);
                }
            }
        });
    }

    private int getAudioResource(String letter) {
        switch (letter) {
            case "a":
                return R.raw.a;  // Asegúrate de tener los archivos de audio correspondientes en res/raw
            case "b":
                return R.raw.b;
            case "c":
                return R.raw.c;
            case "d":
                return R.raw.d;
            case "e":
                return R.raw.e;
            case "f":
                return R.raw.f;
            case "g":
                return R.raw.g;
            case "h":
                return R.raw.h;
            case "i":
                return R.raw.i;
            case "j":
                return R.raw.j;
            case "k":
                return R.raw.k;
            case "l":
                return R.raw.l;
            case "m":
                return R.raw.m;
            case "n":
                return R.raw.n;
            case "o":
                return R.raw.o;
            case "p":
                return R.raw.p;
            case "q":
                return R.raw.q;
            case "r":
                return R.raw.r;
            case "s":
                return R.raw.s;
            case "t":
                return R.raw.t;
            case "u":
                return R.raw.u;
            case "v":
                return R.raw.v;
            case "w":
                return R.raw.w;
            case "x":
                return R.raw.x;
            case "y":
                return R.raw.y;
            case "z":
                return R.raw.z;
            default:
                return -1;  // Retorna -1 si no se encuentra la letra
        }
    }

    private void showVideo() {
        // Mostrar VideoView y controles
        videoView.setVisibility(View.VISIBLE);
        controlsLayout.setVisibility(View.VISIBLE);

        // Reproducir el video correspondiente
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_a));
        videoView.start();

        // Configurar los controles de reproducción
        btnPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (videoView.isPlaying()) {
                    videoView.pause();
                    btnPlayPause.setText("Play");
                } else {
                    videoView.start();
                    btnPlayPause.setText("Pause");
                }
            }
        });

        // Configurar el botón de cerrar
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.stopPlayback();
                videoView.setVisibility(View.GONE);
                controlsLayout.setVisibility(View.GONE);
            }
        });
    }

    // Método para cerrar la actividad cuando el botón "regresar" es presionado
    public void regresarAlphabet(View view) {
        this.finish();
    }
}
