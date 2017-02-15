package com.example.loadimage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;











import com.iplabel.rummobile.macro.RMCustomTrace;
import com.iplabel.rummobile.provider.RMActivity;
import com.iplabel.rummobile.provider.RumMobileAgent;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

public class Testhttpconnction extends RMActivity {

	HttpClient httpclient;
	HttpGet request;
	HttpResponse response;
	String url;
	ProgressDialog pro;
	TextView result;
	StringBuilder text=null;

	/* Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.httpconnection);
		
		RumMobileAgent.SETSCREENNAME("TAG_HTTPCONNECTION");
		
		String res = RMCustomTrace.RM_START_NAMED_INTERACTION("methodhttp");
		 result = (TextView) findViewById(R.id.tvResult);
		 
			
			url = "http://192.168.13.111/hello_php/";
			// TextView to display result
			
			// Try to connect using Apache HttpClient Library
			try {
				httpclient = new DefaultHttpClient();
				request = new HttpGet(url);
				response = httpclient.execute(request);
			}
			catch (Exception e) {
				// Code to handle exception
			}

			// response code
			try {
				BufferedReader rd = new BufferedReader(new InputStreamReader(
						response.getEntity().getContent()));
				String line = "";
				while ((line = rd.readLine()) != null) {
					// Appending result to textview
					text.append(line);
				}
			} catch (Exception e) {
				// Code to handle exception
			}
			// TODO Auto-generated method stub
			RMCustomTrace.RM_STOP_NAMED_INTERACTION(res);
		}

	
	@Override
	public void onResume()
	{   	
		super.onResume();
		Log.e("::::::::::::::::::::onresume2","resume2");
	}

	@Override
	public void onRestart()
	{   	
		super.onRestart();
		Log.e("::::::::::::::::::::onrestart2","restart2");
	}
	@Override
	public void onStart()
	{   	
		super.onStart();
		Log.e("::::::::::::::::::::onStart2","onStart2");
	}
	@Override
	public void onPause()
	{   	
		super.onPause();
		Log.e("::::::::::::::::::::onPause2","onPause2");
	}
	@Override
	 public void onDestroy()
	 {   	
	       super.onDestroy();
	       Log.e("::::::::::::::::::::onDestroy2","onDestroy2");
	 }
	

	
}