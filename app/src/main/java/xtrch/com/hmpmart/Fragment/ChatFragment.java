package xtrch.com.hmpmart.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import xtrch.com.hmpmart.Adapter.AdapterTabMain;
import xtrch.com.hmpmart.R;
public class ChatFragment extends Fragment {
    TabLayout tlMain;
    ViewPager vpMain;

    View view;

    public ChatFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_chat, container, false);

        setFindView();
        setTabLayout();

        return view;
    }

    private void setFindView() {

        tlMain = view.findViewById(R.id.main_tab);
        vpMain = view.findViewById(R.id.main_pager);

    }

    private void setTabLayout(){
        tlMain.addTab(tlMain.newTab().setText("Home"));
        tlMain.addTab(tlMain.newTab().setText("Profile"));
        //Adapter
        AdapterTabMain adapterTabRehab = new AdapterTabMain(getActivity().getSupportFragmentManager(), tlMain.getTabCount());
        vpMain.setAdapter(adapterTabRehab);
        vpMain.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tlMain));
        vpMain.setOffscreenPageLimit(adapterTabRehab.getCount());
        //OnClick
        tlMain.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpMain.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}