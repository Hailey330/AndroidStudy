package com.cos.viewpager;

// FragmentPagerAdapter : 모든 프레그먼트를 메모리에 미리 로딩 시켜두고 소멸시키지 않음
// FragmentStatePagerAdapter : default 3, 자기를 포함한 양 옆만 메모리에 로딩함

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList = new ArrayList<>();
    // 내가 넣는 Fragment를 관리함 - 데이터 set만 해주면 관리는 adapter 담당

    public FragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    // FragmentList에 아이템 추가하는 함수 필요
    public void addFragment(Fragment fragment) {
        fragmentList.add(fragment);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() { // 전체 데이터 수
        return fragmentList.size();
    }
}
