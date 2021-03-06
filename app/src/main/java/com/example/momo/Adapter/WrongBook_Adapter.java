package com.example.momo.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.momo.R;

import java.util.ArrayList;

public class WrongBook_Adapter extends RecyclerView.Adapter<WrongBook_Adapter.ViewHolder> {
    private ArrayList<String> WrongList_English;
    private ArrayList<String> WrongList_Chinese;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.TV_wrongbook);
        }
    }
    public WrongBook_Adapter(ArrayList<String> WrongList_Chinese,ArrayList<String> WrongList_English){
        this.WrongList_Chinese = WrongList_Chinese;
        this.WrongList_English = WrongList_English;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // 实例化展示的view
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_wrongbook, viewGroup, false);
        // 实例化viewholder
        final WrongBook_Adapter.ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.textView.setText(WrongList_Chinese.get(position)+":"+WrongList_English.get(position));
    }

    @Override
    public int getItemCount() {
        return WrongList_English.size();
    }
}
