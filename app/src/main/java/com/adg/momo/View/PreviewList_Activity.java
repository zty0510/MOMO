package com.adg.momo.View;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.adg.momo.Adapter.PreviewList_Adapter;
import com.adg.momo.Model.WordSource;
import com.adg.momo.R;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import java.util.ArrayList;

public class PreviewList_Activity extends AppCompatActivity {

    private RecyclerView PreviewList ;
    private int dic;
    private String page;
    private String all_Wordlist[][];
    private ArrayList<String> Englishlist = new ArrayList<>();
    private ArrayList<String> Chineselist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_list_);
        QMUIStatusBarHelper qmuiStatusBarHelper = new QMUIStatusBarHelper();
        qmuiStatusBarHelper.translucent(this);
        PreviewList = findViewById(R.id.Preview_list_RecylerView);
        dic = getIntent().getIntExtra("dic",1);
        Log.d("aaa", String.valueOf(dic));
        page = getIntent().getStringExtra("page");
        Log.d("aaa", page);
        WordSource wordSource = new WordSource();
        wordSource.setContext(getApplicationContext());
        wordSource.setPages(page);
        all_Wordlist = wordSource.get_all_Wordlist(dic);

        for(int i = 0; i<all_Wordlist.length;i++){
            Englishlist.add(all_Wordlist[i][1]);
            Chineselist.add(all_Wordlist[i][0]);
        }


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        PreviewList.setLayoutManager(linearLayoutManager);
        PreviewList_Adapter previewListAdapter  = new PreviewList_Adapter(Chineselist,Englishlist);
        PreviewList.setAdapter(previewListAdapter);
    }


}
