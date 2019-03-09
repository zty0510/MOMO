package com.example.momo.Presenter;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.util.Log;
import android.widget.Toast;

import com.example.momo.Model.WordSource;
import com.example.momo.Utils.Count;
import com.example.momo.View.Dictionary_Choose;
import com.example.momo.View.FinsihActivity;
import com.example.momo.View.IView_WordActivity;
import com.example.momo.View.WordActivity;

import java.util.ArrayList;
import java.util.Arrays;

import es.dmoral.toasty.Toasty;

import static android.content.ContentValues.TAG;

public class Word_Presenter implements IPresenter_word {
    private IView_WordActivity iView_wordActivity;
    private String[][] wordlist ;
    WordSource wordSource = new WordSource();
    Count count = new Count();


    public  Word_Presenter(IView_WordActivity view){
        iView_wordActivity = view;
        wordSource.setContext(iView_wordActivity.getContext());
    }
    public void setDic(String page) throws InterruptedException {
        wordSource.setPages(page);
        wordlist = wordSource.getWordlist();
        String text = wordlist[0][0];
        iView_wordActivity.setText(text);
    }
    public void nextWord(){
        String currentChinese = iView_wordActivity.getTV_Chinese();
        //Log.d(TAG, currentChinese);
        int position = WordSource.getIndex(wordlist,currentChinese);
        //Log.d(TAG, String.valueOf(position));
        if (position < wordlist.length - 1){
            String text = wordlist[position + 1][0];
            iView_wordActivity.setText(text);
        }else{
            Toast.makeText(iView_wordActivity.getContext(),"这是最后一个单词啦", Toast.LENGTH_SHORT).show();
        }

    }
    public void wordJudge(){
        String currentChinese = iView_wordActivity.getTV_Chinese();
        int position = WordSource.getIndex(wordlist,currentChinese);
        String correctEnglish = wordlist[position][1];
        if (iView_wordActivity.getEditText().equals(correctEnglish) ){
            //Log.d(TAG, "wordJudge: 0");
            count.countCorrect();
            Log.d(TAG, "正确"+ String.valueOf(count.getCorrcet()));
        }else {
            // Log.d(TAG, "wrong");
            count.addWrong(currentChinese,correctEnglish);
            Log.d(TAG, "错误"+ String.valueOf(count.getWrong()));
            Toasty.error(iView_wordActivity.getContext(),"答案错误，应为" + correctEnglish,Toasty.LENGTH_LONG).show();

        }
        if (position < wordlist.length - 1){
            String text = wordlist[position + 1][0];
            iView_wordActivity.setText(text);
            iView_wordActivity.clearInputText();
        }else{
            Toast.makeText(iView_wordActivity.getContext(),"答题完成", Toast.LENGTH_SHORT).show();
            iView_wordActivity.getContext();
            Intent intent =  new Intent(iView_wordActivity.getContext(), FinsihActivity.class);
            intent.putExtra("Correct",count.getCorrcet());
            intent.putExtra("Wrong",count.getWrong());
            intent.putStringArrayListExtra("WrongList_Chinese",count.getWrongList_Chinese());
            intent.putStringArrayListExtra("WrongList_English",count.getWrongList_English());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
            iView_wordActivity.getContext().startActivity(intent);
            //iView_wordActivity.getActivity().finish();

        }
    }
}








