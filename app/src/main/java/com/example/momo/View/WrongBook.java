package com.example.momo.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.momo.Adapter.WrongBook_Adapter;
import com.example.momo.Base.BaseActivity;
import com.example.momo.R;
import com.example.momo.Utils.Count;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import java.util.ArrayList;

public class WrongBook extends BaseActivity {
    private RecyclerView WrongBook;
    private ArrayList<String> WrongList_English;
    private ArrayList<String> WrongList_Chinese;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong_book);
        QMUIStatusBarHelper qmuiStatusBarHelper = new QMUIStatusBarHelper();
        qmuiStatusBarHelper.translucent(this);
        Count count = (Count) getIntent().getSerializableExtra("Count");
        WrongList_Chinese = count.getWrongList_Chinese();
        WrongList_English = count.getWrongList_English();
        WrongBook = findViewById(R.id.WrongBook_RecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        WrongBook.setLayoutManager(linearLayoutManager);
        WrongBook_Adapter wrongBook_adapter  = new WrongBook_Adapter(WrongList_Chinese,WrongList_English);
        WrongBook.setAdapter(wrongBook_adapter);
    }
}
