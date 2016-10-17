package SmsVerification;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import helpers.AppController;
import com.example.rabson.ea.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import helpers.Config;
import helpers.prefManager;

public class httpService extends IntentService {
    private  static String TAG=httpService.class.getSimpleName();
    public httpService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if(intent!=null){
            String opt_message=intent.getStringExtra("opt_message");
            verifyOptMessage(opt_message);
        }
    }

    private void verifyOptMessage(final String opt_message) {
        StringRequest myrequest=new StringRequest(Request.Method.POST, Config.URL_VERIFY_SMS, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG,response.toString());
                try {
                    JSONObject responseObj=new JSONObject(response);
                    boolean error=responseObj.getBoolean("error");
                    String message=responseObj.getString("message");
                    if (!error){
                        JSONObject profileObj=responseObj.getJSONObject("profile");
                        String name=profileObj.getString("name");
                        String email=profileObj.getString("email");
                        String mobile=profileObj.getString("mobile");
                        prefManager prefManager=new prefManager(getApplicationContext());
                        prefManager.createLogin(name,email,mobile);
                        Intent intent=new Intent(httpService.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
                    }

                        else {
                            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                        }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<String,String>();
                params.put("opt",opt_message);
                Log.e(TAG, "Posting params: " + params.toString());
                return params;            }
        };
       AppController.getmInstance().addToRequestQue(myrequest);
    }
}
