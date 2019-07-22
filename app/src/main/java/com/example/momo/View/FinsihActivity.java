package com.example.momo.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.momo.Base.BaseActivity;
import com.example.momo.R;
import com.example.momo.Utils.Count;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FinsihActivity extends BaseActivity {
    private TextView TV_Corrcetnumber;
    private TextView TV_WrongNumber;
    private Button show_WrongBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finsih);
        QMUIStatusBarHelper qmuiStatusBarHelper = new QMUIStatusBarHelper();
        qmuiStatusBarHelper.translucent(this);
        final Count count = (Count) getIntent().getSerializableExtra("Count");
        int CorrectNumber = count.getCorrcet();
        int WrongNumber = count.getWrong();
        TV_Corrcetnumber = findViewById(R.id.TV_Corrcetnumber);
        TV_WrongNumber =  findViewById(R.id.TV_Wrongnumber);
        show_WrongBook = findViewById(R.id.show_WrongBook);
        TV_Corrcetnumber.setText("正确个数："+ CorrectNumber);
        TV_WrongNumber.setText("错误个数："+WrongNumber);
        show_WrongBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinsihActivity.this,WrongBook.class);
                intent.putExtra("Count",count);
                startActivity(intent);
                finish();
            }
        });



    }
}
