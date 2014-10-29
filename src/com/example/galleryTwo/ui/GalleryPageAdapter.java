package com.example.galleryTwo.ui;

import java.util.List;

import com.example.galleryTwo.bean.MyImageBean;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class GalleryPageAdapter extends FragmentStatePagerAdapter {

	private List<MyImageBean> imageList;
	
	public GalleryPageAdapter(FragmentManager fm, List<MyImageBean>imageList) {
		super(fm);
		this.imageList = imageList;
	}

	@Override
	public Fragment getItem(int pageIndex) {
		return PageFragment.newInstance(imageList.get(pageIndex));
	}

	@Override
	public int getCount() {
		return imageList.size();
	}

}
