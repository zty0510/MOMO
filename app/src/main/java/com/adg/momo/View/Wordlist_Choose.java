package com.adg.momo.View;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.adg.momo.Adapter.PageAdapter;
import com.adg.momo.Base.BaseActivity;
import com.adg.momo.R;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;

public class Wordlist_Choose extends BaseActivity {
    private ArrayList<String> PageList = new ArrayList<String>() ;
    private RecyclerView recyclerView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wordlist__choose);
        QMUIStatusBarHelper qmuiStatusBarHelper = new QMUIStatusBarHelper();
        qmuiStatusBarHelper.translucent(this);
        int dic = getIntent().getIntExtra("dic",1);
        switch (dic){
            case 1 :
                init_gaoci_PageList();
                break;
            case 2:
                init_six_PageList();
                break;
        }
        recyclerView = findViewById(R.id.Recycler_Wordlist);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        PageAdapter pageAdapter = new PageAdapter((ArrayList<String>) PageList);
        pageAdapter.setdic(dic);
        Toasty.normal(this,"长按可以预览单词噢！",Toast.LENGTH_SHORT).show();
        recyclerView.setAdapter(pageAdapter);
    }
    public void init_gaoci_PageList() {
        int m = 1;
        for (int i = 0; i < 37; i++) {
//       通过循环构造高词名称列表
            String name = "高词" + toString().valueOf(m + 10 * i) + "—" + toString().valueOf(m + 9 + 10 * i) + "页";
            Log.d("1", name);
            PageList.add(name);

        }

    }
    public void init_six_PageList(){
//        通过循环构造高词名称列表
        String name = "Wordlist";
        for (int i = 0; i<30;i++){
            PageList.add(name + String.valueOf(i+1));
        }

    }

}


