package com.example.android.boostcamp_facebook_practice;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by samsung on 2017-07-04.
 */

public class Main_frag_second extends android.support.v4.app.Fragment{

    public Main_frag_second(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.main_frag_second, container, false);
        return layout;
    }


}
