package helpers;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by Rabson on 10/14/2016.
 */
public class AppController extends Application {

    public static final String Tag=AppController.class.getSimpleName();
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    private static AppController mInstance;
    @Override
    public void onCreate(){
        super.onCreate();
        mInstance=this;
    }
    public static synchronized AppController getmInstance(){
        return mInstance;

    }
    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }
    public <T> void addTorequestQue(Request<T> req, String tag ){
//set the default tag if the tag is empy
        req.setTag(TextUtils.isEmpty(tag)? Tag: tag);
        getRequestQueue().add(req);
    }
    public <T> void addToRequestQue(Request<T> req){
        req.setTag(Tag);
        getRequestQueue().add(req);

    }
    public void cancelPendingRequest(Object tag){
        if (mRequestQueue==null){
            mRequestQueue.cancelAll(tag);
        }

    }
}
