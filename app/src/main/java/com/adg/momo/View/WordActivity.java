package com.adg.momo.View;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.adg.momo.Base.BaseActivity;
import com.adg.momo.Presenter.IPresenter_word;
import com.adg.momo.Presenter.Word_Presenter;
import com.adg.momo.R;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

public class WordActivity extends BaseActivity implements IView_WordActivity {
    private IPresenter_word iPresenter_word;
    private TextView tv_word_chinese;
    private EditText inputText;
    private  Button nextWord;
    private String page;
    private Button foreSubmit;
    private int mode;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
        page = getIntent().getStringExtra("page");
        mode = getIntent().getIntExtra("mode",1);
        Log.d("WordActivity ",page);
        iPresenter_word = new Word_Presenter(this);
        tv_word_chinese = findViewById(R.id.TV_Word_Chinese);
        inputText = findViewById(R.id.Edit_InputText);
        nextWord = findViewById(R.id.btn_nextword);
        foreSubmit = findViewById(R.id.btn_foreSubmit);
        inputText.setImeOptions(EditorInfo.IME_ACTION_NEXT);
        QMUIStatusBarHelper qmuiStatusBarHelper = new QMUIStatusBarHelper();
        qmuiStatusBarHelper.translucent(this);
        try {
            iPresenter_word.setDic(mode,page);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        foreSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iPresenter_word.foreSubmit();
            }
        });

        nextWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             iPresenter_word.wordJudge();
            }
        });

        inputText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 设置软键盘的Enter键显示文字
               // inputText.setImeOptions(EditorInfo.IME_ACTION_NEXT);

             // 对enter点击事件监听
                inputText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        if(actionId == EditorInfo.IME_ACTION_NEXT|| (event !=null&& event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                           //跳转下一个单词
                            iPresenter_word.wordJudge();
                            return true;
                        }
                        return false;
                    }
                });
            }
        });
    }

    @Override
    public void setText(String text) {
        tv_word_chinese.setText(text);
    }

    @Override
    public String getEditText() {
        return inputText.getText().toString();
    }

    @Override
    public String getTV_Chinese() {
        return tv_word_chinese.getText().toString();
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }


    @Override
    public void setEditText(String word) {
        inputText.setText(word);
    }
    public void clearInputText(){
        inputText.setText("");
    }


    public WordActivity getActivity() {
        return this;
    }


}
