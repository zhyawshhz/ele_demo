package com.example.ele_me.activity;

import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.ele_me.R;
import com.example.ele_me.util.InjectView;
import com.example.ele_me.util.Injector;
import com.example.ele_me.util.User;

public class RegisterPageActivity extends Activity {
	
	private EditText etUser;
	private EditText etPassw;
	private EditText etRePassw;
	private RadioButton rbMale;
	private RadioButton rbfaMale;
	private CheckBox cbRead;
	private CheckBox cbTourist;
	private CheckBox cbPlayGame;
	private Spinner spCity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		init();
	}
	
	private void init(){
		etUser = (EditText)findViewById(R.id.edUser);
		etPassw = (EditText) findViewById(R.id.edPassword);
	    etRePassw = (EditText) findViewById(R.id.edConfirmPassword);
	    rbMale =  (RadioButton) findViewById(R.id.rbMale);
	    rbfaMale =  (RadioButton) findViewById(R.id.rbfaMale);
	    cbRead = (CheckBox) findViewById(R.id.cbRead);
	    cbTourist = (CheckBox) findViewById(R.id.cbTourist);
	    cbPlayGame = (CheckBox) findViewById(R.id.cbPlayGame);
	    spCity = (Spinner) findViewById(R.id.spCity);
	}
	
	public void onclick(View view){
	    switch(view.getId())
	    {
	    	case R.id.btRegister:
	    		String userName =etUser.getText().toString();
	    		if(TextUtils.isEmpty(userName))
	    		{
	    			Toast.makeText(this, "用户名不能为空", 2000).show();
	    			return;
	    		}
	    		String passW = etPassw.getText().toString();
	    		if(TextUtils.isEmpty(passW))
	    		{
	    			etPassw.setError("密码不能为空");
	    			return;
	    		}
	    		String rePassw = etRePassw.getText().toString();
	    		if(TextUtils.isEmpty(rePassw))
	    		{
	    			etRePassw.setError("确认密码不能为空");
	    			return;
	    		}
	    		if(!passW.equals(rePassw))
	    		{
	    			Toast.makeText(this, "两次密码不一致", 2000).show();
	    			return ;
	    		}
	    		char sex ;
	    		if(rbMale.isChecked())
	    		{
	    			sex = rbMale.getText().charAt(0);
	    		}else{
	    			sex = rbfaMale.getText().charAt(0);
	    		}
	    		StringBuffer s = new StringBuffer();
	    		if(cbRead.isChecked())
	    		{
	    			s.append(cbRead.getText().toString()+",");
	    		}
	    		if(cbTourist.isChecked())
	    		{
	    			s.append(cbTourist.getText().toString()+",");
	    		}
	    		if(cbPlayGame.isChecked())
	    		{
	    			s.append(cbPlayGame.getText().toString()+",");
	    		}
	    		String city = spCity.getSelectedItem().toString();
	    		User user = new User(userName,passW,sex,
	    				s.toString().equals("")?"":s.toString().substring(0, s.length()),
	    						city);
	    		//Toast.makeText(this, "用户注册信息："+user.toString(),100000).show();
	    		/*
	    		JsonObjectRequest jr = new JsonObjectRequest(Request.Method.POST, "http://127.0.0.1:5555:/backend/register", null, new Response.Listener<JSONObject>() {
	    			@Override
	    			public void onResponse(JSONObject jsonObject){
	    				Log.e("volley", jsonObject.toString());
	    			}
				}, new ErrorListener(){
					@Override
					public void onErrorResponse(VolleyError error){
						Log.e("volley", "error");
					}
				});
				*/
	    		break;
	    	case R.id.btEixt:
	    		finish();
	    		break;
	    	}
	    }
}
