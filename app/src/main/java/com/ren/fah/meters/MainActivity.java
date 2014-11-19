package com.ren.fah.meters;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.SeekBar;


public class MainActivity extends Activity {

    SeekBar seekBar;
    RotateImageView rotateImageView;
    RotateImageView rotateImageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        rotateImageView = (RotateImageView)findViewById(R.id.imageView);
        rotateImageView2 = (RotateImageView)findViewById(R.id.imageView2);
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inSampleSize=4;
        Bitmap bitmap_hari = BitmapFactory.decodeResource(getResources(),R.drawable.hari,opt);
        Bitmap bitmap_grid = BitmapFactory.decodeResource(getResources(),R.drawable.memori,opt);
        rotateImageView.setImageBitmap(bitmap_hari);
        rotateImageView2.setImageBitmap(bitmap_grid);

        seekBar.setMax(360);
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
        RotateRIV(iv,deg,500);
    }

    private void RotateRIV(RotateImageView iv, int deg, int duration){
        int centerX = (int)iv.getWidth()/2;
        int centerY = (int)iv.getHeight()/2;
        RotateAnimation rotateAnimation = new RotateAnimation(iv.getNowDegree(),deg + iv.getOffsetDegree(),centerX,centerY);
        rotateAnimation.setFillEnabled(true);
        rotateAnimation.setFillAfter(true);
        Log.v("Rot", "Rot from:" + iv.getNowDegree() + "to:" + deg);
        iv.setNowDegree(deg);
        rotateAnimation.setDuration(duration);
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
