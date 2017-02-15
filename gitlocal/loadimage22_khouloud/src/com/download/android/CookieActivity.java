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

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;



import com.example.loadimage.R;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CookieActivity extends Activity {

	private MenuItem item;
	private String url = "http://192.168.13.129:8888/TestAndroid/CookieServlet";
	private String name = "logo.png";
	ImageView imgView;
	HttpClient client = new DefaultHttpClient();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cookie);
		Button btnUpl = (Button) findViewById(R.id.sendCookie);
		
		btnUpl.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				item.setActionView(R.layout.progress);
				SendHttpRequestTask t = new SendHttpRequestTask();
				
				String[] params = new String[]{url};
				t.execute(params);
			}
		});

	
		
	}
	
	
	

	


	private class SendHttpRequestTask extends AsyncTask<String, Void, Void> {

		
		@Override
		protected Void doInBackground(String... params) {
			String url = params[0];
			
			
			try {
				HttpPost post = new HttpPost(url);
				HttpResponse resp = client.execute(post);
				
				CookieStore store = ((DefaultHttpClient) client).getCookieStore();
				
				List<Cookie> cookies = store.getCookies();
				if (cookies != null) {
					for (Cookie c : cookies) { 
						System.out.println("Name ["+c.getName()+"] - Val ["+c.getValue()+"] - Domain ["+c.getDomain()+"] - Path ["+c.getPath()+"]");
						store.addCookie(c);
					}
				}


				consumeResponse(resp.getEntity().getContent());
				
				HttpContext ctx = new BasicHttpContext();
				ctx.setAttribute(ClientContext.COOKIE_STORE, store);
				
				
				// Post again with cookie 
				HttpPost post1 = new HttpPost(url);
				client.execute(post1);
				HttpResponse resp1 = client.execute(post, ctx);
				consumeResponse(resp1.getEntity().getContent());

			}
			catch(Throwable t) {
				t.printStackTrace();
			}
			
			
			return (Void) null;
		}

		@Override
		protected void onPostExecute(Void param) {
			item.setActionView(null);			
		}
		
		private void consumeResponse(InputStream is) throws Exception {			
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                
            }
            is.close();
		}
		
	}

	
}
