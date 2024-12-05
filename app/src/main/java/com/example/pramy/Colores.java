package com.example.pramy;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class Colores extends AppCompatActivity {
    MediaPlayer mp;
    VideoView videoView;
    Button btnPlayPause, btnClose;
    ImageButton btnVideoColores;
    LinearLayout controlsLayout;
    ScrollView scrollLayout;
    boolean isPlaying = false;
    ImageButton[] colorButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colores);
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

                Toast.makeText(Colores.this, feedback.toString(), Toast.LENGTH_LONG).show();
            }
        });


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
                findViewById(R.id.bgray),
                findViewById(R.id.p1),
                findViewById(R.id.p2),
                findViewById(R.id.p3),
                findViewById(R.id.p4),
        };


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mp != null) {
                    mp.release();
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
                    case R.id.p1:
                        mp = MediaPlayer.create(Colores.this, R.raw.preg1co);
                        break;
                    case R.id.p2:
                        mp = MediaPlayer.create(Colores.this, R.raw.preg2co);
                        break;
                    case R.id.p3:
                        mp = MediaPlayer.create(Colores.this, R.raw.preg3co);
                        break;
                    case R.id.p4:
                        mp = MediaPlayer.create(Colores.this, R.raw.preg4co);
                        break;
                }
                if (mp != null) {
                    mp.start();
                }
            }
        };


        for (ImageButton button : colorButtons) {
            button.setOnClickListener(listener);
        }


        videoView = findViewById(R.id.videoView);
        btnPlayPause = findViewById(R.id.btnPlayPause);
        btnClose = findViewById(R.id.btnClose);
        btnVideoColores = findViewById(R.id.videoColores);
        controlsLayout = findViewById(R.id.controlsLayout);
        scrollLayout = findViewById(R.id.scrollLayout);





        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.vcolors;  // Cambia `tu_video` por el nombre de tu archivo
        videoView.setVideoPath(videoPath);


        btnVideoColores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoView.setVisibility(View.VISIBLE);
                controlsLayout.setVisibility(View.VISIBLE);
                videoView.start();
                btnPlayPause.setText("Pause");
                isPlaying = true;
                setColorButtonsEnabled(false);
                setScrollEnabled(false);
            }
        });

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


        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                videoView.stopPlayback();
                videoView.setVisibility(View.GONE);
                controlsLayout.setVisibility(View.GONE);
                btnPlayPause.setText("Continue");
                isPlaying = false;

                setColorButtonsEnabled(true);
                setScrollEnabled(true);
            }
        });
    }


    private void setColorButtonsEnabled(boolean enabled) {
        for (ImageButton button : colorButtons) {
            button.setEnabled(enabled);
        }
    }


    private void setScrollEnabled(boolean enabled) {
        scrollLayout.setEnabled(enabled);
        scrollLayout.requestDisallowInterceptTouchEvent(!enabled);
    }

    public void regresarColors(View view) {
        this.finish();
    }
}
