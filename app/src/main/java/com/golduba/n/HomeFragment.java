package com.golduba.n;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeFragment extends Fragment {

    RecyclerView home_recyclerView;
    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> arrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View homeFgmt = inflater.inflate(R.layout.fragment_home, container, false);
        home_recyclerView = homeFgmt.findViewById(R.id.home_recyclerView);

        arrayList = new ArrayList<>();

        // First video item
        hashMap = new HashMap<>();
        hashMap.put("video_id", "UPDFLw-euiE");
        hashMap.put("title", "নবীগঞ্জ ঘোলডুবা গ্রাম");
        arrayList.add(hashMap);

        // Second video item
        hashMap = new HashMap<>();
        hashMap.put("video_id", "7kWBlVX8Ufw"); // Corrected video_id
        hashMap.put("title", "Sylhet Tour Plan");
        arrayList.add(hashMap);


        // First video item
        hashMap = new HashMap<>();
        hashMap.put("video_id", "UPDFLw-euiE");
        hashMap.put("title", "নবীগঞ্জ ঘোলডুবা গ্রাম");
        arrayList.add(hashMap);

        // Second video item
        hashMap = new HashMap<>();
        hashMap.put("video_id", "7kWBlVX8Ufw"); // Corrected video_id
        hashMap.put("title", "Sylhet Tour Plan");
        arrayList.add(hashMap);


        // First video item
        hashMap = new HashMap<>();
        hashMap.put("video_id", "UPDFLw-euiE");
        hashMap.put("title", "নবীগঞ্জ ঘোলডুবা গ্রাম");
        arrayList.add(hashMap);

        // Second video item
        hashMap = new HashMap<>();
        hashMap.put("video_id", "7kWBlVX8Ufw"); // Corrected video_id
        hashMap.put("title", "Sylhet Tour Plan");
        arrayList.add(hashMap);

        MyAdapter adapter = new MyAdapter();
        home_recyclerView.setAdapter(adapter);
        home_recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return homeFgmt;
    }

    //-----------------------------------------------------------------------------------------

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.myViewHolder> {

        @NonNull
        @Override
        public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View myView = inflater.inflate(R.layout.recycle_item, parent, false);
            return new myViewHolder(myView);
        }

        @Override
        public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
            hashMap = arrayList.get(position);
            String title = hashMap.get("title");
            String video_id = hashMap.get("video_id");
            String imgUrl = "https://img.youtube.com/vi/" + video_id + "/0.jpg";

            holder.recyclerTextView.setText(title);
            Glide.with(HomeFragment.this) // Fixed Glide context
                    .load(imgUrl)
                    .centerCrop()
                    .into(holder.image_home_fragment);
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        private class myViewHolder extends RecyclerView.ViewHolder {
            ImageView image_home_fragment;
            TextView recyclerTextView;

            public myViewHolder(@NonNull View itemView) {
                super(itemView);
                image_home_fragment = itemView.findViewById(R.id.image_home_fragment);
                recyclerTextView = itemView.findViewById(R.id.recyclerTextView);
            }
        }
    }

    //-----------------------------------------------------------------------------------------
}