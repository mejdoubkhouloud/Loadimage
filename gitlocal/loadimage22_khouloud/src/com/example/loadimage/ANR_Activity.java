package com.example.loadimage;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ANR_Activity extends Activity {
	TextView tv; //for class wide reference to update status
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anr);
        //get the references to on screen items
        tv=(TextView) findViewById(R.id.textView);
        //handle button presses
        findViewById(R.id.button).setOnClickListener(new doButtonClick());
    }

    class doButtonClick implements View.OnClickListener {
        public void onClick(View v) {
            tv.setText("Processing, please wait.");
            ThisTakesAWhile();
            tv.setText("Finished.");
        }
    }

    private void ThisTakesAWhile() {
        //mimic long running code
        int count = 0;
        do{
        try{
            SystemClock.sleep(10000);
            count++;
            tv.setText("Processed " + count + " of 10.");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        } while(count<10);
    }
}
