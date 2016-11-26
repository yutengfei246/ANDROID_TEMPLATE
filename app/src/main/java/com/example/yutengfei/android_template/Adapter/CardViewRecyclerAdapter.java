package com.example.yutengfei.android_template.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yutengfei.android_template.Data.DataCardView;
import com.example.yutengfei.android_template.R;

import java.util.List;

/**
 * Created by yutengfei on 28/08/16.
 */
public class CardViewRecyclerAdapter extends RecyclerView.Adapter<CardViewRecyclerAdapter.ViewHolder> {

    private static final String TAG ="CardViewAdaper";

    private List<DataCardView> mData;
    private LayoutInflater mInflater;


    public CardViewRecyclerAdapter(Context context, List<DataCardView> data) {
        this.mData = data;
        this.mInflater = LayoutInflater.from(context);
    }

    /*Called when there is a space for new CardView*/
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = this.mInflater.inflate(R.layout.item_cardview,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    /*The call this method and set up everything */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DataCardView dataCardView = this.mData.get(position);
        holder.setData(dataCardView,position);
        holder.setListeners();
    }

    @Override
    public int getItemCount() {
        return this.mData.size();
    }

    public void addItem(DataCardView dataCardView, int position){}

    public void removeItem(int position){
        this.mData.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,this.mData.size());
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;
       // TextView intro;
        ImageView imageView;
        int position;
        View itemView;


        public ViewHolder(View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.item_card_title);
         //   this.intro = (TextView) itemView.findViewById(R.id.item_card_intro);
            this.imageView = (ImageView) itemView.findViewById(R.id.item_card_image);
            this.itemView = itemView;

        }

        public void setData(DataCardView dataCardView,int position){
            this.title.setText(dataCardView.getTitle());;
        //    this.intro.setText(dataCardView.getIntro());
            this.imageView.setImageResource(dataCardView.getImage());
            this.position = position;
        }

        public void setListeners() {
            this.itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //TODO: Action (Click the card ) Start detail activity
            v.startAnimation(AnimationUtils.loadAnimation(v.getContext(), R.anim.anim));
            //Intent intent = new Intent(v.getContext(), MenuDetailActivity.class);
            //intent.putExtra(AppConstant.TITLE_NAME,this.title.getText());
            //v.getContext().startActivity(intent);
        }
    }
}
