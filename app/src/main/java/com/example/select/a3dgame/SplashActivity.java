package com.example.select.a3dgame;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.select.a3dgame.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private LinearLayout mLinearLayout;
    private List<ImageView> mList;
    private MyAdapter madapter;
    private int prePosition = 0;
    private int[] img = new int[]{R.drawable.eyu, R.drawable.who, R.drawable.sailiya};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
        setData();
        setListener();
    }

    private void setListener() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mLinearLayout.getChildAt(position).setBackgroundResource(R.drawable.dot_white);
                mLinearLayout.getChildAt(prePosition).setBackgroundResource(R.drawable.dot_dark);
                prePosition = position;
                if(position==2){
                    ImageView iv=mList.get(position);
                    iv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setData() {
        mList = new ArrayList<>();
        for (int i = 0; i < img.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setBackgroundResource(img[i]);
            mList.add(iv);
            View view = new View(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(30, 30);
            params.leftMargin = 5;
            view.setBackgroundResource(R.drawable.dot_dark);
            view.setLayoutParams(params);
            mLinearLayout.addView(view);
        }
        mLinearLayout.getChildAt(0).setBackgroundResource(R.drawable.dot_white);
        madapter = new MyAdapter(mList);
        mViewPager.setAdapter(madapter);
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.vp_splash);
        mLinearLayout = (LinearLayout) findViewById(R.id.ll_points);
    }
}
