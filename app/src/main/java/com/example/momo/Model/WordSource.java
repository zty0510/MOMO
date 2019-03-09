package com.example.momo.Model;

import android.content.Context;
import android.os.Looper;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

public class WordSource {
    private String Wordlist[][];
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

    public String[][] getWordlist()  {
        InputStream in = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try {
            in = viewContext.getAssets().open("wordlist/" + pages + ".dat");
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
            Wordlist = new String[originlist.length ][originlist.length ];
            for (int i = 0; i < originlist.length; i++) {
                //Log.d(TAG, originlist[i]);
                String[] newlist = originlist[i].split("&");
                Log.d(TAG, newlist[0]);
                Wordlist[i][0] = newlist[0];//此处存入中文单词
                Wordlist[i][1] = newlist[1];//此处存入英文单词
            }

            return Wordlist;
        }
    }


    //okhttp从服务器获取词库
   /*public String[][] getWordList() throws InterruptedException {
        class thread extends Thread{
            @Override
            public void run() {
                try {
                    Looper.prepare();
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("http://momo.adg666.men/wordlist/" + pages + ".dat")
                            .build();
                    Response response = client.newCall(request).execute();
                    String responsedata = response.body().string();//获取单词库并解析
                    Log.d(TAG ,responsedata);
                    String[] originlist = responsedata.split("#");//分割字符串
                    for (int i = 0; i < originlist.length; i++) {
                        Log.d(TAG, originlist[i]);
                        String[] newlist = originlist[i].split("&");
                        Log.d(TAG,newlist[0]);
                        Wordlist = new String[originlist.length / 2][originlist.length / 2];
                        Wordlist[i][0] = newlist[0];//此处存入中文单词
                        Wordlist[i][1] = newlist[1];//此处存入英文单词
                        Looper.loop();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        thread t = new thread();
        t.start();
        t.join();
        return Wordlist;
        }*/
}









