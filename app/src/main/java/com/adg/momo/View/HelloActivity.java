package com.adg.momo.View;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

import com.adg.momo.Base.BaseActivity;
import com.adg.momo.R;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

public class HelloActivity extends BaseActivity  {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(HelloActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1500);
        QMUIStatusBarHelper qmuiStatusBarHelper = new QMUIStatusBarHelper();
        qmuiStatusBarHelper.translucent(this);
    }


}
