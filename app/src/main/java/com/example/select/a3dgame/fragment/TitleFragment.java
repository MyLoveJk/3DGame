package com.example.select.a3dgame.fragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.select.a3dgame.R;

public class TitleFragment extends Fragment {

    @Nullable
    public View onCreateView(LayoutInflater inflater) {
        return inflater.inflate(R.layout.activity_title_fragment,null);
    }
}
