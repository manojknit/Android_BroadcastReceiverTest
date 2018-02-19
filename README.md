# Android app to demonstrate broadcast and Receiver behavior of android app
####                                                                                                     By Manoj Kumar
## Introduction 
Android app to demonstrate broadcast and Receiver behavior of android. Use case can be if android OS broadcast battery low intent, your app can receive it and handel to move your app in power save mode.


## How to Run
1.	Prerequisite: Android Studio, some Java knowledge
2.	Download or clone project code and open in Android studio.
3.	Run in Nexus 5X API 26 emulator.


## Technologies Used
1.	Java.
2.	Android Studio


## Application Screenshots
#### Main Activity - TestBCRActivity is used to send Broadcast intent
<img src="images/Android Emulator - Nexus_5X_API_265554 2018-02-18 17-21-27.png">


```
   private void testSendBroadcast()
    {

    	//Print out what your running thread id is
    	Utils.logThreadSignature(tag);
        //Toast.makeText(this, "Broadcast"     , Toast.LENGTH_LONG).show();
    	//Create an intent with an action
    	Intent broadcastIntent = new Intent("com.cloudjibe.intents.testbc");
        broadcastIntent.setClass(this, TestReceiver.class);//if you dont want to use LocalBroadcastManager

    	broadcastIntent.putExtra("message", "Hello world");
    	sendBroadcast(broadcastIntent); //if you dont want to use LocalBroadcastManager
        //LocalBroadcastManager.getInstance(this).sendBroadcast(broadcastIntent); //TBD

    	Log.d(tag,"*****........ Manoj send broadcast from main menu........*****");
    }

public static final String tag="TestBroadcast >";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(this);//TBD
        //lbm.registerReceiver(new TestReceiver(), new IntentFilter("com.cloudjibe.intents.testbc"));//TBD

        setContentView(R.layout.main);
    }
```

#### Broadcast message is received in TestReceiver class.
<img src="images/Android Emulator - Nexus_5X_API_265554 2018-02-18 17-22-06.png">

## Code
```
   public void onReceive(Context context, Intent intent) 
    {

        Toast.makeText(context, "Receiver Triggered"     , Toast.LENGTH_LONG).show();

        Log.d(tag,"*****........ Manoj received broadcast........******");

    	Utils.logThreadSignature(tag);
        Log.d("TestReceiver >", "intent=" + intent);
        String message = intent.getStringExtra("message");
        Log.d(tag, message);
    }

```
## Refrence
- [*Pro Android 5*](https://github.com/Apress/pro-android-5) by Dave MacLean, Satya Komatineni, and Grant Allen (Apress, 2015)

## Thank You
[*Manoj Kumar*](https://www.linkedin.com/in/manojkumar19/)

Solutions Architect
