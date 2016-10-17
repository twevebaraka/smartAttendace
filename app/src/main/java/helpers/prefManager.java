package helpers;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class prefManager {
SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Context context;
    int PRIVATE_MODE=0;
    private static final String PREF_NAME="smartAttendace";
    //all shared pref keys
    private static final String WAITING_SMS="waiting_sms";
    private static final String MOBILE_NUMBER="mobile _number";
    private static final String IS_LOGGEDIN="mobile _number";
    private static final String EMAIL="email";
    private static final String NAME="name";
    private static final String IS_LOGIN="loggedIN";
 public prefManager(Context context) {
     this.context = context;

     preferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
     editor = preferences.edit();

 }   // waiting for sms verification
    public void setWaitingSms(boolean iswaiting){
     editor.putBoolean(WAITING_SMS,iswaiting);
        editor.commit();
    }
    public void setMobileNumber(String mobileNumber){
        editor.putString(MOBILE_NUMBER,mobileNumber);
        editor.commit();
    }
    public String getMobileNumber(){

        return preferences.getString(MOBILE_NUMBER,null);
    }
    public  void createLogin(String name,String email,String mobile){
        editor.putString(NAME,name);
        editor.putString(EMAIL,email);
        editor.putString(MOBILE_NUMBER,mobile);
        editor.commit();
    }
    public  boolean isLoggedIN(){

        return preferences.getBoolean(IS_LOGIN,false);
    }
    public void clearSession(){
        editor.clear();
        editor.commit();
    }
// get user profiles
    public HashMap<String,String> getUserDetails(){

        HashMap<String,String> userProfile=new HashMap<>();
        userProfile.put(NAME,preferences.getString(NAME,null));
        userProfile.put(EMAIL,preferences.getString(EMAIL,null));
        userProfile.put(MOBILE_NUMBER,preferences.getString(MOBILE_NUMBER,null));
        return userProfile;
    }
    public boolean isWaitingSms(){

        return preferences.getBoolean(WAITING_SMS,false);
    }
    public void setIsLogin(boolean login){
        editor.putBoolean(IS_LOGGEDIN,login);
        editor.commit();
    }



}
