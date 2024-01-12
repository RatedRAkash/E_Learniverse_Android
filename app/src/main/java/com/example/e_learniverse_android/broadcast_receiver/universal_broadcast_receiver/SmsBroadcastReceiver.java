package com.example.e_learniverse_android.broadcast_receiver.universal_broadcast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;


public class SmsBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();

        //PDU = Protocol Data Unit ---> SMS intent er moddhe amra PDU format ee pai

        Object[] smsObjectArray = (Object[]) bundle.get("pdus");

        for (Object obj : smsObjectArray) {
            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) obj);

            String mobileNo = smsMessage.getDisplayOriginatingAddress();
            String msg = smsMessage.getDisplayMessageBody();

            Log.d("SMSDetails", "MobileNo: " + mobileNo + ", Msg: " + msg);


            //TODO: Sending SMS from App
            SmsManager smsManager = SmsManager.getDefault();

            smsManager.sendTextMessage("+8801776341208", null, "E Learniverse: Sergio Ramos sending SMS",
                    null, null);
        }
    }
}
