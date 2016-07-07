package com.example.select.a3dgame;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.example.select.a3dgame.fragment.BBsFragment;
import com.example.select.a3dgame.fragment.GameFragment;
import com.example.select.a3dgame.fragment.TitleFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    private RadioGroup mGroup;
    private RadioButton rb_title;
    private RadioButton rb_bbs;
    private RadioButton rb_game;
    private TitleFragment mTitleFragment;
    private BBsFragment mBBsFragment;
    private GameFragment mGameFragment;
    private FragmentManager mFragmentManager;
    private FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mFragmentManager=getSupportFragmentManager();
        transaction=mFragmentManager.beginTransaction();
        transaction.add(R.id.fl_main,mTitleFragment).add(R.id.fl_main,mBBsFragment).add(R.id.fl_main,mGameFragment);
        transaction.attach(mTitleFragment).detach(mBBsFragment).detach(mGameFragment);
        transaction.commit();
        initListener();
        rb_title.isChecked();
        rb_title.setBackgroundColor(Color.parseColor("#6AC37A"));
    }

    private void initListener() {
        mGroup.setOnCheckedChangeListener(this);
    }

    private void initView() {
        mGroup = (RadioGroup) findViewById(R.id.rg_main_bottom);
        rb_title = (RadioButton) findViewById(R.id.rb_main_title);
        rb_bbs = (RadioButton) findViewById(R.id.rb_main_bbs);
        rb_game = (RadioButton) findViewById(R.id.rb_main_game);
        mTitleFragment=new TitleFragment();
        mBBsFragment=new BBsFragment();
        mGameFragment=new GameFragment();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        transaction=mFragmentManager.beginTransaction();
        switch (checkedId) {
            case R.id.rb_main_title:
                rb_title.setBackgroundColor(Color.parseColor("#6AC37A"));
                rb_game.setBackgroundColor(Color.BLACK);
                rb_bbs.setBackgroundColor(Color.BLACK);
                transaction.attach(mTitleFragment).detach(mGameFragment).detach(mBBsFragment);
                break;
            case R.id.rb_main_bbs:
                rb_title.setBackgroundColor(Color.BLACK);
                rb_game.setBackgroundColor(Color.BLACK);
                rb_bbs.setBackgroundColor(Color.parseColor("#6AC37A"));
                transaction.attach(mBBsFragment).detach(mTitleFragment).detach(mGameFragment);
                break;
            case R.id.rb_main_game:
                rb_title.setBackgroundColor(Color.BLACK);
                rb_game.setBackgroundColor(Color.parseColor("#6AC37A"));
                rb_bbs.setBackgroundColor(Color.BLACK);
                transaction.attach(mGameFragment).detach(mTitleFragment).detach(mBBsFragment);
                break;
        }
        transaction.commit();
    }

}
