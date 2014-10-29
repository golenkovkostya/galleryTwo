package com.example.galleryTwo.ui;

import com.example.galleryTwo.bean.MyImageBean;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.imageBean = getArguments().getParcelable(ARG_IMAGE_BEAN);
		//here start load image
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		return super.onCreateView(inflater, container, savedInstanceState);
	}
}
