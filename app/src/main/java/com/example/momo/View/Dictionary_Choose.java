package com.example.momo.View;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.momo.Adapter.Dic_Adapter;
import com.example.momo.Base.BaseActivity;
import com.example.momo.R;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.yarolegovich.discretescrollview.DiscreteScrollView;

public class Dictionary_Choose extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary__choose);
        DiscreteScrollView scrollView = findViewById(R.id.picker);
        scrollView.setAdapter(new Dic_Adapter());
        QMUIStatusBarHelper qmuiStatusBarHelper = new QMUIStatusBarHelper();
        qmuiStatusBarHelper.translucent(this);
    }

}
