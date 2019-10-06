package com.adg.momo.View;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.adg.momo.R;

public class about extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        textView = findViewById(R.id.about_TV);
        String LinkText = "默默Android版由 ADG （一名奉贤中学的高三学生）独立完成编写，其中的词库数据库由若干位支持者提供,感谢各方支持！"  +
                "\rPC版（FYH开发）请移至此官网：<a href='http://www.joyooz.com/momo/'> http://www.joyooz.com/momo/</a>\n" +
                "\r默默Android版更新地址：<a href='https://fir.im/momo66'>https://fir.im/momo66/</a>" +
                "\r个人的博客网站也欢迎大家多多支持<a href='\t https://blog.adg666.men/'> https://blog.adg666.men/</a>" ;
        textView.setText(Html.fromHtml(LinkText));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
