package com.example.yutengfei.android_template.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.yutengfei.android_template.Data.DataMenuDetial;
import com.example.yutengfei.android_template.R;

import java.util.List;


/**
 * Created by yutengfei on 01/09/16.
 */
public class MenuDetailCardViewAdapter extends RecyclerView.Adapter<MenuDetailCardViewAdapter.mViewHolder> {

    private static String TAG ="MenuDetailAdapter";

    private List<DataMenuDetial> mData;
    private LayoutInflater mInflater;

    public MenuDetailCardViewAdapter(Context context,List<DataMenuDetial> data){
        this.mData = data;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mViewHolder mViewHolder = null;
        View view = null;

        view = this.mInflater.inflate(R.layout.item_cardview_menu_detail,parent,false);
        mViewHolder = new mViewHolder(view);
        Log.d(TAG,"Array is not null " + getItemCount());


        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(mViewHolder holder, int position) {
        DataMenuDetial dataMenuDetial = this.mData.get(position);
        holder.setData(dataMenuDetial,position);
        holder.setListeners();
    }

    @Override
    public int getItemCount() {
        return this.mData.size();
    }


    public void addItem(DataMenuDetial dataMenuDetial, int position){}

    public void removeItem(int position){
        this.mData.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,this.mData.size());
    }

    public class mViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private View itemView;
        private int position;

        private EditText name;
        private EditText price;
        private EditText describe;
        private EditText disconut;
        private ImageView imageView;

        public mViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.name = (EditText) itemView.findViewById(R.id.item_name);
            this.price = (EditText) itemView.findViewById(R.id.item_price);
            this.describe = (EditText) itemView.findViewById(R.id.item_describe);
            this.disconut = (EditText) itemView.findViewById(R.id.item_off);
            this.imageView = (ImageView) itemView.findViewById(R.id.item_image);

            if(this.imageView == null){
                Log.d(TAG,"image view is null");
            }
        }


        public void setData(DataMenuDetial dataMenuDetial, int position) {
            this.position = position;
            this.name.setText(dataMenuDetial.getName());
            this.price.setText(dataMenuDetial.getPrice());
            this.describe.setText(dataMenuDetial.getDiscribe());
            this.disconut.setText(dataMenuDetial.getDiscount());
            this.imageView.setImageResource(dataMenuDetial.getImage());
            return;
        }

        public void setListeners() {
            this.itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            return;
        }
    }
}
