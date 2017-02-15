package com.example.loadimage;

import java.net.UnknownHostException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class AndroidHTTPRequestsActivity extends Activity {

	private int i=0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainhttp);
		// Creating HTTP client
		HttpClient httpClient = new DefaultHttpClient();
		// Creating HTTP Post
		HttpPost httpPost = new HttpPost("http://stackoverflow.com/questions/18824076/how-to-catch-this-exception-in-android-webview");
		// Url Encoding the POST parameters
		
		try {
			HttpResponse response = httpClient.execute(httpPost);
			Log.d("Http Response:", response.toString());
			if (i == 0) {
				UnknownHostException e = new UnknownHostException();
				e.printStackTrace();
			}
//		} catch (MalformedURLException e) {
//			// writing exception to log
//			e.printStackTrace();
//		} catch (UnknownHostException e) {
//
//			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}
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