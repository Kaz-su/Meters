package com.ren.fah.meters;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.RotateAnimation;
import android.widget.SeekBar;


public class MainActivity extends Activity {

    SeekBar seekBar;
    RotateImageView rotateImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        rotateImageView = (RotateImageView)findViewById(R.id.imageView);

        seekBar.setMax(180);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                RotateRIV(rotateImageView, progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void RotateRIV(RotateImageView iv, int deg){
        int centerX = (int)iv.getWidth()/2;
        int centerY = (int)iv.getHeight()/2;
        RotateAnimation rotateAnimation = new RotateAnimation(iv.getNowDegree(),deg,centerX,centerY);
        rotateAnimation.setFillEnabled(true);
        rotateAnimation.setFillAfter(true);
        Log.v("Rot","Rot from:" + iv.getNowDegree() + "to:" + deg);
        iv.setNowDegree(deg);
        rotateAnimation.setDuration(100);
        iv.startAnimation(rotateAnimation);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
