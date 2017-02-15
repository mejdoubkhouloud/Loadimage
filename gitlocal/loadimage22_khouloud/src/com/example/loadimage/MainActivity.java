package com.example.loadimage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.jar.Attributes;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidhive.androidsqlite.Contact;
import com.androidhive.androidsqlite.DatabaseHandler;
import com.iplabel.rummobile.macro.RMCustomTrace;
import com.iplabel.rummobile.provider.RumMobileAgent;
import com.iplabel.rummobile.tracing.measurement.RMCategoryTracing;

public class MainActivity extends Activity implements OnClickListener {
	
	private static String d1;
	ImageView targetImage;
	String onLineImage;
	private Test_SQL test;
	private ActivityManager mActivityManager;
	private EditText editttext;
	private URL url;
	private InputStream is;
	private Bitmap bm;
	private static final String TAG = FileWriteRead.class.getName();
	private static final String FILENAME = "myFile.txt";
	private File f;
	private boolean bool;
	private static final String xmlUrl = "http://dl.dropbox.com/u/7215751/JavaCodeGeeks/AndroidFullAppTutorialPart03/Transformers+2007.xml";
	private static final String USER_AGENT = null;

	private final String TAG1 = getClass().getSimpleName();
	private XMLReader xmlreader;
	private SAXParser parser;   
	private InputSource is1;
	private Canvas canvas;   
	private FileDescriptor fd;  
	private BufferedOutputStream out;
	protected TextView _percentField;

	protected Button _cancelButton;

