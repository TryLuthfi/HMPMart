package xtrch.com.hmpmart.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import xtrch.com.hmpmart.Fragment.ChatFragment;
import xtrch.com.hmpmart.Fragment.HomeFragment;
import xtrch.com.hmpmart.Fragment.IklanFragment;
import xtrch.com.hmpmart.Fragment.JualFragment;
import xtrch.com.hmpmart.Fragment.ProfilFragment;
import xtrch.com.hmpmart.R;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tbMain;
    int positionTab = 0;
    private int[] tabIcons = {
            R.drawable.home,
            R.drawable.search,
            R.drawable.plus,
            R.drawable.profil,
            R.drawable.home
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setFindView();

        FragmentManager fm =  getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        fragmentTransaction.replace(R.id.frame_container, new HomeFragment());
        fragmentTransaction.commit();

        setTabLayout();
    }

    private void setFindView() {
        tbMain = findViewById(R.id.main_tab);
    }

    private void setTabLayout(){
        tbMain.addTab(tbMain.newTab().setText("Home"));
        tbMain.addTab(tbMain.newTab().setText("Chat"));
        tbMain.addTab(tbMain.newTab().setText("Jual"));
        tbMain.addTab(tbMain.newTab().setText("Iklan"));
        tbMain.addTab(tbMain.newTab().setText("Profil"));

        setupTabIcons();

        tbMain.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                positionTab = tab.getPosition();

                changeFragment();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public void changeFragment(){
        if(positionTab == 0){
            FragmentManager fm =  getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();

            fragmentTransaction.replace(R.id.frame_container, new HomeFragment());
            fragmentTransaction.commit();
        } else if(positionTab == 1){
            FragmentManager fm =  getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();

            fragmentTransaction.replace(R.id.frame_container, new ChatFragment());
            fragmentTransaction.commit();
        } else if(positionTab == 2){
            FragmentManager fm =  getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();

            fragmentTransaction.replace(R.id.frame_container, new JualFragment());
            fragmentTransaction.commit();
        } else if(positionTab == 3){
            FragmentManager fm =  getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();

            fragmentTransaction.replace(R.id.frame_container, new IklanFragment());
            fragmentTransaction.commit();
        } else if(positionTab == 4){
            FragmentManager fm =  getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();

            fragmentTransaction.replace(R.id.frame_container, new ProfilFragment());
            fragmentTransaction.commit();
        }
    }

    private void setupTabIcons() {
        tbMain.getTabAt(0).setIcon(tabIcons[0]);
        tbMain.getTabAt(1).setIcon(tabIcons[1]);
        tbMain.getTabAt(2).setIcon(tabIcons[2]);
        tbMain.getTabAt(3).setIcon(tabIcons[3]);
        tbMain.getTabAt(4).setIcon(tabIcons[4]);
    }
}