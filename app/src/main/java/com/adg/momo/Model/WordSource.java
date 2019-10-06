package com.adg.momo.Model;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import static android.content.ContentValues.TAG;

public class WordSource {
    private String all_Wordlist[][];
    private String ran_Wordlist[][];
    private String pages;
    private ArrayList<String[][]> arrayList;
    private Context viewContext;

    public void setPages(String pages) {
        this.pages = pages;
    }

    public void setContext(Context context) {
        this.viewContext = context;

    }

    public static int getIndex(String[][] arr, String value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == value | arr[i][1] == value) {
                return i;
            }
        }
        return -1;//如果未找到返回-1
    }
    private String[] get_originlist(int dic) {
        InputStream in = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try {
            switch (dic){
                case 1 :
                    in = viewContext.getAssets().open("wordlist/" + pages + ".dat");
                    break;
                case 2:
                    in = viewContext.getAssets().open("six_wordlist/" + pages + ".dat");
                    break;
            }

            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Log.d(TAG, String.valueOf(content));
            String[] originlist = content.toString().split("#");//分割字符串
            return originlist;

        }
    }
    public String[][] get_all_Wordlist(int dic){
            String[] originlist = get_originlist(dic);
            all_Wordlist = new String[originlist.length ][originlist.length ];
            for (int i = 0; i < originlist.length; i++) {
                //Log.d(TAG, originlist[i]);
                String[] newlist = originlist[i].split("&");
                Log.d(TAG, newlist[0]);
                all_Wordlist[i][0] = newlist[0];//此处存入中文单词
                all_Wordlist[i][1] = newlist[1];//此处存入英文单词
            }
            return all_Wordlist;
        }


    public String[][] get_ran_Wordlist(int dic){
        String[] originlist = get_originlist(dic);
        ran_Wordlist = new String[originlist.length ][originlist.length ];
        int[] ran_num = getRandom_Num(originlist.length);
//        Log.d(TAG, String.valueOf(originlist));
//        Log.d(TAG, String.valueOf(ran_num.length));
        for (int i = 0; i < ran_num.length; i++) {
            int num = ran_num[i];
            String[] newlist = originlist[num].split("&");
           Log.d(TAG, newlist[0]);
            ran_Wordlist[i][0] = newlist[0];//此处存入中文单词
            ran_Wordlist[i][1] = newlist[1];//此处存入英文单词
        }
        return ran_Wordlist;

    }

    public int [] getRandom_Num(int length) {
        Random random = new Random();
        int ran_num[] = new int[length];//随机数组
        for (int i = 0; i < ran_num.length; i++) {
            ran_num[i] = random.nextInt(length);
            for (int j = 0; j < i; j++) {
                while (ran_num[i] == ran_num[j]) {//如果重复，退回去重新生成随机数
                    i--;
                }
            }
        }
        return ran_num;
    }

}









