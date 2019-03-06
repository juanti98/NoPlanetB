package com.example.noplanetb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

public class BSplash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        TextView myTitle = (TextView)findViewById(R.id.textView3);
        TextView mySubtitle = (TextView)findViewById(R.id.textView4);
        ImageView myImage = (ImageView)findViewById(R.id.imageView);

        ImageView mPlanet = (ImageView) findViewById(R.id.backforest);


        Glide.with(this)
                .load(R.drawable.planetearth)
                .apply(new RequestOptions()
                                .centerCrop()
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                )
                .into(mPlanet);

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.drop_item);

        myImage.startAnimation(myanim);
        openApp(true);
    }

    private void openApp(boolean locationPermission) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(BSplash
                        .this, BLogin.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
