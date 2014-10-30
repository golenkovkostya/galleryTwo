package com.example.galleryTwo.ui;

import com.example.galleryTwo.R;
import com.example.galleryTwo.bean.MyImageBean;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class PageFragment extends Fragment {

	private static final String ARG_IMAGE_BEAN = "image_bean";

	static PageFragment newInstance(MyImageBean imageBean) {
		PageFragment pageFragment = new PageFragment();
		Bundle bundle = new Bundle();
		bundle.putParcelable(ARG_IMAGE_BEAN, imageBean);
		pageFragment.setArguments(bundle);
		return pageFragment;
	}

	private MyImageBean imageBean;
	DisplayImageOptions options;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.imageBean = getArguments().getParcelable(ARG_IMAGE_BEAN);
		options = new DisplayImageOptions.Builder()
				.resetViewBeforeLoading(true)
				.cacheOnDisk(true)
				.imageScaleType(ImageScaleType.EXACTLY)
				.build();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment, container, false);
		TextView titileViewPage = (TextView) view.findViewById(R.id.titleViewPage);
		titileViewPage.setText(imageBean.getTitle());
		
		ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
		
		ImageLoader.getInstance().displayImage(imageBean.getUrl(), imageView, options);
		
		return view;

	}
}
