package com.adg.momo.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.adg.momo.R;

public class ModeChoose extends AppCompatActivity {
    private Button btn_ran_write;
    private Button btn_all_write;
    private String page;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_choose);
        page = getIntent().getStringExtra("page");
        btn_all_write = findViewById(R.id.btn_all_write);
        btn_ran_write = findViewById(R.id.btn_ran_write);
        btn_all_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mystartActivity(1);//键值 1 代表顺序默写
            }
        });
        btn_ran_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mystartActivity(2);//键值 2 代表随机默写

            }
        });
    }

    protected void mystartActivity(int mode){
        Intent intent = new Intent(this,WordActivity.class);
        intent.putExtra("mode",mode);
        intent.putExtra("page",page);
        startActivity(intent);

    }
}
