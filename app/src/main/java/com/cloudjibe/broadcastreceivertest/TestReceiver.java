package com.cloudjibe.broadcastreceivertest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class TestReceiver extends BroadcastReceiver 
{


	private static final String tag = "TestReceiver >";
    @Override
    public void onReceive(Context context, Intent intent) 
    {

        Toast.makeText(context, "Receiver Triggered"     , Toast.LENGTH_LONG).show();

        Log.d(tag,"*****........ Manoj received broadcast........******");

    	Utils.logThreadSignature(tag);
        Log.d("TestReceiver >", "intent=" + intent);
        String message = intent.getStringExtra("message");
        Log.d(tag, message);
    }
}

