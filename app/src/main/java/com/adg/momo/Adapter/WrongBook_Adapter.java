package com.adg.momo.Adapter;

import android.text.Html;
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
        String str=WrongList_Chinese.get(position)+":<font color='#FF0000'><normal>"+WrongList_English.get(position)+"</normal></font>";
//        viewHolder.textView.setText(WrongList_Chinese.get(position)+"\n"+WrongList_English.get(position));
        viewHolder.textView.setText(Html.fromHtml(str));
        Log.d(TAG,WrongList_Chinese.get(position) );
    }

    @Override
    public int getItemCount() {
        return WrongList_English.size();
    }
}
