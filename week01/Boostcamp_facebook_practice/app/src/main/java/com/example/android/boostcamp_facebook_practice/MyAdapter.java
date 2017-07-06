package com.example.android.boostcamp_facebook_practice;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

class FacebookItem {
    String t1;
    String t2;
    String t3;
    String t4;
    int comment, share, like;

    public FacebookItem(String t1, String t2, String t3, String t4, int comment, int share, int like) {
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.t4 = t4;
        this.comment = comment;
        this.share = share;
        this.like = like;
    }

    public void setT2(String t2) {
        this.t2 = t2;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public int getShare() {
        return share;
    }

    public void setShare(int share) {
        this.share = share;
    }


    public String getT1() {
        return t1;
    }

    public void setT1(String t1) {
        this.t1 = t1;
    }

    public String getT2() {
        return t2;
    }

    public void setT2t(String t2) {
        this.t2 = t2;
    }

    public String getT3() {
        return t3;
    }

    public void setT3(String t3) {
        this.t3 = t3;
    }

    public String getT4() {
        return t4;
    }

    public void setT4(String t4) {
        this.t4 = t4;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private FacebookItem[] fb;
    private int itemCount;

    public MyAdapter(Context applicationContext, FacebookItem[] fb) {
        this.fb = fb;
        itemCount = fb.length;
    }

    //viewtype에 따라 각 item의 view를 생성함
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.item_view;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);//3번째 param은 뭐지?


        return new MyViewHolder(view);
    }

    //각 item에 data반영
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv1.setText((fb[position].getT1()));
        holder.tv2.setText((fb[position].getT2()));
        holder.tv3.setText((fb[position].getT3()));
        holder.tv4.setText((fb[position].getT4()));
        holder.tv5.setText("댓글 " + (fb[position].getComment()) + "개");
        holder.tv6.setText("공유 " + (fb[position].getShare()) + "회");


        holder.i1.setImageResource(R.drawable.ic_profile);
        holder.i2.setImageResource(R.drawable.ic_piu);


    }

    @Override
    public int getItemCount() {
        return itemCount;
    }

    //Viewholder class. 각 item 설정
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView tv1;
        public final TextView tv2;
        public final TextView tv3;
        public final TextView tv4;
        public final TextView tv5;
        public final TextView tv6;
        public final View v1, v2, v3, v4;
        public final ImageView i1, i2;

        public MyViewHolder(View view) {

            super(view);
            tv1 = (TextView) view.findViewById(R.id.textView1);
            tv2 = (TextView) view.findViewById(R.id.textView2);
            tv3 = (TextView) view.findViewById(R.id.textView3);
            tv4 = (TextView) view.findViewById(R.id.textView4);
            tv5 = (TextView) view.findViewById(R.id.textView5);
            tv6 = (TextView) view.findViewById(R.id.textView6);
            v1 = view.findViewById(R.id.button1);
            v2 = view.findViewById(R.id.button2);
            v3 = view.findViewById(R.id.button3);
            v4 = view.findViewById(R.id.button4);
            i1 = (ImageView) view.findViewById(R.id.imageView1);
            i2 = (ImageView) view.findViewById(R.id.imageView2);


            v1.setOnClickListener(this);
            v2.setOnClickListener(this);
            v3.setOnClickListener(this);
            v4.setOnClickListener(this);
            i1.setOnClickListener(this);
            i2.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button1:
                    Toast.makeText(view.getContext(), getAdapterPosition() + ": arrow", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button2:
                    Toast.makeText(view.getContext(), getAdapterPosition() + ": like", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button3:
                    Toast.makeText(view.getContext(), getAdapterPosition() + ": comment", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button4:
                    Toast.makeText(view.getContext(), getAdapterPosition() + ": share", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.imageView1:
                    Toast.makeText(view.getContext(), getAdapterPosition() + ": this is profile", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.imageView2:
                    Toast.makeText(view.getContext(), getAdapterPosition() + ": this is main image", Toast.LENGTH_SHORT).show();
                    break;

            }
        }


    }
}

