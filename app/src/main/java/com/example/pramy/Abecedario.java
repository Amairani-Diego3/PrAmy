package com.example.pramy;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;
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

                Toast.makeText(Abecedario.this, feedback.toString(), Toast.LENGTH_LONG).show();
            }
        });


        videoView = findViewById(R.id.videoView);
        controlsLayout = findViewById(R.id.controlsLayout);
        btnPlayPause = findViewById(R.id.btnPlayPause);
        btnClose = findViewById(R.id.btnClose);


        ImageView videoButton = findViewById(R.id.videoAlfabeto);
        videoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showVideo();
            }
        });

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

                    MediaPlayer mediaPlayer = MediaPlayer.create(Abecedario.this, audioResource);
                    mediaPlayer.start();


                    mediaPlayer.setOnCompletionListener(MediaPlayer::release);
                }
            }
        });
    }


    private int getAudioResource(String letter) {
        switch (letter) {
            case "a":
                return R.raw.a;
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
                return -1;
        }
    }

    private void showVideo() {

        videoView.setVisibility(View.VISIBLE);
        controlsLayout.setVisibility(View.VISIBLE);


        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_a));
        videoView.start();

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


        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.stopPlayback();
                videoView.setVisibility(View.GONE);
                controlsLayout.setVisibility(View.GONE);
            }
        });
    }


    public void regresarBodyParts(View view) {
        this.finish();
    }

}
