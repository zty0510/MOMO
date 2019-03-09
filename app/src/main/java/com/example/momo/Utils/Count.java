package com.example.momo.Utils;

import android.app.Activity;

import java.util.ArrayList;

public class Count {
    public int getCorrcet() {
        return corrcet;
    }

    public int getWrong() {
        return wrong;
    }

    public ArrayList getWrongList_Chinese() {
        return wrongList_Chinese;
    }
    public ArrayList getWrongList_English() {
        return wrongList_English;
    }

    int corrcet = 0;
    int wrong = 0 ;
    ArrayList<String> wrongList_Chinese = new ArrayList();
    ArrayList<String> wrongList_English = new ArrayList();
    public  void countCorrect(){
        corrcet = corrcet + 1;//计算正确答题数
    }
    public void addWrong(String wrongChinese,String wrongEnglish){
        wrong = wrong + 1;
        wrongList_Chinese.add(wrongChinese);
        wrongList_English.add(wrongEnglish);
    }
}
