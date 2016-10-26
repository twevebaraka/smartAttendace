//package SmsVerification;
//
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.telephony.SmsMessage;
//import android.util.Log;
//
//import helpers.Config;
//
///**
// * Created by Rabson on 10/15/2016.
// */
//public class SmsReceiver extends BroadcastReceiver {
//    private static final String TAG=SmsReceiver.class.getSimpleName();
//    @Override
//    public void onReceive(Context context, Intent intent) {
//        final Bundle bundle=intent.getExtras();
//        if (bundle!=null){
//            Object[] object_received= (Object[]) bundle.get("something");
//            for (Object obj_something: object_received){
//                SmsMessage currentMessage= SmsMessage.createFromPdu((byte[]) obj_something);
//                String senderAddress=currentMessage.getDisplayOriginatingAddress();
//                String message=currentMessage.getDisplayMessageBody();
//                Log.e(TAG,"Received SMs"+message+"Sender"+senderAddress);
//                // ignore the message if not from the gateway
//                if (!senderAddress.toLowerCase().contains(Config.SMS_ORIGIN.toLowerCase())){
//                    return;
//                }
//                // verificatin code form sms
//                String verificationCode=getVerificationCode(message);
//                Log.e(TAG,"OTP Received"+verificationCode);
//                Intent httpIntent=new Intent(context,httpService.class);
//                httpIntent.putExtra("something",verificationCode);
//                context.startActivity(httpIntent);
//            }
//        }
//
//    }
//
//    private String getVerificationCode(String message) {
//        String code=null;
//        int index=message.indexOf(Config.OTP_DELIMETER);
//        if (index!=-1){
//            int start=index+2;
//            int length=6;
//            code=message.substring(start,start+length);
//            return  code;
//        }
//
//        return message;
//    }
//}
//
