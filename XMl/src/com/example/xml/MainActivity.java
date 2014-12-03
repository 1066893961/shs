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
	// ��Ļ��width
	private int mScreenWidth;
	// ��Ļ��height
	private int mScreenHeight;
	
	private ImageView yunshi_imageview;
	private ImageView title_share_imageview;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yunshi);

		// textView = (TextView) findViewById(R.id.header_center_textview);
		// textView.setText("�ǳ����Ա�3/4��");
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
				//Ϊ��ȡ��Ļ���� 
				WindowManager m = getWindowManager();  
				Display d = m.getDefaultDisplay();  
				//��õ�ǰ����
				Window window = dialog.getWindow();
				//��������
				WindowManager.LayoutParams lp = window.getAttributes();
				window .setGravity(Gravity.TOP);
				lp.x = 0; // ��λ��X����
				lp.y = 104; // ��λ��Y����
				lp.width = d.getWidth();
				lp.alpha = 0.9f;

				// dialog.onWindowAttributesChanged(lp);(��Window��Attributes�ı�ʱϵͳ����ô˺���)
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
				//Ϊ��ȡ��Ļ���� 
				WindowManager m = getWindowManager();  
				Display d = m.getDefaultDisplay();  
				//��õ�ǰ����
				Window window = dialog.getWindow();
				//��������
				WindowManager.LayoutParams lp = window.getAttributes();
				window .setGravity(Gravity.BOTTOM);
//				lp.x = 50; // ��λ��X����
//				lp.y = 110; // ��λ��Y����
				lp.width = (int) (d.getWidth());
				lp.alpha = 0.9f;

				// dialog.onWindowAttributesChanged(lp);(��Window��Attributes�ı�ʱϵͳ����ô˺���)
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
	 * ��ȡPopupWindowʵ��
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
	 * ����PopupWindow
	 */
	private void initPopuptWindow() {
		LayoutInflater layoutInflater = LayoutInflater.from(this);
		View popupWindow = layoutInflater.inflate(R.layout.yunshi_popup_window,
				null);

		// ��ȡ��Ļ��PopupWindow��width��height
		mScreenWidth = getWindowManager().getDefaultDisplay().getWidth();
		mScreenHeight = getWindowManager().getDefaultDisplay().getHeight();

		// ����һ��PopupWindow
		// ����1��contentView ָ��PopupWindow������
		// ����2��width ָ��PopupWindow��width
		// ����3��height ָ��PopupWindow��height
		mPopupWindow = new PopupWindow(popupWindow, ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}
}
