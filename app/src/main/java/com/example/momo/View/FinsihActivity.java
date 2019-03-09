package com.example.momo.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.momo.R;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FinsihActivity extends AppCompatActivity {
    private TextView TV_Corrcetnumber;
    private TextView TV_WrongNumber;
    private Button show_WrongBook;
    private int CorrectNumber;
    private int WrongNumber;
    private ArrayList<String> WrongList_English;
    private ArrayList<String> WrongList_Chinese;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finsih);
        QMUIStatusBarHelper qmuiStatusBarHelper = new QMUIStatusBarHelper();
        qmuiStatusBarHelper.translucent(this);
        CorrectNumber = getIntent().getIntExtra("Correct",0);
        WrongNumber = getIntent().getIntExtra("Wrong",0);
        WrongList_Chinese = getIntent().getStringArrayListExtra("WrongList_Chinese");
        WrongList_English = getIntent().getStringArrayListExtra("WrongList_English");
        TV_Corrcetnumber = findViewById(R.id.TV_Corrcetnumber);
        TV_WrongNumber =  findViewById(R.id.TV_Wrongnumber);
        show_WrongBook = findViewById(R.id.show_WrongBook);
        TV_Corrcetnumber.setText("正确个数："+ CorrectNumber);
        TV_WrongNumber.setText("错误个数："+WrongNumber);
        show_WrongBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinsihActivity.this,WrongBook.class);
                intent.putStringArrayListExtra("WrongList_Chinese",WrongList_Chinese );
                intent.putStringArrayListExtra("WrongList_English",WrongList_English );
                startActivity(intent);
                finish();
            }
        });



    }
}
