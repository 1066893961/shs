package com.example.xml;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;


public class MainActivity extends Activity implements OnClickListener {

	// private TextView textView;
	private ImageView imageview;
	private PopupWindow mPopupWindow;
	// 屏幕的width
	private int mScreenWidth;
	// 屏幕的height
	private int mScreenHeight;
	
	private ImageView yunshi_imageview;
	private ImageView title_share_imageview;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yunshi);

		// textView = (TextView) findViewById(R.id.header_center_textview);
		// textView.setText("昵称与性别（3/4）");
		imageview = (ImageView) findViewById(R.id.title_iamge); 
		yunshi_imageview = (ImageView)findViewById(R.id.yunshi_imageview);
		title_share_imageview = (ImageView)findViewById(R.id.title_share_imageview);
		
		
		imageview.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (v.getId() == R.id.title_iamge) {
					getPopupWindowInstance();
					mPopupWindow
							.showAsDropDown(v, -(mScreenWidth / 3 - 20), 30);
				}
			}
		});
		
		yunshi_imageview.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Dialog dialog = new Dialog(MainActivity.this, R.style.CustomDialog);
				dialog.setContentView(R.layout.dialog_scrollview);
				//为获取屏幕宽、高 
				WindowManager m = getWindowManager();  
				Display d = m.getDefaultDisplay();  
				//获得当前窗体
				Window window = dialog.getWindow();
				//重新设置
				WindowManager.LayoutParams lp = window.getAttributes();
				window .setGravity(Gravity.TOP);
				lp.x = 0; // 新位置X坐标
				lp.y = 104; // 新位置Y坐标
				lp.width = d.getWidth();
				lp.alpha = 0.9f;

				// dialog.onWindowAttributesChanged(lp);(当Window的Attributes改变时系统会调用此函数)
				window .setAttributes(lp);
				dialog.show();
				
			}
		});
		
		title_share_imageview.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if (mPopupWindow != null && mPopupWindow.isShowing()) {
					mPopupWindow.dismiss();
					mPopupWindow = null;
				}
				
				Dialog dialog = new Dialog(MainActivity.this,R.style.PauseDialog);
				dialog.setContentView(R.layout.dialog_share);
				dialog.setTitle(R.string.share);
				//为获取屏幕宽、高 
				WindowManager m = getWindowManager();  
				Display d = m.getDefaultDisplay();  
				//获得当前窗体
				Window window = dialog.getWindow();
				//重新设置
				WindowManager.LayoutParams lp = window.getAttributes();
				window .setGravity(Gravity.BOTTOM);
//				lp.x = 50; // 新位置X坐标
//				lp.y = 110; // 新位置Y坐标
				lp.width = (int) (d.getWidth());
				lp.alpha = 0.9f;

				// dialog.onWindowAttributesChanged(lp);(当Window的Attributes改变时系统会调用此函数)
				window .setAttributes(lp);
				dialog.show();
			}
		});
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		// TODO Auto-generated method stub

		if (mPopupWindow != null && mPopupWindow.isShowing()) {

			mPopupWindow.dismiss();

			mPopupWindow = null;
		}

		return super.onTouchEvent(event);

	}

	/*
	 * 获取PopupWindow实例
	 */
	private void getPopupWindowInstance() {
		if (null != mPopupWindow) {
			mPopupWindow.dismiss();
			return;
		} else {
			initPopuptWindow();
		}
	}

	/*
	 * 创建PopupWindow
	 */
	private void initPopuptWindow() {
		LayoutInflater layoutInflater = LayoutInflater.from(this);
		View popupWindow = layoutInflater.inflate(R.layout.yunshi_popup_window,
				null);

		// 获取屏幕和PopupWindow的width和height
		mScreenWidth = getWindowManager().getDefaultDisplay().getWidth();
		mScreenHeight = getWindowManager().getDefaultDisplay().getHeight();

		// 创建一个PopupWindow
		// 参数1：contentView 指定PopupWindow的内容
		// 参数2：width 指定PopupWindow的width
		// 参数3：height 指定PopupWindow的height
		mPopupWindow = new PopupWindow(popupWindow, ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}
}
