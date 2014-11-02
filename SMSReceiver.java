package com.example.smstest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver{

	String tokens[]=new String[100];
	String amount,file;
	static double lat,lon;
	
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
		
		
		Bundle myBundle = intent.getExtras();
        SmsMessage [] messages = null;
        String strMessage = "";
        String address="";
        if (myBundle != null)
        {
            Object [] pdus = (Object[]) myBundle.get("pdus");
            messages = new SmsMessage[pdus.length];

            for (int i = 0; i < messages.length; i++)
            {
                messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                address= messages[i].getOriginatingAddress();
                //strMessage += " : ";
                strMessage += messages[i].getMessageBody();
                strMessage += "\n";
            }

            
            Toast.makeText(context, strMessage, Toast.LENGTH_SHORT).show();
            String tokens[]=strMessage.split(" ");
            
            for(int i=0;i<tokens.length;i++){
            	if(tokens[i].equalsIgnoreCase("inr")){
            		amount=tokens[i+1];
            		Toast.makeText(context, tokens[i+1], Toast.LENGTH_SHORT).show();
            		break;
            	}
            }
            GPSTracker gps=new GPSTracker(MainActivity.a);
            lat= gps.getLatitude();
            lon=gps.getLongitude();
            
            Intent i=new Intent(context,Map.class);
            context.startActivity(i);
           // Toast.makeText(context, ""+latitude, Toast.LENGTH_SHORT).show();
            
            
            
    		
		
	}

}
	}


	
