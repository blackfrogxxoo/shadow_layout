package me.wxc.shadowlayoutdemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.SeekBar;

import me.wxc.shadowlayout.ShadowLayout;

public class MainActivity extends AppCompatActivity {


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        float density = getResources().getDisplayMetrics().density;

        ShadowLayout shadowLayout = findViewById(R.id.shadowLayout);

        SeekBar radius = findViewById(R.id.radius);
        radius.setOnSeekBarChangeListener(new SeekBarChangeListenerAdapter() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                shadowLayout.setBlurRadius(progress);
            }
        });
        radius.setMin(1);
        radius.setMax(200);
        radius.setProgress((int) (density * 15));

        SeekBar padding = findViewById(R.id.padding);
        padding.setOnSeekBarChangeListener(new SeekBarChangeListenerAdapter() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                shadowLayout.setPadding(progress, progress, progress, progress);
            }
        });
        padding.setMin(1);
        padding.setMax(200);
        padding.setProgress((int) (density * 6));

        SeekBar aFloat = findViewById(R.id.floating);
        aFloat.setOnSeekBarChangeListener(new SeekBarChangeListenerAdapter() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                shadowLayout.setFloat(progress / 20f);
            }
        });
        aFloat.setMin(1);
        aFloat.setMax(100);
        aFloat.setProgress(15);

        SeekBar x = findViewById(R.id.x);
        x.setOnSeekBarChangeListener(new SeekBarChangeListenerAdapter() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                shadowLayout.setTranslateX(progress / 10f);
            }
        });
        x.setMin(-100);
        x.setMax(100);
        x.setProgress((int) (density * 10));

        SeekBar y = findViewById(R.id.y);
        y.setOnSeekBarChangeListener(new SeekBarChangeListenerAdapter() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                shadowLayout.setTranslateY(progress / 10f);
            }
        });
        y.setMin(-100);
        y.setMax(100);
        y.setProgress((int) (density * 10));

        SeekBar alpha = findViewById(R.id.alpha);
        alpha.setOnSeekBarChangeListener(new SeekBarChangeListenerAdapter() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                shadowLayout.setShadowAlpha(progress * 0.01f);
            }
        });
        alpha.setMin(1);
        alpha.setMax(100);
        alpha.setProgress(30);

        SeekBar corner = findViewById(R.id.corner);
        corner.setOnSeekBarChangeListener(new SeekBarChangeListenerAdapter() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                shadowLayout.setRectRadius(progress);
            }
        });
        corner.setMin(1);
        corner.setMax(100);
        corner.setProgress((int) (density * 6));
    }




    static class SeekBarChangeListenerAdapter implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            // stub
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // stub
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // stub
        }
    }
}