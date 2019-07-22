package com.example.momo.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;

import com.example.momo.Base.BaseActivity;
import com.example.momo.R;
import com.example.momo.Utils.BottomNavigationUtils;

import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;

public class HomeActivity extends BaseActivity {
    private final int[] PAGE_IDS = {
            R.id.nav_home_fragment,
            R.id.nav_dic_fragment,
            R.id.nav_writing_fragment
    };

    private NavController mNavController;

    private PageNavigationView mNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mNavigation = findViewById(R.id.navigation);

        mNavController = Navigation.findNavController(this, R.id.nav_host_fragment);

        initBottomNavigation(mNavigation);
    }
    /**
     * 初始化底部导航
     */
    private void initBottomNavigation(PageNavigationView pageNavigationView) {
        NavigationController navigationController = pageNavigationView.material()
                .addItem(R.drawable.home, "主页")
                .addItem(R.drawable.pen, "默写")
                .addItem(R.drawable.dic, "单词本")
                .build();
        BottomNavigationUtils.setupWithNavController(PAGE_IDS, navigationController, mNavController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return mNavController.navigateUp();
    }

}
