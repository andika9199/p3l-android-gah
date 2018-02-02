package com.example.andika.materialdesign.Tab;

/**
 * Created by Andika on 2/1/2018.
 */

import com.example.andika.materialdesign.Fragment.ChatFragment;
import com.example.andika.materialdesign.Fragment.ExploreFragment;
import com.example.andika.materialdesign.Fragment.FriendFragment;
import com.example.andika.materialdesign.Fragment.HomeFragment;
import com.example.andika.materialdesign.R;

/**
 * Created by Ujang Wahyu on 24/01/2017.
 */


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;


/**
 * Created by Ujang Wahyu on 18/08/2016.
 */

public class MyAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private String[] titles = {"A", "B", "C", "D"};
    int[] icon = new int[]{R.drawable.ic_home_black_48dp, R.drawable.ic_explore_black_48dp, R.drawable.ic_settings_cell_black_48dp, R.drawable.ic_account_circle_black_48dp};
    private int heightIcon;

    public MyAdapter(FragmentManager fm, Context c) {
        super(fm);
        mContext = c;
        double scale = c.getResources().getDisplayMetrics().density;
        heightIcon = (int) (24 * scale + 0.5f);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;

        if (position == 0) {
            frag = new HomeFragment();
        } else if (position == 1) {
            frag = new ExploreFragment();
        } else if (position == 2) {
            frag = new ChatFragment();
        } else if (position == 3) {
            frag = new FriendFragment();
        }

        Bundle b = new Bundle();
        b.putInt("position", position);
        frag.setArguments(b);
        return frag;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    public CharSequence getPageTitle(int position) {
//        Drawable d = mContext.getResources().getDrawable(icon[position]);
//        d.setBounds(0, 0, heightIcon, heightIcon);
//        ImageSpan is = new ImageSpan(d);
//
//        SpannableString sp = new SpannableString(" ");
//        sp.setSpan(is, 0, sp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        SpannableString sp = new SpannableString(titles[position]);
        sp.setSpan(titles[position], 0, sp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return sp;
    }

}
