package com.download.android;

/*
 * Copyright (C) 2013 Surviving with Android (http://www.survivingwithandroid.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;






import com.example.loadimage.R;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.MenuItem;
import android.widget.ImageView;

public class DownloadActivity extends Activity {

	private MenuItem item;
	private String url = "http://192.168.13.129:8888/TestAndroid/DownloadServlet";
	private String name = "logo.png";
	ImageView imgView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_download);
		
		imgView = (ImageView) findViewById(R.id.imgView1);
		String[] params = new String[] {url, name};
		
		SendHttpRequestTask task = new SendHttpRequestTask();
		task.execute(params);
	}
	
	
	

	

	private class SendHttpRequestTask extends AsyncTask<String, Void, byte[]> {

		
		@Override
		protected byte[] doInBackground(String... params) {
			String url = params[0];
			String name = params[1];
			
			
			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(url);
			List<NameValuePair> paramList = new ArrayList<NameValuePair>();
			paramList.add(new BasicNameValuePair("name", name));
			
			
			
			byte[] data = null;
			
			try {
				post.setEntity(new UrlEncodedFormEntity(paramList)); // We add the Params to the Post request
				HttpResponse resp = client.execute(post);
				InputStream is = resp.getEntity().getContent();
				int contentSize = (int) resp.getEntity().getContentLength();
				System.out.println("Content size ["+contentSize+"]");
				BufferedInputStream bis = new BufferedInputStream(is, 512);
				
				data = new byte[contentSize];
				int bytesRead = 0;
				int offset = 0;
				
				while (bytesRead != -1 && offset < contentSize) {
					bytesRead = bis.read(data, offset, contentSize - offset);
					offset += bytesRead;
				}
				
		
				System.out.println("Data ["+data.length+"]");
				
				
			}
			catch(Throwable t) {
				// Handle error here
				t.printStackTrace();
			}
			
			
			return data;
		}

		@Override
		protected void onPostExecute(byte[] result) {
			Bitmap img = BitmapFactory.decodeByteArray(result, 0, result.length);
			imgView.setImageBitmap(img);
			item.setActionView(null);
			
		}
		
		
		
	}

	
}
