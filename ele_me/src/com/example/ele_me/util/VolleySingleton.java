package com.example.ele_me.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {
	private static VolleySingleton mVSInstance;
	private RequestQueue mRequestQueue;
	private ImageLoader mImageLoader;
	private Context mContext;
	
	public VolleySingleton(Context context){
		this.mContext = context;
		mRequestQueue = getRequestQueue();
		mImageLoader = new ImageLoader(mRequestQueue, new ImageLoader.ImageCache() {
			
			private final LruCache<String, Bitmap> cache = new LruCache<String, Bitmap>(20);
			@Override
			public void putBitmap(String url, Bitmap bitmap) {
				// TODO Auto-generated method stub
				cache.put(url, bitmap);
			}
			
			@Override
			public Bitmap getBitmap(String url) {
				// TODO Auto-generated method stub
				return cache.get(url);
			}
		});
	}
	
	public static synchronized VolleySingleton getVolleySingleton(Context context){
		if (mVSInstance == null){
			mVSInstance = new VolleySingleton(context);
		}
		return mVSInstance;
	}
	
	public RequestQueue getRequestQueue(){
		if (mRequestQueue == null){
			mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
		}
		return mRequestQueue;
	}
	
	public  <T> void addToRequestQueue(Request<T> req){
		getRequestQueue().add(req);
	}
	
	public ImageLoader getImageLoader(){
		return mImageLoader;
	}
}
