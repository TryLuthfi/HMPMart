package xtrch.com.hmpmart.Adapter;

import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import xtrch.com.hmpmart.Fragment.ChatBeliFragment;
import xtrch.com.hmpmart.Fragment.ChatSemuaFragment;
import xtrch.com.hmpmart.Fragment.ChatJualFragment;

public class AdapterTabMain extends FragmentStatePagerAdapter implements ChatSemuaFragment.OnFragmentInteractionListener, ChatJualFragment.OnFragmentInteractionListener {

    int numTabRehab;

    public AdapterTabMain(FragmentManager fm, int numTabRehab){
        super(fm);
        this.numTabRehab = numTabRehab;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                ChatSemuaFragment semuaFragment = new ChatSemuaFragment();
                return semuaFragment;
            case 1:
                ChatBeliFragment beliFragment = new ChatBeliFragment();
                return beliFragment;
            case 2:
                ChatJualFragment jualFragment = new ChatJualFragment();
                return jualFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numTabRehab;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
