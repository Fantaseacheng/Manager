package Alarm;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.classmanager.R;
import com.example.classmanager.RegisterActivity;

import Any.PxUntil;


public class AlarmReceiver extends BroadcastReceiver {
    private Vibrator vibrator;
    @Override
    public void onReceive(Context context, Intent intent) {
        View toastView =LayoutInflater.from(context).inflate(R.layout.alarm_toast, null);
        LinearLayout relativeLayout = toastView.findViewById(R.id.toast_linear);
        PxUntil pxUntil = new PxUntil();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int)pxUntil.dpToPx(context, 130), (int)pxUntil.dpToPx(context, 130));
        relativeLayout.setLayoutParams(layoutParams);
        TextView textView = toastView.findViewById(R.id.tv_toast_clear);
        textView.setText("上课啦！！");
        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setView(toastView);
        toast.show();
        vibrator = (Vibrator)context.getSystemService(Service.VIBRATOR_SERVICE);
        vibrator.vibrate(new long[]{3000,3000,3000,3000,3000},-1);

    }
}
