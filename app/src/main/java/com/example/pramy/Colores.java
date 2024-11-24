package com.example.pramy;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class Colores extends AppCompatActivity {
    MediaPlayer mp;
    VideoView videoView;
    Button btnPlayPause, btnClose;
    ImageButton btnVideoColores;
    LinearLayout controlsLayout;
    ScrollView scrollLayout;  // Añadir ScrollView para el scroll de los botones
    boolean isPlaying = false;
    ImageButton[] colorButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colores);

        // Asignar los botones de colores al array
        colorButtons = new ImageButton[] {
                findViewById(R.id.bgreen),
                findViewById(R.id.bred),
                findViewById(R.id.bblue),
                findViewById(R.id.byellow),
                findViewById(R.id.borange),
                findViewById(R.id.bpink),
                findViewById(R.id.bbrown),
                findViewById(R.id.bblack),
                findViewById(R.id.bpurple),
                findViewById(R.id.bgray)
        };

        // Asignar el mismo listener a todos los botones
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Reproducir el sonido según el botón presionado
                if (mp != null) {
                    mp.release(); // Liberar el recurso anterior para evitar errores
                }
                switch (view.getId()) {
                    case R.id.bgreen:
                        mp = MediaPlayer.create(Colores.this, R.raw.agreen);
                        break;
                    case R.id.bred:
                        mp = MediaPlayer.create(Colores.this, R.raw.ared);
                        break;
                    case R.id.bblue:
                        mp = MediaPlayer.create(Colores.this, R.raw.ablue);
                        break;
                    case R.id.byellow:
                        mp = MediaPlayer.create(Colores.this, R.raw.ayellow);
                        break;
                    case R.id.borange:
                        mp = MediaPlayer.create(Colores.this, R.raw.aorange);
                        break;
                    case R.id.bpink:
                        mp = MediaPlayer.create(Colores.this, R.raw.apink);
                        break;
                    case R.id.bgray:
                        mp = MediaPlayer.create(Colores.this, R.raw.agray);
                        break;
                    case R.id.bpurple:
                        mp = MediaPlayer.create(Colores.this, R.raw.apurple);
                        break;
                    case R.id.bbrown:
                        mp = MediaPlayer.create(Colores.this, R.raw.abrown);
                        break;
                    case R.id.bblack:
                        mp = MediaPlayer.create(Colores.this, R.raw.ablack);
                        break;
                }
                if (mp != null) {
                    mp.start(); // Reproducir el sonido
                }
            }
        };

        // Asignar el listener a cada botón
        for (ImageButton button : colorButtons) {
            button.setOnClickListener(listener);
        }

        // Referencias a los elementos del layout
        videoView = findViewById(R.id.videoView);
        btnPlayPause = findViewById(R.id.btnPlayPause);
        btnClose = findViewById(R.id.btnClose);
        btnVideoColores = findViewById(R.id.videoColores);
        controlsLayout = findViewById(R.id.controlsLayout);
        scrollLayout = findViewById(R.id.scrollLayout);  // Inicializar el ScrollView (cambiar si tienes otro nombre)

        // Configurar el controlador del video (similar a YouTube)


        // Definir la ruta del video
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.vcolors;  // Cambia `tu_video` por el nombre de tu archivo
        videoView.setVideoPath(videoPath);

        // Abrir video al hacer clic en el botón
        btnVideoColores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Mostrar el VideoView y los controles
                videoView.setVisibility(View.VISIBLE);
                controlsLayout.setVisibility(View.VISIBLE);
                // Reproducir el video
                videoView.start();
                // Cambiar el texto del botón a "Pausar"
                btnPlayPause.setText("Pause");
                isPlaying = true;
                // Congelar los botones de colores y el scroll
                setColorButtonsEnabled(false);
                setScrollEnabled(false);
            }
        });

        // Control de Play/Pause
        btnPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPlaying) {
                    // Pausar el video
                    videoView.pause();
                    btnPlayPause.setText("Continue");
                } else {
                    // Reproducir el video
                    videoView.start();
                    btnPlayPause.setText("Pause");
                }
                isPlaying = !isPlaying; // Alternar entre play y pause
            }
        });

        // Cerrar el video
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Detener la reproducción y ocultar el VideoView y los controles
                videoView.stopPlayback();
                videoView.setVisibility(View.GONE);
                controlsLayout.setVisibility(View.GONE);
                btnPlayPause.setText("Continue");
                isPlaying = false;
                // Restaurar los botones de colores y el scroll
                setColorButtonsEnabled(true);
                setScrollEnabled(true);
            }
        });
    }

    // Método para habilitar o deshabilitar los botones de colores
    private void setColorButtonsEnabled(boolean enabled) {
        for (ImageButton button : colorButtons) {
            button.setEnabled(enabled);
        }
    }

    // Método para habilitar o deshabilitar el ScrollView
    private void setScrollEnabled(boolean enabled) {
        scrollLayout.setEnabled(enabled);
        scrollLayout.requestDisallowInterceptTouchEvent(!enabled);  // Prevenir que el scroll se active
    }

    public void regresarColors(View view) {
        this.finish();
    }
}
