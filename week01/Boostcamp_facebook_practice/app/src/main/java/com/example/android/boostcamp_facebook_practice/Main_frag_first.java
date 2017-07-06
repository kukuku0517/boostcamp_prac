package com.example.android.boostcamp_facebook_practice;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * Created by samsung on 2017-07-04.
 */

public class Main_frag_first extends android.support.v4.app.Fragment implements View.OnClickListener{

    public Main_frag_first(){

    }

    private RecyclerView firstRecyclerView;
    private MyAdapter firstAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ImageView img1,img2,img3;
    private View update;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.main_frag_first, container, false);

        //recyclerview dummy data
        FacebookItem f1 = new FacebookItem("서강대 대숲1","1시간","안녕하세요\n글내용입니다\n반갑습니다\n더미더미더미더미","4",13,22,0);
        FacebookItem f2 = new FacebookItem("서강대 대숲2","11시간","안녕하세요\n글내용입니다\n반갑습니다\n더미더미더미더미","42",11233,22,0);
        FacebookItem f3 = new FacebookItem("서강대 대숲3","11시간","안녕하세요\n글내용입니다\n반갑습니다\n더미더미더미더미","4",13,2432,0);
        FacebookItem f4 = new FacebookItem("서강대 대숲4","12시간","안녕하세요\n글내용입니다\n반갑습니다\n더미더미더미더미","41",131,212,0);
        FacebookItem f5 = new FacebookItem("서강대 대숲5","13시간","안녕하세요\n글내용입니다\n반갑습니다\n더미더미더미더미","4",13123,22,0);
        FacebookItem[] fb = {f1,f2,f3,f4,f5};

        img1=(ImageView)layout.findViewById(R.id.sImage1);
        img2=(ImageView)layout.findViewById(R.id.sImage2);
        img3=(ImageView)layout.findViewById(R.id.cImage);
        update=layout.findViewById(R.id.cLayout);

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        update.setOnClickListener(this);

        //LayoutManager 설정, 이걸로 레이아웃 모드 변경가능
        layoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        //MyAdapter 설정, 데이터 반영
        firstAdapter = new MyAdapter(getActivity().getApplicationContext(),fb);

        //RecyclerView view 설정
        firstRecyclerView = (RecyclerView)layout.findViewById(R.id.rv);
        firstRecyclerView.setHasFixedSize(true);
        firstRecyclerView.setNestedScrollingEnabled(false);
        firstRecyclerView.setLayoutManager(layoutManager); // layoutMgr >> recyclerview
        firstRecyclerView.setAdapter(firstAdapter); //adpater >> recyclerview

//        firstRecyclerView.setOverScrollMode(View.OVER_SCROLL_ALWAYS);
//        firstRecyclerView.setScrollBarStyle(RecyclerView.SCROLLBARS_INSIDE_INSET);
//        firstRecyclerView.setHorizontalScrollBarEnabled(false);
        return layout;
    }


    //fragment first,
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.sImage1:
                Toast.makeText(getActivity(),"Camera button",LENGTH_SHORT).show();
                break;
            case R.id.sImage2:
                Toast.makeText(getActivity(),"Add story button",LENGTH_SHORT).show();
                break;
            case R.id.cLayout:
                Toast.makeText(getActivity(),"Update",LENGTH_SHORT).show();
                break;

        }
    }
}
