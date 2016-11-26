package com.example.yutengfei.android_template.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.yutengfei.android_template.R;

/**
 * Created by yutengfei on 29/08/16.
 */
public class PagerFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
     //   RecyclerView recyclerView = (RecyclerView) inflater.inflate(
      //          R.layout.item_recycler_view, container, false);
        //setupRecyclerView(recyclerView);

        View view =  inflater.inflate(R.layout.test,container,false);
        return view;
    }

    /*
    private void setupRecyclerView(RecyclerView recyclerView) {
       //recyclerView.setHasFixedSize(true);
        List<DataCardView> data = Util.GetInitialListDataCardView();
        CardViewRecyclerAdapter cardViewRecyclerAdapter = new CardViewRecyclerAdapter(getActivity(),data);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(cardViewRecyclerAdapter);
    }
    */
}