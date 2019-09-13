package com.adg.momo.View;

import android.os.Bundle;

import com.adg.momo.Adapter.Dic_Adapter;
import com.adg.momo.Base.BaseActivity;
import com.adg.momo.R;
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
