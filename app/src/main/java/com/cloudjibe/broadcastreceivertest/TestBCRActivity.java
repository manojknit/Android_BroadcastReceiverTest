package com.cloudjibe.broadcastreceivertest;

import com.cloudjibe.broadcastreceivertest.R;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class TestBCRActivity extends Activity 
{
	public static final String tag="TestBroadcast >";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(this);//TBD
        lbm.registerReceiver(new TestReceiver(), new IntentFilter("com.cloudjibe.intents.testbc"));//TBD

        setContentView(R.layout.main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
 	   	MenuInflater inflater = getMenuInflater(); //from activity
 	   	inflater.inflate(R.menu.main_menu, menu);
    	return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){ 
    	appendMenuItemText(item);
    	if (item.getItemId() == R.id.menu_clear){
    		this.emptyText();
    		return true;
    	}
    	if (item.getItemId() == R.id.menu_send_broadcast){
    		this.testSendBroadcast();
    		return true;
    	}
    	return true;
    }
    private TextView getTextView(){
        return (TextView)this.findViewById(R.id.text1);
    }
    private void appendMenuItemText(MenuItem menuItem){
       String title = menuItem.getTitle().toString();
       TextView tv = getTextView(); 
       tv.setText(tv.getText() + "\n" + title);
    }
    private void emptyText(){
          TextView tv = getTextView();
          tv.setText("");
    }
    private void testSendBroadcast()
    {

    	//Print out what your running thread id is
    	Utils.logThreadSignature(tag);
        //Toast.makeText(this, "Broadcast"     , Toast.LENGTH_LONG).show();
    	//Create an intent with an action
    	Intent broadcastIntent = new Intent("com.cloudjibe.intents.testbc");
        //broadcastIntent.setClass(this, TestReceiver.class);//if you dont want to use LocalBroadcastManager

    	broadcastIntent.putExtra("message", "Hello world");
    	//sendBroadcast(broadcastIntent); //if you dont want to use LocalBroadcastManager
        LocalBroadcastManager.getInstance(this).sendBroadcast(broadcastIntent); //TBD

    	Log.d(tag,"*****........ Manoj send broadcast from main menu........*****");
    }
}