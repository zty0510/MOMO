package com.example.momo.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.momo.Adapter.PageAdapter;
import com.example.momo.Model.WordSource;
import com.example.momo.R;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import java.util.ArrayList;

public class Wordlist_Choose extends AppCompatActivity {
    private ArrayList<String> PageList = new ArrayList<String>() ;
    private RecyclerView recyclerView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wordlist__choose);
        QMUIStatusBarHelper qmuiStatusBarHelper = new QMUIStatusBarHelper();
        qmuiStatusBarHelper.translucent(this);
        initPageList();
        recyclerView = findViewById(R.id.Recycler_Wordlist);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        PageAdapter pageAdapter = new PageAdapter((ArrayList<String>) PageList);
        recyclerView.setAdapter(pageAdapter);
        WordSource wordSource = new WordSource();
    }
    public void initPageList(){
        String [] data = {"高词1—10页","高词11—20页","高词21—30页","高词31—40页",
                "高词41—50页","高词51—60页","高词61—70页","高词71—80页",
                "高词81—90页", "高词91—100页","高词101—110页","高词111—120页",
                "高词121—130页", "高词131—140页","高词141—150页","高词151—160页",
                "高词161—170页", "高词171—180页","高词181—190页","高词191—200页",
                "高词201—210页","高词211—220页","高词221—230页","高词231—240页",
                "高词241—250页","高词251—260页","高词261—270页","高词271—280页",
                "高词281—290页","高词291—300页", "高词301—310页","高词311—320页",
                "高词321—330页","高词331—340页","高词341—350页","高词351—360页","高词361—370页"};
        for(int i = 0 ; i<data.length;i++){
            //Log.d("1", data[i]);
            PageList.add(data[i]);//通过循环构造名称列表
        }

    }

}


