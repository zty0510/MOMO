package com.adg.momo.Presenter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.adg.momo.Model.WordSource;
import com.adg.momo.Utils.Count;
import com.adg.momo.View.FinsihActivity;
import com.adg.momo.View.IView_WordActivity;

import es.dmoral.toasty.Toasty;

import static android.content.ContentValues.TAG;

public class Word_Presenter implements IPresenter_word {
    private IView_WordActivity iView_wordActivity;
    private String[][] wordlist ;
    private Context context;
    WordSource wordSource = new WordSource();
    Count count = new Count();


    public  Word_Presenter(IView_WordActivity view){
        iView_wordActivity = view;
        context = iView_wordActivity.getContext();
        wordSource.setContext(context);
    }
    public void setDic(int mode,String page) throws InterruptedException {
        wordSource.setPages(page);
        switch (mode){
            case 1 :
                wordlist = wordSource.get_all_Wordlist();
                break;
            case 2 :
                wordlist = wordSource.get_ran_Wordlist();
        }
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
            Log.d(TAG, count.toString());
        }else{
            Toast.makeText(context,"这是最后一个单词啦", Toast.LENGTH_SHORT).show();
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
            Toasty.error(context,"答案错误，应为" + correctEnglish,Toasty.LENGTH_LONG).show();

        }
        if (position < wordlist.length - 1){
            String text = wordlist[position + 1][0];
            iView_wordActivity.setText(text);
            iView_wordActivity.clearInputText();
        }else{
           foreSubmit();
        }
    }

    @Override
    public void foreSubmit() {
        Toast.makeText(context,"答题完成", Toast.LENGTH_SHORT).show();
        Intent intent =  new Intent(context, FinsihActivity.class);
        intent.putExtra("Count",count);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
        iView_wordActivity.getActivity().finish();
        context.startActivity(intent);
    }
}