package com.example.loadimage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class FileWriteRead extends Activity {
    
   private static final String TAG = FileWriteRead.class.getName();
   private static final String FILENAME = "myFile.txt";
   private File f;
   private boolean bool;
    
   /** Called when the activity is first created. */
   @Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.main);
        
       String textToSaveString = "Hello Android";
        
       writeToFile(textToSaveString);
        
       String textFromFileString =  readFromFile();
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
       if ( textToSaveString.equals(textFromFileString) )
           Toast.makeText(getApplicationContext(), "both string are equal", Toast.LENGTH_SHORT).show();
       else
           Toast.makeText(getApplicationContext(), "there is a problem", Toast.LENGTH_SHORT).show();
   }
    
   private void writeToFile(String data) {
       try {
           OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(FILENAME, Context.MODE_PRIVATE));
           outputStreamWriter.write(data);
           outputStreamWriter.close();
       }
       catch (IOException e) {
           Log.e(TAG, "File write failed: " + e.toString());
       }
   }

   private String readFromFile() {
        
       String ret = "";
       try {
           InputStream inputStream = openFileInput(FILENAME);
           if ( inputStream != null ) {
               InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
               BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
               String receiveString = "";
               StringBuilder stringBuilder = new StringBuilder();
               Log.e("test intercept read", ""+bufferedReader.read());
               while ( (receiveString = bufferedReader.readLine()) != null ) {
                   stringBuilder.append(receiveString);
               }
                
               inputStream.close();
               ret = stringBuilder.toString();
           }
       }
       catch (FileNotFoundException e) {
           Log.e(TAG, "File not found: " + e.toString());
       } catch (IOException e) {
           Log.e(TAG, "Can not read file: " + e.toString());
       }

       return ret;
   }
}