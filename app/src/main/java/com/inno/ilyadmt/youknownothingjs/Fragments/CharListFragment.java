package com.inno.ilyadmt.youknownothingjs.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inno.ilyadmt.youknownothingjs.R;

/**
 * Created by mjazz on 21.07.2017.
 */

public class CharListFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_charlist, container, false);
    }
}
