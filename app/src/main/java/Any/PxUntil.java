package Any;

import android.content.Context;

public class PxUntil {
    public static float dpToPx(Context context, int dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return dp * density;
    }
    public static float pxTodp(Context context, int px) {
        float density = context.getResources().getDisplayMetrics().density;
        return px / density;
    }

}
