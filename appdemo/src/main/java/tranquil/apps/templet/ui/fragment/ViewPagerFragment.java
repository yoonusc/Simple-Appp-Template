package tranquil.apps.templet.ui.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import tranquil.apps.templet.R;
import tranquil.apps.templet.adapter.TabPagerItem;
import tranquil.apps.templet.adapter.ViewPagerAdapter;

public class ViewPagerFragment extends Fragment {
	private List<TabPagerItem> mTabs = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createTabPagerItem();
    }

    private void createTabPagerItem(){
        mTabs.add(new TabPagerItem(getString(R.string.Events), subf.newInstance(getString(R.string.Events))));
        mTabs.add(new TabPagerItem(getString(R.string.paper), paperf.newInstance(getString(R.string.paper))));
        mTabs.add(new TabPagerItem(getString(R.string.quiz),  quiz.newInstance(getString(R.string.quiz))));
        mTabs.add(new TabPagerItem(getString(R.string.computer), cs.newInstance(getString(R.string.computer))));
        mTabs.add(new TabPagerItem(getString(R.string.civil), civil.newInstance(getString(R.string.computer))));
        mTabs.add(new TabPagerItem(getString(R.string.el),el.newInstance(getString(R.string.computer))));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_viewpager, container, false);
        rootView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT ));
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
    	ViewPager mViewPager = (ViewPager) view.findViewById(R.id.viewPager);
    	
    	mViewPager.setOffscreenPageLimit(mTabs.size());
        mViewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager(), mTabs));
        TabLayout mSlidingTabLayout = (TabLayout) view.findViewById(R.id.tabLayout);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mSlidingTabLayout.setElevation(15);
        }
        mSlidingTabLayout.setupWithViewPager(mViewPager);
    }
}