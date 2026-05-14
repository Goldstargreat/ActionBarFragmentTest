package kr.ac.kopo.actionbarfragmenttest;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {
    ActionBar.Tab tab1, tab2, tab3;
    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tab1 = bar.newTab();
        tab1.setText("Dog");
        tab1.setTabListener(this);
        bar.addTab(tab1);

        tab2 = bar.newTab();
        tab2.setText("Cat");
        tab2.setTabListener(this);
        bar.addTab(tab2);

        tab3 = bar.newTab();
        tab3.setText("Horse");
        tab3.setTabListener(this);
        bar.addTab(tab3);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        MyTabFragment myTabFragment = new MyTabFragment();
        Bundle data = new Bundle();
        data.putString("tabName", tab.getText().toString());
        myTabFragment.setArguments(data);
        ft.replace(android.R.id.content, myTabFragment);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {}

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {}
}