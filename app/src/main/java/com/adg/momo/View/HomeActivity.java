package com.adg.momo.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.adg.momo.Base.BaseActivity;
import com.adg.momo.R;
import com.adg.momo.Utils.BottomNavigationUtils;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;

public class HomeActivity extends BaseActivity {
    private final int[] PAGE_IDS = {
            R.id.nav_writing_fragment,
            R.id.nav_dic_fragment
    };

    private NavController mNavController;

    private PageNavigationView mNavigation;

    private int nav_Color = 0x721D4EA2;

    @Override
    public void onBackPressed() {
        // super.onBackPressed(); 	不要调用父类的方法
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menu_about:
               Intent intent = new Intent(this,about.class);
               startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mNavigation = findViewById(R.id.navigation);
        mNavController = Navigation.findNavController(this, R.id.nav_host_fragment);
        initBottomNavigation(mNavigation);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        new QMUIStatusBarHelper().translucent(this);
    }
    /**
     * 初始化底部导航
     */
    private void initBottomNavigation(PageNavigationView pageNavigationView) {
        NavigationController navigationController = pageNavigationView.material()
//                .addItem(R.drawable.home, "主页",nav_Color)
                .addItem(R.drawable.pen, "默写",nav_Color)
                .addItem(R.drawable.dic, "单词本",nav_Color)
                .build();
        BottomNavigationUtils.setupWithNavController(PAGE_IDS, navigationController, mNavController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return mNavController.navigateUp();
    }

}
