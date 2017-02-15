package com.example.loadimage;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

public class WebViewActivity extends Activity {

	private WebView webView;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview);

		webView = (WebView) findViewById(R.id.webView1);
		webView.loadUrl("http://www.ip-label.co.uk/");
		
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