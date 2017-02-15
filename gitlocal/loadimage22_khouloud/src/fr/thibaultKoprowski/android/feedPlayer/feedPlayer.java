package fr.thibaultKoprowski.android.feedPlayer;

import java.util.ArrayList;

import com.example.loadimage.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class feedPlayer extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainsax);
      
        ArrayList<Feed> feeds = ContainerData.getFeeds();
    
        ListFeedAdapter lfa = new ListFeedAdapter(this, feeds);
        ((ListView)findViewById(R.id.listFeed)).setAdapter(lfa);
        
    }
}