package com.example.galleryTwo.ui;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewPager;
import android.view.ViewParent;
import android.widget.TextView;

import com.example.galleryTwo.Const;
import com.example.galleryTwo.bean.MyImageBean;
import com.example.galleryTwo.R;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.utils.StorageUtils;

public class MainActivity extends FragmentActivity implements ViewPager.OnPageChangeListener {

	ViewPager vPager;
	GalleryPageAdapter galleryPageAdapter;
	int imageListSize;
	List<MyImageBean> imageList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		File cacheDir = StorageUtils.getCacheDirectory(getApplicationContext());
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
		.diskCache(new UnlimitedDiscCache(cacheDir))
		.diskCacheFileNameGenerator(new Md5FileNameGenerator())
		.diskCacheSize(50 * 1024 * 1024) // 50 Mb
		.tasksProcessingOrder(QueueProcessingType.LIFO)
		.build();
		ImageLoader.getInstance().init(config);
		
		
//		Intent intent = getIntent();
//		if( intent == null || !intent.hasExtra(Const.IMAGE_LIST_NAME)) {
//			finish();
//			return;
//		}
//		
//		List<MyImageBean> imageList = intent.getParcelableArrayListExtra(Const.IMAGE_LIST_NAME);
		
		imageList = new ArrayList<MyImageBean>();
		imageList.add(new MyImageBean("https://lh4.googleusercontent.com/-WIuWgVcU3Qw/URqubRVcj4I/AAAAAAAAAbs/YvbwgGjwdIQ/s1024/Antelope%252520Walls.jpg", "image 1"));
		imageList.add(new MyImageBean("https://lh3.googleusercontent.com/-PyggXXZRykM/URquh-kVvoI/AAAAAAAAAbs/hFtDwhtrHHQ/s1024/Colorado%252520River%252520Sunset.jpg", "image 2"));
		imageList.add(new MyImageBean("https://lh4.googleusercontent.com/-EIBGfnuLtII/URquqVHwaRI/AAAAAAAAAbs/FA4McV2u8VE/s1024/Grand%252520Teton.jpg", "image 3"));
		imageList.add(new MyImageBean("http://tabletpcssource.com/wp-content/uploads/2011/05/android-logo.png", "image 4"));
		imageList.add(new MyImageBean("http://weloveicons.s3.amazonaws.com/icons/100929_applications.png", "image 5"));
		imageList.add(new MyImageBean("http://androidblaze.com/wp-content/uploads/2011/12/tablet-pc-256x256.jpg", "image 6"));
		imageList.add(new MyImageBean("http://thecustomizewindows.com/wp-content/uploads/2011/11/Nicest-Android-Live-Wallpapers.png", "image 7"));
		imageList.add(new MyImageBean("https://lh5.googleusercontent.com/-B1HW-z4zwao/URqvFWYRwUI/AAAAAAAAAbs/8Peli53Bs8I/s1024/The%252520Cave%252520BW.jpg", "image 8"));
		imageList.add(new MyImageBean("https://lh6.googleusercontent.com/-h-ALJt7kSus/URqvIThqYfI/AAAAAAAAAbs/ejiv35olWS8/s1024/Tokyo%252520Heights.jpg", "image 9"));
		imageList.add(new MyImageBean("https://lh5.googleusercontent.com/-kI_QdYx7VlU/URqvLXCB6gI/AAAAAAAAAbs/N31vlZ6u89o/s1024/Yet%252520Another%252520Rockaway%252520Sunset.jpg", "image 10"));
		
		this.imageListSize = imageList.size();
		
		galleryPageAdapter = new GalleryPageAdapter(getSupportFragmentManager(), imageList);
		
		vPager = (ViewPager)findViewById(R.id.pager);
		vPager.setAdapter(galleryPageAdapter);
		vPager.setOnPageChangeListener(this);
		
		this.onPageSelected(0);
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
	}

	@Override
	public void onPageSelected(int positionIndex) {
		TextView titileViewPage = (TextView)findViewById(R.id.titleViewPage);
		titileViewPage.setText(imageList.get(positionIndex).getTitle());
		
		TextView imageCounter = (TextView)findViewById(R.id.imageCounter);
		imageCounter.setText(String.format(getString(R.string.imageCounter), ++positionIndex, imageListSize));
	}
}
