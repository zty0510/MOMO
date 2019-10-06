package com.adg.momo.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adg.momo.R;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class  PreviewList_Adapter extends RecyclerView.Adapter<PreviewList_Adapter.ViewHolder> {

    private int dic;
    private ArrayList<String> Englishlist;
    private ArrayList<String> Chineselist;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.TV_wrongbook);
        }
    }

    public PreviewList_Adapter(ArrayList<String> Chineselist, ArrayList<String> Englishlist) {
        this.Chineselist = Chineselist;
        this.Englishlist = Englishlist;
    }

    @NonNull
    @Override
    public PreviewList_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // 实例化展示的view
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_wrongbook, viewGroup, false);
        // 实例化viewholder
        final PreviewList_Adapter.ViewHolder viewHolder = new PreviewList_Adapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PreviewList_Adapter.ViewHolder viewHolder, int position) {
        viewHolder.textView.setText(Chineselist.get(position)+"\n"+Englishlist.get(position));
        Log.d(TAG, Chineselist.get(position));
    }

    @Override
    public int getItemCount() {
        return Englishlist.size();
    }
    public void setdic(int a) {
        dic = a;
    }
}

