package com.golduba.n;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class HomeFragment extends Fragment {

    RecyclerView home_recyclerView;
    HashMap <String, String> hashMap;
    ArrayList<HashMap<String,String> >arrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View homeFgmt = inflater.inflate(R.layout.fragment_home, container, false);
       home_recyclerView =homeFgmt.findViewById(R.id.home_recyclerView);

       arrayList = new ArrayList<>();
       hashMap = new HashMap<>();
       hashMap.put("video_id", " ");
       hashMap.put("title"," ");
       arrayList.add(hashMap);

       MyAdapter adapter = new MyAdapter();
       home_recyclerView.setAdapter(adapter);
       home_recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));



        return homeFgmt;
    }
    //-----------------------------------------------------------------------------------------

    private class MyAdapter extends RecyclerView.Adapter <MyAdapter.myViewHolder> {

        private  class myViewHolder extends RecyclerView.ViewHolder{

            ImageView image_home_fragment;
            TextView recyclerTextView;


            public myViewHolder(@NonNull View itemView) {
                super(itemView);

                image_home_fragment = itemView.findViewById(R.id.image_home_fragment);
                recyclerTextView = itemView.findViewById(R.id.recyclerTextView);


            }
        }


        @NonNull
        @Override
        public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater = getLayoutInflater();
            View myView = inflater.inflate(R.layout.recycle_item, parent, false);



            return new myViewHolder(myView);
        }

        @Override
        public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

            holder.recyclerTextView.setText("Item Position:" +position);

        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }



    }

    //-----------------------------------------------------------------------------------------
}