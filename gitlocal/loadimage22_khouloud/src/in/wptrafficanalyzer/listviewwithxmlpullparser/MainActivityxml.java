package in.wptrafficanalyzer.listviewwithxmlpullparser;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import com.example.loadimage.R;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivityxml extends Activity {

	private ListView listView;
	TextView xmlOutput;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main1);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);
		
		xmlOutput = (TextView) findViewById(R.id.xmlOutput);
		try {
			try {
				parseXML();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void parseXML() throws XmlPullParserException, IOException {
		
		String parsedData = "";
		String textforinput = "<foo>Hello World!</foo>";

		// TODO Auto-generated method stub
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		factory.setNamespaceAware(true);
		XmlPullParser xpp = factory.newPullParser();
		// new InputSource(getAssets().open("data.txt"))
		// To load text file
		AssetManager assetManager = getAssets();
		InputStream input;
		try {
			input = assetManager.open("data.xml");
			int size = input.available();
			byte[] buffer = new byte[size];
			input.read(buffer);
			input.close();
			// byte buffer into a string
			textforinput = new String(buffer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		xpp.setInput(new StringReader(textforinput));
		int eventType = xpp.getEventType();
		parsedData = parsedData + "----->\n";
		while (eventType != XmlPullParser.END_DOCUMENT) {
			if (eventType == XmlPullParser.START_DOCUMENT) {
				System.out.println("Start document");
			} else if (eventType == XmlPullParser.END_DOCUMENT) {
				System.out.println("End document");
			} else if (eventType == XmlPullParser.START_TAG) {
				System.out.println("Start tag " + xpp.getName());
				parsedData = parsedData + "Start tag " + xpp.getName() + "\n";
			} else if (eventType == XmlPullParser.END_TAG) {
				System.out.println("End tag " + xpp.getName());
				parsedData = parsedData + "End tag " + xpp.getName() + "\n";
			} else if (eventType == XmlPullParser.TEXT) {
				System.out.println("Text " + xpp.getText());
				parsedData = parsedData + "Text " + xpp.getText() + "\n";
			}
			parsedData = parsedData + "----->\n";
			xmlOutput.setText(parsedData);
			eventType = xpp.next();
		}
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
	}
	
	public void onRestart() {
		super.onRestart();
		Log.e("onRestart", "onRestart");
	}
}
