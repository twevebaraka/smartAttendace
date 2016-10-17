package helpers;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class myViewPager extends ViewPager {
    public myViewPager(Context context) {
        super(context);
    }

    public myViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
// never allow swipping to switch btn pages
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return  false;
    }
}