	protected DownloadMusicfromInternet _initTask;
	private BufferedOutputStream writer;
	private Object fos;
	private WebView webView;
	private WebView webView2;
	ProcessBuilder builder;
	String responseBody, responseBody2, responseBody3, responseBody4;
	HttpClient httpclient;
	HttpGet httpget, httpget2, httpget3, httpget4;
	ResponseHandler<String> responseHandler;
	ResponseHandler<String> responseHandlerl;
	HttpPost post;
	int[] tab; 
	int x=1; 
       
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{                 
		//RumMobileAgent.setOption(RMConstant.RM_CONFIG_PARAMETER_SEND_FREQUENCY,10);
		//RumMobileAgent.setOption(RMConstant.RM_CONFIG_PARAMETER_WEBSERVICE,RMConstant.RM_WebServiceLocal);
	//	RumMobileAgent.setOption(RMConstant.RM_CONFIG_PARAMETER_CONSOLE_LOG_LEVEL,6);
		
		//RumMobileAgent.setOption(RMConstant.RM_CONFIG_PARAMETER_MAX_LIMIT_INTERCEPTION,9);  
		    
//		RumMobileAgent.enableFeatures(RMConstant.RM_TRACE_CRASH_FLAG);
//		RumMobileAgent.enableFeatures(RMConstant.RM_TRACE_CRASH_REPORT_FLAG);
//	    RumMobileAgent.enableFeatures(RMConstant.RM_SEND_CRASH_IMMEDIATELY_FLAG);
	          
		//RumMobileAgent.setOption(RMConstant.RM_CONFIG_PARAMETER_WEBSERVICE, RMConstant.RM_WebServiceLocal);
		//RumMobileAgent.setOption(RMConstant.RM_CONFIG_PARAMETER_MAX_LIMIT_INTERCEPTION,2);	
		//RumMobileAgent.enableFeatures(RMConstant.RM_TRACE_LOCALIZATION_FLAG);
		//RumMobileAgent.enableFeatures(RMConstant.RM_TRACE_CUSTOM_INTERACTIONS_FLAG);
		//RumMobileAgent.enableFeatures(RMConstant.RM_TRACE_AGENT_LOG_FLAG);
		//RumMobileAgent.enableFeatures(RMConstant.RM_TRACE_CRASH_FLAG);
		//RumMobileAgent.enableFeatures(RMConstant.RM_TRACE_CRASH_REPORT_FLAG);		
		//RumMobileAgent.disableFeatures(RMConstant.RM_SEND_CRASH_IMMEDIATELY_FLAG); 
		//RumMobileAgent.setOption(RMConstant.RM_CONFIG_PARAMETER_WEBSERVICE,1);  
		//RumMobileAgent.setOption(RMConstant.RM_CONFIG_PARAMETER_DEBUG_WEBSERVICE,1);		
		//RumMobileAgent.disableFeatures(RMConstant.RM_SEND_ONLY_WITH_WIFI_FLAG);	
		 //RumMobileAgent.enableFeatures(RMConstant.RM_TRACE_CUSTOM_INTERACTIONS_FLAG);   
		//RumMobileAgent.enableFeatures(RMConstant.RM_TRACE_SCREEN_LOAD_INTERACTIONS_FLAG);    
		//RumMobileAgent.enableFeatures(RMConstant.RM_TRACE_SCREEN_DISPALY_INTERACTIONS_FLAG);
		//RumMobileAgent.disableFeatures(RMConstant.RM_TRACE_SCREEN_LOAD_INTERACTIONS_FLAG);
		//RumMobileAgent.disableFeatures(RMConstant.RM_TRACE_SCREEN_DISPALY_INTERACTIONS_FLAG);
		//Dev    
		//RumMobileAgent.setupApplicationWithToken("dca545bc78752ae38bafa1b1925cc5e03025aecd2ret").start(getApplicationContext());
		//Prod 	 	       
	     //RumMobileAgent.setupApplicationWithToken("cc505876cfa2151feca1918401f8cbe304659fe82ret").start(getApplicationContext());
		RumMobileAgent.setupApplicationWithToken("58038ee49c04cb104470df59039b23045d73e4e22ret").start(getApplicationContext());
		//RumMobileAgent.setupApplicationWithToken("dca545bc78752ae38bafa1b1925cc5e03025aecd2ret").start(getApplicationContext());
		  
		super.onCreate(savedInstanceState);  
		setContentView(R.layout.activity_main); 
			  	     
		RumMobileAgent.SETSCREENNAME("TAG_Principale");
		 
 		TextView t1 =(TextView)findViewById(R.id.textView1);
		t1.setPaintFlags(t1.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
		//editttext=(EditText)findViewById(R.id.tt);
  	   
		t1.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event)
			{
				getClientNameDialog();
				return false;
			}
		}); 
		  
		//Double a=5/0.0;
		//Log.e("test crash",""+5/0.0);		
		/*if (!Double.isNaN(a)){
			Log.e("test crash","je suis dans if");
		}else{
			Log.e("test crash","je suis dans else");
		}*/

		/*if(!Double.isInfinite(a)){
			Log.e("test crash","je suis dans if");
		}else{
			Log.e("test crash","je suis dans else");
		}*/
 
		//tab.toString();
		//		RumMobileAgent.enableFeatures(RMConstant.RM_TRACE_ENABLED_FLAG );
		//		RumMobileAgent.disableFeatures(RMConstant.RM_TRACE_ENABLED_FLAG );
		//RumMobileAgent.disableFeatures(RMConstant.RM_TRACE_CRASH_FLAG);
		//RumMobileAgent.disableFeatures(RMConstant. RM_TRACE_ENABLED_FLAG);		
		//RumMobileAgent.disableFeatures(RMConstant.RM_TRACE_MEDIA_INTERACTIONS_FLAG);
		//		RumMobileAgent.disableFeatures(RMConstant. RM_TRACE_CRASH_REPORT_FLAG);
		//		RumMobileAgent.setOption(RMConstant.RM_CONFIG_PARAMETER_SEND_FREQUENCY,40);
		//		RumMobileAgent.setOption(RMConstant.RM_CONFIG_PARAMETER_DEBUG_CONSOLE,1);
		//tab.toString();

		//		methode1();
		//		methode2();

		//	tracker =GoogleAnalytics.getInstance(this).getTracker("UA-61587103-1");
		//		myTracker =  new ExceptionReporter(tracker,GAServiceManager.getInstance(),Thread.getDefaultUncaughtExceptionHandler(),getApplicationContext());

		//		UncaughtExceptionHandler myHandler = new ExceptionReporter(tracker,GAServiceManager.getInstance(),Thread.getDefaultUncaughtExceptionHandler(),getApplicationContext());
		//	    Thread.setDefaultUncaughtExceptionHandler(myHandler);

		//		    EasyTracker.getInstance(this);
		//		    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
		//		    if (uncaughtExceptionHandler instanceof ExceptionReporter) {
		//		        ExceptionReporter exceptionReporter = (ExceptionReporter) uncaughtExceptionHandler;
		//		        exceptionReporter.setExceptionParser(new AnalyticsExceptionParser());
		//		    }

		//		try {

		//			tab.toString();

		//		} catch (Exception e) {

		//		EasyTracker easyTracker = EasyTracker.getInstance(this);
		//		easyTracker.send(MapBuilder.createException(new StandardExceptionParser(this, null).getDescription(Thread.currentThread().getName(),e),false).build());


		//		// Where myParser represents your implementation of ExceptionParser.
		//		MyParser parser = new MyParser(getApplicationContext());
		//		// Where myTracker is an instance of Tracker.
		//		myTracker.setExceptionParser(parser);

		//		EasyTracker easyTracker = EasyTracker.getInstance(this);
		//        easyTracker.send(MapBuilder.createException(new StandardExceptionParser(this, null).getDescription(Thread.currentThread().getName(),e),false)                                               // False indicates a fatal exception
		//      .build()
		//  );


		//		}


		//		NewRelic.withApplicationToken(
		//				"AA32320f8dfef7c4ca3d3be69e79313339245862cc"
		//				).start(this.getApplication());

		

		//postopenconnectionPost();

		//new DownloadMusicfromInternet2().execute();

		// makeGetRequest();

		// loadPicture();

				 

		//		 httpclient = new DefaultHttpClient();
		//		 httpget = new
		//		 HttpGet("http://192.168.13.111/hello_php/name.php?name=Joe");
		//		 httpget2 = new
		//		 HttpGet("http://192.168.13.111/hello_php/name.php?name=Joeeee");
		//		 httpget3 = new
		//		 HttpGet("http://192.168.13.111/hello_php/name.php?name=Joe3");
		//		 httpget4 = new
		//		 HttpGet("http://192.168.13.111/hello_php/name.php?name=Joe4");
		//
		//		 responseHandlerl = new BasicResponseHandler();
		//		 responseHandlerl = new ResponseHandler<String>() {
		//			 public String handleResponse(final HttpResponse response) throws ClientProtocolException,
		//			 IOException {
		//			 int status = response.getStatusLine().getStatusCode();
		//			 Log.e("-----getStatusCode-----", ""+status);			
		//			 if (status >= 200 && status < 300) {
		//			 HttpEntity entity = response.getEntity();
		//			 return entity != null ? EntityUtils.toString(entity) : null;			
		//			 } else {
		//			 throw new ClientProtocolException("Unexpected response status: " +
		//			 status);
		//			 }
		//			 }
		//			 };



		// new AsynckExec2().execute();
		// new AsynckExec3().execute();
		// new AsynckExec4().execute();

		// CloseableHttpClient httpclient = HttpClients.createDefault();
		// try {

		// HttpGet httpget4 = new HttpGet("http://www.linkedin.fr/");

		// System.out.println("Executing request " + httpget.getRequestLine());

		// Create a custom response handler
		// final ResponseHandler<String> responseHandler2 = new
		// BasicResponseHandler() {
		// @Override
		// public String handleResponse(HttpResponse response)
		// throws HttpResponseException, IOException {
		// // TODO Auto-generated method stub
		// return super.handleResponse(response);
		// }
		// };

		/*
		 * ResponseHandler<String> responseHandlerl = new
		 * BasicResponseHandler(){
		 * 
		 * @Override public String handleResponse( final HttpResponse response)
		 * throws ClientProtocolException, IOException { int status =
		 * response.getStatusLine().getStatusCode();
		 * Log.e("-----getStatusCode-----", ""+status);
		 * 
		 * if (status >= 200 && status < 300) { HttpEntity entity =
		 * response.getEntity(); return entity != null ?
		 * EntityUtils.toString(entity) : null; } else { throw new
		 * ClientProtocolException("Unexpected response status: " + status); } }
		 * };
		 */

		// ResponseHandler<String> responseHandler = new
		// ResponseHandler<String>() {
		// public String handleResponse(
		// final HttpResponse response) throws ClientProtocolException,
		// IOException {
		// int status = response.getStatusLine().getStatusCode();
		// Log.e("-----getStatusCode-----", ""+status);
		//
		// if (status >= 200 && status < 300) {
		// HttpEntity entity = response.getEntity();
		// //return entity != null ? EntityUtils.toString(entity) : null;
		// return "ok";
		// } else {
		// throw new ClientProtocolException("Unexpected response status: " +
		// status);
		// }
		// }
		//
		// };
		// try {
		//
		// responseBody2 = httpclient.execute(httpget2, responseHandler);
		//
		// /*responseBody3 = httpclient.execute(httpget3, responseHandler);
		// responseBody4 = httpclient.execute(httpget4, responseHandler);*/
		// } catch (ClientProtocolException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// String deviceName1 = android.os.Build.MODEL;
		// Log.e("------------------------------", deviceName1);

		((Button) findViewById(R.id.loadimage)).setOnClickListener(this);
		((Button) findViewById(R.id.sql)).setOnClickListener(this);
		((Button) findViewById(R.id.execute)).setOnClickListener(this);
		((Button) findViewById(R.id.response)).setOnClickListener(this);
		((Button) findViewById(R.id.xml)).setOnClickListener(this);
		((Button) findViewById(R.id.file)).setOnClickListener(this);
		((Button) findViewById(R.id.Web_view)).setOnClickListener(this);


		// tt = (TextView) findViewById(R.id.tt);
		// assets file descriptor: fails
		// try {
		// bm = BitmapFactory.decodeFileDescriptor(getAssets().openFd(
		// "header.png").getFileDescriptor());
		// } catch (Exception e) {
		// Log.e(TAG, "failed opening asset file desc", e);
		// }

		// .execsql
		// new DownloadMusicfromInternet().execute();

		//tab.toString();
	}

	//	private List<Movie> parseFromUrl() throws XmlPullParserException,
	//	IOException {
	//
	//		List<Movie> moviesList = null;
	//
	//		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
	//		factory.setNamespaceAware(false);
	//		XmlPullParser parser = factory.newPullParser();
	//		String resxml=CustomTrace.RM_TRACE_METHOD_START();
	//		URL url = new URL(xmlUrl);
	//		URLConnection ucon = url.openConnection();
	//		InputStream is = ucon.getInputStream();
	//
	//		parser.setInput(is, null);
	//		parser.nextText();
	//		parser.nextTag();
	//		parser.nextTag();
	//		parser.nextTag();
	//		parser.nextTag();
	//		parser.nextText();
	//		parser.nextTag();
	//		moviesList = parseMovies(parser);
	//	CustomTrace.RM_TRACE_METHOD_STOP(resxml);
	//		return moviesList;
	//
	//	}

	private List<Movie> parseMovies(XmlPullParser parser)
			throws XmlPullParserException, IOException {

		List<Movie> moviesList = new LinkedList<Movie>();

		while (parser.nextTag() == XmlPullParser.START_TAG) {
			Log.d(TAG, "parsing movie");
			Movie movie = parseMovie(parser);
			moviesList.add(movie);
		}
		return moviesList;
	}

	private Movie parseMovie(XmlPullParser parser)
			throws XmlPullParserException, IOException {

		Movie movie = new Movie();
		Log.d(TAG, "parseMovie tag " + parser.getName());

		while (parser.nextTag() == XmlPullParser.START_TAG) {

			if (parser.getName().equals("name")) {
				movie.name = parser.nextText();
			} else if (parser.getName().equals("score")) {
				movie.score = parser.nextText();
			} else if (parser.getName().equals("images")) {
				Image image = parseImage(parser);
				movie.imagesList = new ArrayList<Image>();
				movie.imagesList.add(image);
			} else if (parser.getName().equals("version")) {
				movie.version = parser.nextText();
			} else {
				parser.nextText();
			}

		}

		return movie;
	}

	private Image parseImage(XmlPullParser parser)
			throws XmlPullParserException, IOException {
		Image image = new Image();
		Log.d(TAG, "parseImage tag " + parser.getName());

		while (parser.nextTag() == XmlPullParser.START_TAG) {
			if (parser.getName().equals("image")) {
				image.type = parser.getAttributeValue(null, "type");
				image.url = parser.getAttributeValue(null, "url");
				image.size = parser.getAttributeValue(null, "size");
				image.width = Integer.parseInt(parser.getAttributeValue(null,
						"width"));
				image.height = Integer.parseInt(parser.getAttributeValue(null,
						"height"));
			}
			parser.next();
		}
		return image;
	}

	private List<String> readFile(String filename) throws Exception {
		//String key = RMCustomTrace.RM_TRACE_METHOD_START("XML");
		//String key = RMCustomTrace.RM_START_NAMED_INTERACTION("tag_code1");
	//	String key = RMCustomTrace.RM_TRACE_METHOD_START();
		String line = null;
		List<String> records = new ArrayList<String>();
		// wrap a BufferedReader around FileReader
		BufferedReader bufferedReader = new BufferedReader(new FileReader(
				filename));
		while ((line = bufferedReader.readLine()) != null) {
			// records.add(line);
			bufferedReader.read();
		}
		bufferedReader.close();
		//RMCustomTrace.RM_TRACE_METHOD_STOP(key);
		//RMCustomTrace.RM_STOP_NAMED_INTERACTION(key);
	//	RMCustomTrace.RM_TRACE_METHOD_STOP(key);
		return records;
	}

	public void read_openfileOuput(String filename) {
		try {
			getApplicationContext().openFileOutput(filename,
					Context.MODE_PRIVATE);
		} catch (Exception ex) {
		}
	}

	public void decodeByteArray() {
		//String key = RMCustomTrace.RM_TRACE_METHOD_START();
		BufferedInputStream buf;
		try {
			URL url = new URL(
					"http://feelings-imagetsong.e-monsite.com/medias/album/paysage-08.jpg");
			URLConnection conn = url.openConnection();
			InputStream is = conn.getInputStream();
			buf = new BufferedInputStream(is);
			byte[] bMapArray = new byte[buf.available()];
			buf.read(bMapArray);
			Bitmap bMap = BitmapFactory.decodeByteArray(bMapArray, 0,
					bMapArray.length);
			((ImageView) findViewById(R.id.picture)).setImageBitmap(bMap);
			if (is != null) {
				is.close();
			}
			if (buf != null) {
				buf.close();
			}
		} catch (Exception e) {
			Log.e("Error reading file", e.toString());
		}
		//RMCustomTrace.RM_TRACE_METHOD_STOP(key);
	}

	public Bitmap readBitmap(Uri selectedImage) {

		Bitmap bm = null;

		BitmapFactory.Options options = new BitmapFactory.Options();

		options.inSampleSize = 5;

		AssetFileDescriptor fileDescriptor = null;

		try {
			fileDescriptor = this.getContentResolver().openAssetFileDescriptor(
					selectedImage, "r");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				bm = BitmapFactory.decodeFileDescriptor(
						fileDescriptor.getFileDescriptor(), null, options);
				fileDescriptor.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return bm;

	}

	public Bitmap loadPicture(String urlImage) {

		Bitmap picture = null;
		InputStream is = null;
		BufferedInputStream bis = null;
		try {
			URL url = new URL(urlImage);
			URLConnection conn = url.openConnection();
			//			conn.setDoOutput(true);
			//			conn.setRequestProperty("q", "allah");
			//			conn.setRequestProperty("b", "allah");
			//			conn.setRequestProperty("a", "allah");
			is = conn.getInputStream();
			bis = new BufferedInputStream(is);
			picture = BitmapFactory.decodeStream(bis);

		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		return picture;

	}

	public String loadPicture() {

		Bitmap picture = null;
		InputStream is = null;
		BufferedInputStream bis = null;
		StringBuilder out = new StringBuilder();
		try {
			URL url = new URL(
					"http://192.168.13.111/hello_php/name.php?name=Joe");
			URLConnection conn = url.openConnection();

			is = conn.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(is));
			out = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				out.append(line);
			}
			reader.close();

		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		return out.toString();
	}

	class DownloadMusicfromInternet2 extends AsyncTask<String, String, String> {

		private Object bitmap;
		private URLConnection conn;
		private InputStream is;
		// Show Progress bar before downloading Music
		Date debut;
		Date fin;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

		@Override
		protected void onPreExecute() {
			debut= new Date();

			Log.e("Debut---pre---",  sdf.format(new Date()));
			super.onPreExecute();
		}

		// Download Music File from Internet
		@Override
		protected String doInBackground(String... f_url) {

			//String res = RMCustomTrace.RM_START_NAMED_INTERACTION("method1");

			//String d1= RMCustomTrace.RM_TRACE_METHOD_START(RMConstant.RM_InteractionTypeJson);

		//	RMCustomTrace.RM_STOP_NAMED_INTERACTION(res);
			//			try {
			//			} catch (Exception e) {
			//				Log.e("Error: ", e.getMessage());
			//			}
			//RMCustomTrace.RM_TRACE_METHOD_STOP(d1);

			/*String d1= RMCustomTrace.RM_TRACE_METHOD_START("NewCategory");
			RMCustomTrace.RM_TRACE_METHOD_STOP(d1);*/
			return null;

		}

		// While Downloading Music File
		protected void onProgressUpdate(String... progress) {
			// Set progress percentage
			Log.e("Waiiiitttttt", "Waiiiitttttt");
		}

		// Once Music File is downloaded
		@Override
		protected void onPostExecute(String file_url) {

			Log.e("Debut---post---", sdf.format(new Date()));

			//			((ImageView) findViewById(R.id.picture))
			//					.setImageBitmap(loadPicture("http://islam.ru/en/sites/default/files/img/story/2013/04/allah1.jpg"));
			//
			decodeByteArray();
			//			 bitmap = BitmapFactory.decodeResource(getApplicationContext()
			//			.getResources(), R.drawable.header);

			// URL url;
			// try {
			// url = new URL(
			// "http://islam.ru/en/sites/default/files/img/story/2013/04/allah1.jpg");
			// try {
			// conn = url.openConnection();
			// } catch (IOException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			//
			// try {
			// is = conn.getInputStream();
			// } catch (IOException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			// testSize(is);
			// } catch (MalformedURLException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }

		}

	}

	private Boolean testSize(InputStream inputStream) {
		BitmapFactory.Options Bitmp_Options = new BitmapFactory.Options();
		Bitmp_Options.inJustDecodeBounds = true;

		try {
			inputStream.mark(inputStream.available());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BitmapFactory.decodeResourceStream(getResources(), new TypedValue(),
				inputStream, new Rect(), Bitmp_Options);

		try {
			inputStream.reset();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Bitmp_Options.inJustDecodeBounds = false;
		return false;
	}

	public void append() {
		CharSequence csq = "Hello World!";
		Writer writer = new PrintWriter(System.out);
		try {
			// append a sequence and change line
			writer.append("This is an example\n");
			// flush the writer
			writer.flush();
			// append a new sequence
			writer.append(csq);
			// flush the writer to see the result
			writer.flush();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void openfileinput() {
		try {
			FileInputStream fis = getApplicationContext().openFileInput(
					"file:///android_asset/text/text.txt");
			Log.e("test input", "" + fis);
		} catch (Exception ex) {

		}
	}
      
	@Override
	public void onClick(View v)  {

		switch (v.getId()) {

		case R.id.Web_view:
			
			tab.toString();
						Intent wipl = new Intent(getApplicationContext(),
								WebViewActivity.class);
						startActivity(wipl);
			
			//			webView2 = (WebView) findViewById(R.id.webView2);
			//			webView2.getSettings().setJavaScriptEnabled(true);
			//			webView2.getSettings().setLoadWithOverviewMode(true);
			//			webView2.getSettings().setUseWideViewPort(true);
			//			webView2.getSettings().setDisplayZoomControls(false);
			//			
			//			try{
			//			final String URL_STRING = "http://62.160.52.78/client/Section3_1/?limit_show=1";
			//			HttpClient httpclient2 = new DefaultHttpClient();
			//			HttpPost httppost2 = new HttpPost(URL_STRING);
			//			httppost2.setHeader("Ipln-Auth","Y3ZhY3ZhX0BfQTlLZHFzTUZmbkhsRQ==");  
			//			HttpResponse response2 = httpclient2.execute(httppost2);
			//
			//			String line = "";
			//			StringBuilder contentBuilder = new StringBuilder();
			//			BufferedReader rd = new BufferedReader(new InputStreamReader(response2.getEntity().getContent()));
			//			while ((line = rd.readLine()) != null)
			//			{
			//				contentBuilder.append(line); 
			//			}
			//			String content = contentBuilder.toString();
			//			Log.e("contentcontent",""+content);
			//			
			//			webView2.loadDataWithBaseURL(URL_STRING, content, "css/html", "UTF-8", "");
			//			}catch(Exception e){
			//			Log.e("exeeeee", "exceeee");
			//			}

//			webView = (WebView) findViewById(R.id.webView2);
//			webView.getSettings().setJavaScriptEnabled(true);
//			webView.loadUrl("http://www.google.com");
			/*webView.setWebViewClient(new WebViewClient() {
				@Override
				public boolean shouldOverrideUrlLoading(WebView view, String url) {
					view.loadUrl(url);
					return true;
				}
				@Override
				public void onReceivedError(final WebView view,
						final int errorCode, final String description,
						final String failingUrl) {
					super.onReceivedError(view, errorCode, description,failingUrl);
				}
				@Override
				public void onPageFinished(WebView view, String url) {
					super.onPageFinished(view, url);
				}
			}); */

			// webView.loadUrl("http://www.******ip-label.fr/?test");
			// webView2 = (WebView) findViewById(R.id.webView2);
			// webView2.loadUrl("http://www.ip-label.fr/");
			break;

		case R.id.file:

			String textToSaveString = "Hello Android";

			writeToFile(textToSaveString);

			String textFromFileString = readFromFile();
			// create new file
			f = new File(FILENAME);

			// tries to create new file in the system
			try {
				bool = f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			f.delete();
			if (textToSaveString.equals(textFromFileString))
				Toast.makeText(getApplicationContext(),
						"both string are equal", Toast.LENGTH_SHORT).show();
			else
				Toast.makeText(getApplicationContext(), "there is a problem",
						Toast.LENGTH_SHORT).show();
			try {
				//readFile("file:///android_asset/text/text.txt");
				read_openfileOuput("file:///android_asset/text/text.txt");
				append();
				// openfileinput();

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
  
		case R.id.loadimage:
			  
	 		getJson();
			//new DownloadMusicfromInternet2().execute();
			// tt.setText(loadPicture());
//			String res=RMCustomTrace.RM_TRACE_METHOD_START(RMCategoryTracing.IMAGES.toString());			
		try {
			bm = BitmapFactory.decodeFileDescriptor(getAssets().openFd("header.png").getFileDescriptor());
			}catch (Exception e){
				Log.e("", "failed opening asset file desc", e);
			}
//			RMCustomTrace.RM_TRACE_METHOD_STOP(res);
			break;
 
		case R.id.execute:
 
			//String res0=RMCustomTrace.RM_TRACE_METHOD_START(RMCategoryTracing.HTTPREQUEST.toString());	
			//for(int i =0;i<5;i++){
			/*	try {
					parseFromUrl();
				} catch (XmlPullParserException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}*/
	  		//} 
			//RMCustomTrace.RM_TRACE_METHOD_STOP(res0);
		    String result = null;
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost("http://192.168.13.130:8898/analytics/test_get_post.php");
			HttpResponse response = null;
			//for(int j=0;j<1000;j++){
			try {  
				List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
				urlParameters.add(new BasicNameValuePair("name","khouloud"));
				try
				{
  
					httppost.setEntity(new UrlEncodedFormEntity(urlParameters));

				} catch (UnsupportedEncodingException e){
 
					e.printStackTrace();
				}
				response = httpclient.execute(httppost);
				HttpEntity entity = response.getEntity();
				String sentHttp = ((HttpPost) httppost).getEntity()
						.getContentLength() + "";
				
				if (entity != null)
				{
					InputStream inputstream = entity.getContent();
					BufferedReader bufferedreader = new BufferedReader(
							new InputStreamReader(inputstream));
					StringBuilder stringbuilder = new StringBuilder();
					String currentline = null;
					while ((currentline = bufferedreader.readLine()) != null) {
						stringbuilder.append(currentline + "\n");
					} 
					result = stringbuilder.toString();
					inputstream.close();
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}
			//}
			// makeGetRequest();
			break;

		case R.id.sql:
			
			String resxml=RMCustomTrace.RM_TRACE_METHOD_START("DB");
			DatabaseHandler db = new DatabaseHandler(MainActivity.this);
			RMCustomTrace.RM_TRACE_METHOD_STOP(resxml);
			//String res1=RMCustomTrace.RM_TRACE_METHOD_START(RMCategoryTracing.DATABASE.toString());
			//db.addContact(new Contact("Ravi", "9100000000"));		  

			//MethodBefore();
			//valueBefore = System.currentTimeMillis();
			//db.addContact(new Contact("Ravi", "9100000000"));
			//MethodAfter();
			//RMCustomTrace.RM_TRACE_METHOD_STOP(res1);

			//String res1=RMCustomTrace.RM_TRACE_METHOD_START(RMCategoryTracing.DATABASE.toString());
			//int a = 0;
			//RMCustomTrace.RM_TRACE_METHOD_STOP(res1);

			/*String result=RMCustomTrace.RM_TRACE_METHOD_START(null);
			RMCustomTrace.RM_TRACE_METHOD_STOP(result);
   
			String result0=RMCustomTrace.RM_TRACE_METHOD_START(""); 
			RMCustomTrace.RM_TRACE_METHOD_STOP(result0);*/
            
			//			String result2=RMCustomTrace.RM_START_NAMED_INTERACTION(null);
			//			RMCustomTrace.RM_STOP_NAMED_INTERACTION(result2);
			//			
			//			String result3=RMCustomTrace.RM_START_NAMED_INTERACTION("");
			//			RMCustomTrace.RM_STOP_NAMED_INTERACTION(result3);
       
			//String res2=RMCustomTrace.RM_TRACE_METHOD_START();
			//db.addContact(new Contact("Ravi", "9100000000"));
			//RMCustomTrace.RM_TRACE_METHOD_STOP(res2);
  
			//Log.e("a4",Long.toString(System.nanoTime())+"-"+this.dateFormat(System.currentTimeMillis()));
			//long dateIn = System.currentTimeMillis();
			//Log.e("Insert: ", "Inserting .."+dateIn);²+
   
			//Log.e("start ", RMSystemMeasurement.dateFormat());  
			//Log.e("start ", dateFormat(System.currentTimeMillis()));
  
			//String res3=RMCustomTrace.RM_START_NAMED_INTERACTION("khouloud");
	  		
			for(int i=0 ;i<200 ;i++)
			{
				db.addContact( new Contact("Ravi", "9100000000"));
			}
			
			//RMCustomTrace.RM_STOP_NAMED_INTERACTION(res3);
		  	//Log.e("stop ", dateFormat(System.currentTimeMillis()));
			//Log.e("stop ", RMSystemMeasurement.dateFormat(System.currentTimeMillis()));	


			//				db.addContact(new Contact("Srinivas", "9199999999"));
			//				db.addContact(new Contact("Tommy", "9522222222"));  
			//				db.addContact(new Contact("Karthik", "9533333333"));
			//				db.addContact(new Contact("Srinivas", "9199999999"));
			//				db.addContact(new Contact("Tommy", "9522222222"));  
			//				db.addContact(new Contact("Karthik", "9533333333"));
			//				db.addContact(new Contact("Srinivas", "9199999999"));
			//				db.addContact(new Contact("Tommy", "9522222222"));  
			//				db.addContact(new Contact("Karthik", "9533333333"));
			//				db.addContact(new Contact("Srinivas", "9199999999"));
			//				db.addContact(new Contact("Tommy", "9522222222"));  
			//				db.addContact(new Contact("Karthik", "9533333333"));
			//				db.addContact(new Contact("Srinivas", "9199999999"));
			//				db.addContact(new Contact("Tommy", "9522222222"));  
			//				db.addContact(new Contact("Karthik", "9533333333"));
			//				db.addContact(new Contact("Srinivas", "9199999999"));
			//				db.addContact(new Contact("Tommy", "9522222222"));  
			//				db.addContact(new Contact("Karthik", "9533333333"));
			//				db.addContact(new Contact("Srinivas", "9199999999"));
			//				db.addContact(new Contact("Tommy", "9522222222"));  
			//				db.addContact(new Contact("Karthik", "9533333333"));
			//				db.addContact(new Contact("Srinivas", "9199999999"));
			//				db.addContact(new Contact("Tommy", "9522222222"));  
			//				db.addContact(new Contact("Karthik", "9533333333"));
			//				db.addContact(new Contact("Srinivas", "9199999999"));  
			//				db.addContact(new Contact("Tommy", "9522222222"));  
			//				db.addContact(new Contact("Karthik", "9533333333"));
			//				db.addContact(new Contact("Srinivas", "9199999999"));
			//				db.addContact(new Contact("Tommy", "9522222222"));  
			//				db.addContact(new Contact("Karthik", "9533333333"));

			//	}
			//long dateIn1 = System.currentTimeMillis()- dateIn;
			//Log.e("Reading befor APM: ", "Reading all contacts.." + dateIn1);
			/*db.updateContact(new Contact("khouloud", "9100000000"));
			db.deleteContact(c);
			 */

			//String res=RMCustomTrace.RM_TRACE_METHOD_START(RMCategoryTracing.DATABASE.toString());
			//			db.getAllContacts();
			//RMCustomTrace.RM_TRACE_METHOD_STOP(res);

			break;

		case R.id.response:

			Intent i = new Intent(getApplicationContext(),
					Testhttpconnction.class);
			startActivity(i);

			break;

		case R.id.xml:

			SAXParserFactory factory = SAXParserFactory.newInstance();
			try {

				InputStream xmlInput = getAssets().open("data.xml");
				SAXParser saxParser = factory.newSAXParser();

				DefaultHandler handler = new SaxHandler();
				saxParser.parse(xmlInput, handler);

			} catch (Throwable err) {
				err.printStackTrace();
			}

			/*
			 * AssetManager assetManager = getAssets(); try { is =
			 * assetManager.open("data.xml"); } catch (IOException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); } XmlPullParser
			 * parser = Xml.newPullParser(); try {
			 * parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES,
			 * false); parser.setInput(new InputStreamReader(is)); try {
			 * //parser.nextTag(); //parser.nextText(); parser.nextToken(); }
			 * catch (IOException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } } catch (XmlPullParserException e) { //
			 * TODO Auto-generated catch block e.printStackTrace(); }
			 */

			//xmlfile();

			// StringBuilder builder = new StringBuilder();
			//
			// try {
			//
			// try {
			// url = new URL(
			// "http://gdata.youtube.com/feeds/api/standardfeeds/top_rated");
			//
			// } catch (MalformedURLException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			// XmlPullParserFactory factory1;
			//
			// factory1 = XmlPullParserFactory.newInstance();
			//
			// factory1.setNamespaceAware(true);
			// XmlPullParser xpp = factory1.newPullParser();
			// xpp.setInput(getInputStream(url), "UTF_8");
			// int eventType = xpp.getEventType();
			// while (eventType != XmlPullParser.END_DOCUMENT) {
			// // Looking for a start tag
			// if (eventType == XmlPullParser.START_TAG) {
			// // We look for "title" tag in XML response
			// if (xpp.getName().equalsIgnoreCase("title")) {
			// // Once we found the "title" tag, add the text it
			// // contains to our builder
			// try {
			// builder.append(xpp.nextText() + "\n");
			// } catch (IOException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			// }
			// }
			//
			// try {
			// eventType = xpp.next();
			// } catch (IOException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			// }
			// } catch (XmlPullParserException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }

			/*Intent i1 = new Intent(getApplicationContext(),
								MainActivityxml.class);
						startActivity(i1);*/
			/*Intent i1 = new Intent(getApplicationContext(),
					JSONActivity.class);
			startActivity(i1);*/

			break;
		default:
			break;
		}
	}

	public static String dateFormat(Long realStartTime)
	{
		String date="";
		try
		{
			Date currentDate = new Date(realStartTime);
			DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			dateformat.setTimeZone(TimeZone.getTimeZone("GMT"));
			date= dateformat.format(currentDate);	
		}
		catch(Exception e)
		{
			//RMLogRumMobile.RMException(e);
		}
		return date;
	}

	public InputStream getInputStream(URL url) {
		try {
			return url.openConnection().getInputStream();
		}catch (IOException e) {
			return null;
		}
	}

	private void makeGetRequest() {

		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(
				"http://www.google.com/search?q=developer");
		HttpResponse response;
		try {
			response = client.execute(request);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onBackPressed() {

		super.onBackPressed();

	}

	class Test_SQL {

		public void ins() {

		}

		public Test_SQL() {
			super();

			// TODO Auto-generated constructor stub
		}

		public void main(String[] args) {

		}
	}

	// Async Task Class
	class DownloadMusicfromInternet extends AsyncTask<String, String, String> {

		private static final String SAMPLE_TABLE_NAME = "khouloud";

		// Show Progress bar before downloading Music
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			// Shows Progress Bar Dialog and then call doInBackground method

		}

		// Download Music File from Internet
		@Override
		protected String doInBackground(String... f_url) {
			try {
			} catch (Exception e) {
				Log.e("Error: ", e.getMessage());
			}

			Log.e("-------Befor runing khouloud1------------------",
					"-------Befor runing khouloud1------------------");
			Log.e("-------after runing khouloud1------------------",
					"-------after runing khouloud1------------------");
			return null;
		}

		// While Downloading Music File
		protected void onProgressUpdate(String... progress) {
			// Set progress percentage
			Log.e("-------Befor runing khouloud1------------------",
					"-------Befor runing khouloud1------------------");
		}

		// Once Music File is downloaded
		@Override
		protected void onPostExecute(String file_url) {
			// Dismiss the dialog after the Music file was downloaded
			DatabaseHandler db = new DatabaseHandler(getApplicationContext());
			try {
				SQLiteDatabase sq = db.getWritableDatabase();

				db.onCreate(sq);

				sq.beginTransaction();
				sq.execSQL("CREATE TABLE " + SAMPLE_TABLE_NAME
						+ " (LastName VARCHAR, FirstName VARCHAR,"
						+ " Country VARCHAR, Age INT(3));");
				sq.setTransactionSuccessful();
				sq.endTransaction();
				sq.close();

				// Inserting Contacts
				// Log.d("Insert: ", "Inserting ..");
				// Contact a = new Contact("Ravi", "91111111000");
				// db.addContact(a);
				// db.addContact(new Contact("Srinivas", "9199999999"));
				// db.addContact(new Contact("Tommy", "95200002222"));
				// db.addContact(new Contact("Karthik", "9533333333"));
				// db.getAllContacts();

				Toast.makeText(getApplicationContext(),
						"Download complete, playing Music", Toast.LENGTH_LONG)
						.show();

				// db.deleteContact(a);
				// db.updateContact(a);

				// Play the music
			} catch (android.database.sqlite.SQLiteException e) {
				e.printStackTrace();
			}

		}
	}

	public class MyAsyncTask extends AsyncTask<Object, Integer, Void> {

		@Override
		protected Void doInBackground(Object... params) {
			Log.d("MyAsyncTask", "doInBackground");
			publishProgress(1);
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			Log.d("MyAsyncTask", "onPostExecute");
			super.onPostExecute(result);
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			Log.d("MyAsyncTask", "onProgressUpdate");
			super.onProgressUpdate(values);
		}
	}

	public class testrecuperationinfo {

		public void methodetest() {
			Log.e("methode******", "methode******----------------");
		}

	}

	public class testrecuperationinfossssss {

		public void med() {

			testrecuperationinfossssssuuuuuuuuuuu u = new testrecuperationinfossssssuuuuuuuuuuu();
			u.methodetestinfossssss();
		}
	}

	public class testrecuperationinfossssssuuuuuuuuuuu {

		public void methodetestinfossssss() {
			Log.e("testrecuperationinfossssssuuuuuuuuuuu******",
					"testrecuperationinfossssssuuuuuuuuuuu******----------------");
		}

	}

	public static void getJson() {
		//		String res = CustomTrace.RM_START_NAMED_INTERACTION("method1");
		//String d=RMCustomTrace.RM_TRACE_METHOD_START();

		JSONObject student1 = new JSONObject();
		try {
			student1.put("id", "3");
			student1.put("name", "NAME OF STUDENT");
			student1.put("year", "3rd");
			student1.put("curriculum", "Arts");
			student1.put("birthday", "5/5/1993");

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JSONObject student2 = new JSONObject();
		try {
			student2.put("id", "2");
			student2.put("name", "NAME OF STUDENT2");
			student2.put("year", "4rd");
			student2.put("curriculum", "scicence");
			student2.put("birthday", "5/5/1993");

		} catch (JSONException e) {
			e.printStackTrace();
		}
		JSONArray jsonArray = new JSONArray();
		jsonArray.put(student1);
		jsonArray.put(student2);
		JSONObject studentsObj = new JSONObject();
		try {
			studentsObj.put("Students", jsonArray);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String jsonStr = studentsObj.toString();

		//		CustomTrace.RM_STOP_NAMED_INTERACTION(res);
		//RMCustomTrace. RM_TRACE_METHOD_STOP(d);  

		System.out.println("jsonString: " + jsonStr);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.e("ondestroy", "ondestroy");
	}

	@Override
	public void onPause() {
		super.onPause();
		Log.e("onPause", "onPause");
	}

	public void onStop() {
		super.onStop();
		Log.e("onStop", "onStop");
		//easyTracker.activityStop(this);  // Add this method.
	}
	
	//
	//	public void onRestart() {
	//		super.onRestart();
	//		Log.e("onRestart", "onRestart");
	//	}
	//
	//	public void onResume() {
	//		super.onResume();
	//		Log.e("onResume", "onResume");
	//	}

	private boolean isPidRunning(int pid) {
		if (mActivityManager == null)
			mActivityManager = (ActivityManager) getApplicationContext()
			.getSystemService(Context.ACTIVITY_SERVICE);
		List<RunningAppProcessInfo> l = mActivityManager
				.getRunningAppProcesses();
		Iterator<RunningAppProcessInfo> i = l.iterator();
		RunningAppProcessInfo info;
		while (i.hasNext()) {
			info = i.next();
			if (info.pid == pid)
				return true;
		}
		return false;
	}

	public void xmlfile() {
		try {
			URL url = new URL(
					"http://www.androidpeople.com/wp-content/uploads/2010/06/example.xml");
			BufferedInputStream bis = new BufferedInputStream(url.openStream());
			byte[] buffer = new byte[1024];
			StringBuilder sb = new StringBuilder();
			int bytesRead = 0;
			while ((bytesRead = bis.read(buffer)) > 0) {
				String text = new String(buffer, 0, bytesRead);
				sb.append(text);
			}
			bis.close();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public class SaxHandler extends DefaultHandler {

		public void startDocument() throws SAXException {
		}

		public void endDocument() throws SAXException {
		}

		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {

		}

		public void endElement(String uri, String localName, String qName)
				throws SAXException {
		}

		public void characters(char ch[], int start, int length)
				throws SAXException {
		}

		public void ignorableWhitespace(char ch[], int start, int length)
				throws SAXException {
		}

	}

	private void writeToFile(String data) {
		try {
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
					openFileOutput(FILENAME, Context.MODE_PRIVATE));
			outputStreamWriter.write(data);
			outputStreamWriter.close();
		} catch (IOException e) {
			Log.e(TAG, "File write failed: " + e.toString());
		}
	}

	private String readFromFile() {

		String ret = "";
		try {
			InputStream inputStream = openFileInput(FILENAME);
			if (inputStream != null) {
				InputStreamReader inputStreamReader = new InputStreamReader(
						inputStream);
				BufferedReader bufferedReader = new BufferedReader(
						inputStreamReader);
				String receiveString = "";
				StringBuilder stringBuilder = new StringBuilder();
				Log.e("test intercept read", "" + bufferedReader.read());
				while ((receiveString = bufferedReader.readLine()) != null) {
					stringBuilder.append(receiveString);
				}

				inputStream.close();
				ret = stringBuilder.toString();
			}
		} catch (FileNotFoundException e) {
			Log.e(TAG, "File not found: " + e.toString());
		} catch (IOException e) {
			Log.e(TAG, "Can not read file: " + e.toString());
		}

		return ret;
	}

	public class Image {

		public String type;
		public String url;
		public String size;
		public int width;
		public int height;

	}

	public class Movie {

		public String score;
		public String popularity;
		public boolean translated;
		public boolean adult;
		public String language;
		public String originalName;
		public String name;
		public String type;
		public String id;
		public String imdbId;
		public String url;
		public String votes;
		public String rating;
		public String certification;
		public String overview;
		public String released;
		public String version;
		public String lastModifiedAt;
		public ArrayList<Image> imagesList;

	}

	protected class InitTask extends AsyncTask<Context, Integer, String> {

		// -- run intensive processes here
		// -- notice that the datatype of the first param in the class
		// definition matches the param passed to this
		// method
		// -- and that the datatype of the last param in the class definition
		// matches the return type of this method
		@Override
		protected String doInBackground(Context... params) {
			// -- on every iteration
			// -- runs a while loop that causes the thread to sleep for 50
			// milliseconds
			// -- publishes the progress - calls the onProgressUpdate handler
			// defined below
			// -- and increments the counter variable i by one
			int i = 0;
			while (i <= 50) {
				try {
					Thread.sleep(500);
					publishProgress(i);
					i++;
				} catch (Exception e) {
					Log.i("makemachine", e.getMessage());
				}
			}
			return "COMPLETE!";
		}

		// -- gets called just before thread begins
		@Override
		protected void onPreExecute() {
			Log.i("makemachine", "onPreExecute()");
			super.onPreExecute();
		}

		// -- called from the publish progress
		// -- notice that the datatype of the second param gets passed to this
		// method
		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
			Log.i("makemachine",
					"onProgressUpdate(): " + String.valueOf(values[0]));

		}

		// -- called if the cancel button is pressed
		@Override
		protected void onCancelled() {
			super.onCancelled();
			Log.i("makemachine", "onCancelled()");
			_percentField.setText("Cancelled!");
			_percentField.setTextColor(0xFFFF0000);
		}

		// -- called as soon as doInBackground method completes
		// -- notice that the third param gets passed to this method
		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			Log.i("makemachine", "onPostExecute(): " + result);
			_percentField.setText(result);
			_percentField.setTextColor(0xFF69adea);
			_cancelButton.setVisibility(View.INVISIBLE);
		}
	}

	public static byte[] compress(String string) throws IOException {
		ByteArrayOutputStream os = new ByteArrayOutputStream(string.length());
		GZIPOutputStream gos = new GZIPOutputStream(os);
		gos.write(string.getBytes());
		gos.close();
		byte[] compressed = os.toByteArray();
		os.close();
		return compressed;
	}

	public static byte[] compress3(String text) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			OutputStream out = new DeflaterOutputStream(baos);
			out.write(text.getBytes("UTF-8"));
			out.close();
		} catch (IOException e) {
			throw new AssertionError(e);
		}
		return baos.toByteArray();
	}

	public static String decompress(byte[] compressed) throws IOException {
		final int BUFFER_SIZE = 32;
		ByteArrayInputStream is = new ByteArrayInputStream(compressed);
		GZIPInputStream gis = new GZIPInputStream(is, BUFFER_SIZE);
		StringBuilder string = new StringBuilder();
		byte[] data = new byte[BUFFER_SIZE];
		int bytesRead;
		while ((bytesRead = gis.read(data)) != -1) {
			string.append(new String(data, 0, bytesRead));
		}
		gis.close();
		is.close();
		return string.toString();
	}

	private static String compress4(String str) {
		String str1 = null;
		ByteArrayOutputStream bos = null;
		try {
			bos = new ByteArrayOutputStream();
			BufferedOutputStream dest = null;

			byte b[] = str.getBytes();
			GZIPOutputStream gz = new GZIPOutputStream(bos, b.length);
			gz.write(b, 0, b.length);
			bos.close();
			gz.close();

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		byte b1[] = bos.toByteArray();
		return new String(b1);
	}

	public static String compress5(String str) throws IOException {
		if (str == null || str.length() == 0) {
			return str;
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(out);
		gzip.write(str.getBytes());
		gzip.close();
		return out.toString("ISO-8859-1");
	}

	class AsynckExec1 extends AsyncTask<String, String, String> {

		private Object content;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();

		}

		// Download Music File from Internet
		@Override
		protected String doInBackground(String... f_url) {
			String content;
			HttpClient client = new DefaultHttpClient();
			HttpGet get = new HttpGet("http://www.google.com");
			BasicResponseHandler response = new BasicResponseHandler();
			try {
				content = client.execute(get,response);

			} catch (ClientProtocolException e) {

				e.printStackTrace();

				content = null;

			} catch (IOException e) {

				e.printStackTrace();

				content = null;

			}
			return null;
		}

		// While Downloading Music File
		protected void onProgressUpdate(String... progress) {
			// Set progress percentage
			Log.e("Waiiiitttttt", "Waiiiitttttt Exec1");
		}

		// Once Music File is downloaded
		@Override
		protected void onPostExecute(String file_url) {
			/*String url = "http://192.168.13.111/hello_php/name.php";
			post = new HttpPost(url);
			List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
			urlParameters.add(new BasicNameValuePair("n", ""));
			try {
				post.setEntity(new UrlEncodedFormEntity(urlParameters));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			try {
				responseBody = httpclient.execute(post, responseHandlerl);

			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}

	}

	class AsynckExec2 extends AsyncTask<String, String, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();

		}

		// Download Music File from Internet
		@Override
		protected String doInBackground(String... f_url) {
			try {

			} catch (Exception e) {
				Log.e("Error: ", e.getMessage());
			}
			return null;
		}

		// While Downloading Music File
		protected void onProgressUpdate(String... progress) {
			// Set progress percentage
			Log.e("Waiiiitttttt", "Waiiiitttttt Exec1");
		}

		// Once Music File is downloaded
		@Override
		protected void onPostExecute(String file_url) {

			try {
				responseBody2 = httpclient.execute(httpget2, responseHandler);
				Log.e("fin asynck 2", "fin asynck 2 fin asynck 2");
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	class AsynckExec3 extends AsyncTask<String, String, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();

		}

		// Download Music File from Internet
		@Override
		protected String doInBackground(String... f_url) {
			try {

			} catch (Exception e) {
				Log.e("Error: ", e.getMessage());
			}
			return null;
		}

		// While Downloading Music File
		protected void onProgressUpdate(String... progress) {
			// Set progress percentage
			Log.e("Waiiiitttttt", "Waiiiitttttt Exec1");
		}

		// Once Music File is downloaded
		@Override
		protected void onPostExecute(String file_url) {

			try {
				responseBody3 = httpclient.execute(httpget3, responseHandler);
				Log.e("fin asynck 3", "fin asynck 3 fin asynck 3");
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	class AsynckExec4 extends AsyncTask<String, String, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();

		}

		// Download Music File from Internet
		@Override
		protected String doInBackground(String... f_url) {
			try {

			} catch (Exception e) {
				Log.e("Error: ", e.getMessage());
			}
			return null;
		}

		// While Downloading Music File
		protected void onProgressUpdate(String... progress) {
			// Set progress percentage
			Log.e("Waiiiitttttt", "Waiiiitttttt Exec1");
		}

		// Once Music File is downloaded
		@Override
		protected void onPostExecute(String file_url) {

			try {
				responseBody4 = httpclient.execute(httpget4, responseHandler);
				Log.e("fin asynck 4", "fin asynck 4 fin asynck 4");
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void postopenconnectionPost()

	{
		try
		{  
			String urlParameters = "param1=post&param2=post&param3=post";
			URL url = new URL("http://192.168.13.130:8898/analytics/test_get_post.php");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			Log.e("1-conn",conn.hashCode()+"");
			OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
			Log.e("3-writer",writer.hashCode()+"");
			writer.write(urlParameters);
			writer.flush();
			String line;
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = reader.readLine()) != null) {
				Log.e("postpsot======post:", line);
			}
			writer.close();
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void methode1(){
		boolean reachable;
		try {
			reachable = InetAddress.getByName("www.google.com").isReachable(2000);
			Log.e("methode1 : reachable", ""+reachable);
		} catch (UnknownHostException e) {
			Log.e("methode 1 catch 1", e.toString());
		} catch (IOException e) {
			Log.e("methode 1 catch 2", e.toString());
		}
	}

	public void methode2(){
		boolean exists = false;

		try {
			SocketAddress sockaddr = new InetSocketAddress("www.google.com", 80);
			// Create an unbound socket
			Socket sock = new Socket();
			int timeoutMs = 2000;   // 2 seconds
			sock.connect(sockaddr, timeoutMs);
			exists = true;
			Log.e("methode 2 ", ""+exists);
		}catch(Exception e){
			Log.e("methodecatch ", ""+exists);
			e.toString();
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

	private List<Movie> parseFromUrl() throws XmlPullParserException,IOException {

		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		factory.setNamespaceAware(false);
		XmlPullParser parser = factory.newPullParser();
		URL url = new URL(xmlUrl);
		URLConnection ucon = url.openConnection();
		//String res=RMCustomTrace.RM_TRACE_METHOD_START(RMCategoryTracing.HTTPREQUEST.toString());	
		InputStream is = ucon.getInputStream();
		//RMCustomTrace.RM_TRACE_METHOD_STOP(res);
		parser.setInput(is, null);
		parser.nextText();
		parser.nextTag();
		parser.nextTag();
		parser.nextTag();
		parser.nextTag();
		parser.nextText();
		List<Movie> moviesList = parseMovies(parser);

		return moviesList;
	}
	/*---------- Listener class to get coordinates ------------- */
	private class MyLocationListener implements LocationListener {

		private TextView editLocation;

		@Override
		public void onLocationChanged(Location loc) {
			editLocation.setText("");
			//pb.setVisibility(View.INVISIBLE);
			Toast.makeText(
					getBaseContext(),
					"Location changed: Lat: " + loc.getLatitude() + " Lng: "
							+ loc.getLongitude(), Toast.LENGTH_SHORT).show();
			String longitude = "Longitude: " + loc.getLongitude();
			Log.v(TAG, longitude);
			String latitude = "Latitude: " + loc.getLatitude();
			Log.v(TAG, latitude);

			/*------- To get city name from coordinates -------- */
			String cityName = null;
			Geocoder gcd = new Geocoder(getBaseContext(), Locale.getDefault());
			List<Address> addresses;
			try {
				addresses = gcd.getFromLocation(loc.getLatitude(),
						loc.getLongitude(), 1);
				if (addresses.size() > 0)
					System.out.println(addresses.get(0).getLocality());
				cityName = addresses.get(0).getLocality();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			String s = longitude + "\n" + latitude + "\n\nMy Current City is: "
					+ cityName;
			editLocation.setText(s);
		}

		@Override
		public void onProviderDisabled(String provider) {}

		@Override
		public void onProviderEnabled(String provider) {}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {}
	}

	public void postData() throws IOException, ClientProtocolException 
	{  
		final String URL_STRING = "http://62.160.52.78/client/Section3_1/?limit_show=1";
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(URL_STRING);
		httppost.setHeader("Ipln-Auth","Y3ZhY3ZhX0BfQTlLZHFzTUZmbkhsRQ==");  
		HttpResponse response = httpclient.execute(httppost);

		String line = "";
		StringBuilder contentBuilder = new StringBuilder();
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		while ((line = rd.readLine()) != null)
		{
			contentBuilder.append(line); 
		}
		String content = contentBuilder.toString();
		Log.e("contentcontent",""+content);

		webView.loadDataWithBaseURL(URL_STRING, content, "css/html", "UTF-8", "");

		//browser.loadData(content, "css/html", "UTF-8");
	}

	private void getClientNameDialog() {
		View mView = View.inflate(MainActivity.this, R.layout.client, null);

		AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
		mBuilder.setTitle("Détails");
		mBuilder.setPositiveButton("Fermer", new Dialog.OnClickListener() {
			public void onClick(DialogInterface mDialogInterface, int mWhich) {

				mDialogInterface.dismiss();
			}
		});
		mBuilder.setView(mView);
		mBuilder.show();
	}

	public static void MethodBefore()
	{/*
		//String timeMilliNano = System.currentTimeMillis() +"#" + System.nanoTime();
		valueBefore = System.currentTimeMillis();
		//String dt = dateFormatf( System.currentTimeMillis() );
		//Log.e("MethodBefore",": " + timeMilliNano + " : : " +dt);*/
		valueBefore = System.currentTimeMillis();

		/*String result= RMConstant.EMPTY_STRING;
		if(RMConfig.getConfigPermission(RMConfig.RM_CONFIG_PERMISSION_TRACE_ENABLED) == true)
		{
			RMLogRumMobile.rmShowVerbose("<<<<<< RMCustomTrace RM_TRACE_METHOD_START");
			try
			{
				RMLogRumMobile.RMDebug("Start Tracking Code");
				String uniqueIdentifier =  RMInfosDevice.getMd5FromString(Long.toString(System.nanoTime()));
				if(!uniqueIdentifier.equalsIgnoreCase(RMConstant.EMPTY_STRING))
				{
					result = uniqueIdentifier;
				} 
				else
				{
					result = Long.toString(System.nanoTime());
				}
				StackTraceElement[] ste = Thread.currentThread().getStackTrace();
				int depth = 2;
				String  nameMethod = ste[1+depth].getMethodName();
				String category = RMCategoryTracing.CUSTOM.getCategoryTracing();

				//beforeJoinPointCustom(nameMethod, category, result);

				RMInteractionsTrace.startCpuMemory();
				RMInteractions activityInfo = new RMInteractions();
				activityInfo.setCpuInfosBefore(RumMobileAgent.cpuInfosRunnable);
				activityInfo.setMemoryUsageBefore(RumMobileAgent.memoryInfosRunnable);
				activityInfo.setBatteryBefore(RMBattery.BatteryLevelText);
				activityInfo.setThread(Thread.currentThread().getName());
				activityInfo.setCategory(category);
				activityInfo.setMethod(nameMethod);
				activityInfo.setHashCode(uniqueIdentifier);
				activityInfo.setStartTime(System.currentTimeMillis() +"#" +System.nanoTime());	
				//valueBefore = System.currentTimeMillis();
				//RMInteractionsTrace.mapListener.put(uniqueIdentifier,activityInfo);

			}
			catch(Exception e)
			{
				RMLogRumMobile.RMException(e);
			}
			RMLogRumMobile.rmShowVerbose(">>>>>> RMCustomTrace RM_TRACE_METHOD_START");
		}
		 */

	}

	public static long valueBefore = 0; 
	public static long valueAfter = 0; 

	public static void MethodAfter()
	{
		/*String timeMilliNano = System.currentTimeMillis() +"#" + System.nanoTime();
		String dt = dateFormatf( System.currentTimeMillis() );
		Log.e("MethodAfter",": " + timeMilliNano + " : : " +dt);

		 */
		//final StackTraceElement[] ste = Thread.currentThread().;
		valueAfter  = System.currentTimeMillis();
	}

	/*public static String dateFormatf(Long realStartTime )
	{
		String date=RMConstant.EMPTY_STRING;

		try
		{
			Date currentDate = new Date(realStartTime);
			DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			dateformat.setTimeZone(TimeZone.getTimeZone("GMT"));
			date = dateformat.format(currentDate);	
		}
		catch(Exception e)
		{
		}

		return date;
	}*/
public class testiput extends AsyncTask<String, String, String>
{

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			postopenconnectionPost();
			return null;
		}}
}