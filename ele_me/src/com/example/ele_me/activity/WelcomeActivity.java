package com.example.ele_me.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;

import com.example.ele_me.R;
import com.example.ele_me.util.InjectView;
import com.example.ele_me.util.Injector;

public class WelcomeActivity extends Activity {
	
	private TextView register_btn;
	private TextView login_btn;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.welcome);
		
		register_btn = (TextView)findViewById(R.id.btn_regist);
		login_btn = (TextView)findViewById(R.id.btn_login);
		
		register_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent (WelcomeActivity.this,RegisterPageActivity.class);		
				//Intent intent = new Intent (WelcomeActivity.this,LoginActivity.class);	
				startActivity(intent);			
				finish();
			}
		});
		
		login_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent (WelcomeActivity.this,LoginActivity.class);			
				startActivity(intent);			
				finish();
			}
		});

	}


}
