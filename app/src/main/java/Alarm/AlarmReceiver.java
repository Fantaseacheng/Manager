package Alarm;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;



public class AlarmReceiver extends BroadcastReceiver {
    private Vibrator vibrator;
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"上课啦！",Toast.LENGTH_SHORT).show();
        vibrator = (Vibrator)context.getSystemService(Service.VIBRATOR_SERVICE);
        vibrator.vibrate(new long[]{3000,3000,3000,3000,3000},-1);

    }
}
