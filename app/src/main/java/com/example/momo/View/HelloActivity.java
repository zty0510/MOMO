package com.example.momo.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.momo.Base.BaseActivity;
import com.example.momo.R;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.textview.QMUISpanTouchFixTextView;

import es.dmoral.toasty.Toasty;

public class HelloActivity extends BaseActivity  {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HelloActivity.this, "欢迎使用默默", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HelloActivity.this,Wordlist_Choose.class);
                startActivity(intent);
            }
        });
        QMUIStatusBarHelper qmuiStatusBarHelper = new QMUIStatusBarHelper();
        qmuiStatusBarHelper.translucent(this);
    }


}
