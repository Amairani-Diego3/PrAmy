package com.example.pramy;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RadioGroup;
import android.widget.Toast;
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

                Toast.makeText(Numeros.this, feedback.toString(), Toast.LENGTH_LONG).show();
            }
        });



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
        configureImageView(R.id.p1, "btn1");
        configureImageView(R.id.p2, "btn2");
        configureImageView(R.id.p3, "btn3");
        configureImageView(R.id.p4, "btn4");


        videoView = findViewById(R.id.videoView);
        btnPlayPause = findViewById(R.id.btnPlayPause);
        btnClose = findViewById(R.id.btnClose);
        controlsLayout = findViewById(R.id.controlsLayout);


        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);


        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.numbers; // Cambia `vnumbers` por el nombre de tu archivo de video
        videoView.setVideoPath(videoPath);


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
            }
        });


        videoView.setVisibility(View.VISIBLE);
        controlsLayout.setVisibility(View.VISIBLE);
        videoView.start();
        isPlaying = true;
        btnPlayPause.setText("Pause");
    }

    private void configureImageView(int imageViewId, String numberName) {
        ImageView imageView = findViewById(imageViewId);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int audioResource = getAudioResource(numberName);

                if (audioResource != -1) {

                    MediaPlayer mediaPlayer = MediaPlayer.create(Numeros.this, audioResource);
                    mediaPlayer.start();


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
            case "btn1":
                return R.raw.preg1nu;
            case "btn2":
                return R.raw.preg2nu;
            case "btn3":
                return R.raw.preg3nu;
            case "btn4":
                return R.raw.preg4nu;
            default:
                return -1;
        }
    }
    public void regresarNumbers(View view) {
        this.finish();
    }
}
