package com.example.activity;

import com.example.layout.R;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class SaveInstanceTest extends Activity {
	private EditText mSaveInstance;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.v("tag", "oncreat----------->");
		setContentView(R.layout.activity_save_instance);
		mSaveInstance = (EditText) findViewById(R.id.save_instance_et);
		if (savedInstanceState != null) {
			String inform = savedInstanceState.getString("save");
			Log.d("tag", "get-------------->");
			mSaveInstance.setText(inform);
		}

		
		
		mSaveInstance.addTextChangedListener(new TextWatcher() {
			
			//此输入字符串
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
				
				Log.d("tag", "on---------->"+s);
			}
			//之前字符串
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				Log.d("tag", "before---------->"+s);
				if (count>4) {
					mSaveInstance.setError("超出长度");//在输入框内显示报错信息
				}
			}
			//之后字符串
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Log.d("tag", "after---------->"+s);
				
			}
		});
		
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		mSaveInstance = (EditText) findViewById(R.id.save_instance_et);
		String massage = mSaveInstance.getText().toString();
		outState.putString("save", massage);
		Log.v("tag", "save----------->");
	}

/*	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
		Log.d("tag", "onRestor--------?>");
	}*/
}
