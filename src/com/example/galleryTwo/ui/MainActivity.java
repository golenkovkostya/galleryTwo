package com.example.galleryTwo.ui;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.galleryTwo.Const;
import com.example.galleryTwo.bean.MyImageBean;
import com.example.gallerytwo.R;

public class MainActivity extends FragmentActivity {

	ViewPager vPager;
	GalleryPageAdapter galleryPageAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Intent intent = getIntent();
		List<MyImageBean> imageList = intent.getParcelableArrayListExtra(Const.IMAGE_LIST_NAME);
		
		galleryPageAdapter = new GalleryPageAdapter(getSupportFragmentManager(), imageList);
		
		vPager = (ViewPager)findViewById(R.id.pager);
		
	}
}
