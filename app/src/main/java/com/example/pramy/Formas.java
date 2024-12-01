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
import android.widget.TextView;
import android.widget.Toast;

public class Formas extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private Button btnPlay, btnPause, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formas);


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


        showCustomToast(shapeName);
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
            default:
                return -1;
        }
    }

    private void showCustomToast(String shapeName) {
        LayoutInflater inflater = getLayoutInflater();
        View toastView = inflater.inflate(R.layout.activity_custom_toast, null);

        TextView toastMessage = toastView.findViewById(R.id.toastMessage);
        toastMessage.setText(shapeName);

        ImageView toastIcon = toastView.findViewById(R.id.toastIcon);
        int iconResId = getIconResource(shapeName);
        toastIcon.setImageResource(iconResId);

        Toast customToast = new Toast(getApplicationContext());
        customToast.setView(toastView);
        customToast.setDuration(Toast.LENGTH_LONG);
        customToast.setGravity(Gravity.CENTER, 0, 0);
        customToast.show();
    }

    private int getIconResource(String shapeName) {
        switch (shapeName) {
            case "square":
                return R.drawable.icuadrado;
            case "circle":
                return R.drawable.icirculo;
            case "rectangle":
                return R.drawable.irectangulo;
            case "triangle":
                return R.drawable.itriangulo;
            case "diamond":
                return R.drawable.irombo;
            case "pentagon":
                return R.drawable.ipentagono;
            case "hexagon":
                return R.drawable.ihexagono;
            case "heptagon":
                return R.drawable.iheptagono;
            case "trapezoid":
                return R.drawable.itrapecio;
            case "oval":
                return R.drawable.iovalo;
            default:
                return R.drawable.ibluee;
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
