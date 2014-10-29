package com.example.galleryTwo.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class MyImageBean implements Parcelable {
	
	private String url;
	private String title;
	
	/**
	 * @param url
	 * @param title
	 */
	public MyImageBean(String url, String title) {
		super();
		this.url = url;
		this.title = title;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int describeContents() {
		return this.hashCode();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(url);
		dest.writeString(title);
	}
	
	private MyImageBean(Parcel parcel) {
		url = parcel.readString();
		title = parcel.readString();
	}
}
