package com.example.momo.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.momo.Adapter.WrongBook_Adapter;
import com.example.momo.R;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import java.util.ArrayList;

public class WrongBook extends AppCompatActivity {
    private RecyclerView WrongBook;
    private ArrayList<String> WrongList_English;
    private ArrayList<String> WrongList_Chinese;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong_book);
        QMUIStatusBarHelper qmuiStatusBarHelper = new QMUIStatusBarHelper();
        qmuiStatusBarHelper.translucent(this);
        WrongList_Chinese = getIntent().getStringArrayListExtra("WrongList_Chinese");
        WrongList_English = getIntent().getStringArrayListExtra("WrongList_English");
        WrongBook = findViewById(R.id.WrongBook_RecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        WrongBook.setLayoutManager(linearLayoutManager);
        WrongBook_Adapter wrongBook_adapter  = new WrongBook_Adapter(WrongList_Chinese,WrongList_English);
        WrongBook.setAdapter(wrongBook_adapter);
    }
}
