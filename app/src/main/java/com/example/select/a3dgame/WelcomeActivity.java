package com.example.select.a3dgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import com.ant.liao.GifView;

public class WelcomeActivity extends AppCompatActivity {

    private SharedPreferences mSharedPreferences;
    private GifView mGifView;
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome);
        initView();
        initListener();
    }

    private void initListener() {
        Animation animation=new AlphaAnimation(0,1.0f);
        animation.setDuration(3000);
        mGifView.setAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
            boolean isFirst=mSharedPreferences.getBoolean("isFirst",true);
                if(isFirst){
                    Intent intent=new Intent(WelcomeActivity.this,SplashActivity.class);
                    startActivity(intent);
                    finish();
                    SharedPreferences.Editor editor= mSharedPreferences.edit();
                    editor.putBoolean("isFirst",false);
                    editor.commit();
                }else {
                    Intent intent=new Intent(WelcomeActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    private void initView() {
        mGifView= (GifView) findViewById(R.id.gv_welcome);
        mSharedPreferences=getSharedPreferences("config",MODE_PRIVATE);
    }
}
