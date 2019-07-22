package com.example.momo.Adapter;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.momo.R;
import com.example.momo.View.WordActivity;

import java.util.ArrayList;

public class PageAdapter extends RecyclerView.Adapter<PageAdapter.ViewHolder>{

    private  ArrayList<String> PageData;
    static class ViewHolder extends RecyclerView.ViewHolder{
        Button WordPage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            WordPage = (Button) itemView.findViewById(R.id.btn_Page);
        }
    }
    public PageAdapter(ArrayList<String> PageData){
        this.PageData = PageData;
    }


    @NonNull
    @Override
    public PageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // 实例化展示的view
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_page, viewGroup, false);
        // 实例化viewholder
        final ViewHolder viewHolder = new ViewHolder(v);
        viewHolder.WordPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                int page = position + 1;
                Intent intent = new Intent(v.getContext(),WordActivity.class);
                intent.putExtra("page",String.valueOf(page));
                v.getContext().startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final PageAdapter.ViewHolder viewHolder, int position) {
        viewHolder.WordPage.setText(PageData.get(position));
    }

    @Override
    public int getItemCount() {
        return PageData.size();
    }
}

