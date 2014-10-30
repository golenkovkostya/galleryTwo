package com.example.galleryTwo.ui;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.galleryTwo.Const;
import com.example.galleryTwo.bean.MyImageBean;
import com.example.galleryTwo.R;

public class MainActivity extends FragmentActivity {

	ViewPager vPager;
	GalleryPageAdapter galleryPageAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		Intent intent = getIntent();
//		if( intent == null || !intent.hasExtra(Const.IMAGE_LIST_NAME)) {
//			finish();
//			return;
//		}
//		
//		List<MyImageBean> imageList = intent.getParcelableArrayListExtra(Const.IMAGE_LIST_NAME);
		
		List<MyImageBean> imageList = new ArrayList<MyImageBean>();
		imageList.add(new MyImageBean(null, "image 1"));
		imageList.add(new MyImageBean(null, "image 2"));
		imageList.add(new MyImageBean(null, "image 3"));
		imageList.add(new MyImageBean(null, "image 4"));
		imageList.add(new MyImageBean(null, "image 5"));
		imageList.add(new MyImageBean(null, "image 6"));
		imageList.add(new MyImageBean(null, "image 7"));
		imageList.add(new MyImageBean(null, "image 8"));
		imageList.add(new MyImageBean(null, "image 9"));
		imageList.add(new MyImageBean(null, "image 10"));
		
		galleryPageAdapter = new GalleryPageAdapter(getSupportFragmentManager(), imageList);
		
		vPager = (ViewPager)findViewById(R.id.pager);
		
		vPager.setAdapter(galleryPageAdapter);
	}
}
