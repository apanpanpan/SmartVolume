package com.example.soundsmart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initControlsForAdjust();
        initControlsForSample();
    }

    private void initControlsForAdjust(){
        SeekBar timeAdjust = findViewById(R.id.adjustBar);
        TextView minText = findViewById(R.id.timeAdjust);
        minText.setText("Amount of time to adjust volume: " + timeAdjust.getProgress() + "s");


        timeAdjust.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                TextView minText = findViewById(R.id.timeAdjust);
                minText.setText("Amount of time to adjust volume: "+progress+"s");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void initControlsForSample(){
        try{
            SeekBar timeSample = findViewById(R.id.sampleBar);

            TextView maxText = findViewById(R.id.timeSample);
            maxText.setText("Amount of time to sample audio: " + timeSample.getProgress() + "s");

            timeSample.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    TextView maxText = findViewById(R.id.timeSample);
                    maxText.setText("Amount of time to sample audio: "+progress+"s");
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });

        }catch(Exception e ){
            e.printStackTrace();
        }

    }

    public void goBack(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
