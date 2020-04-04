package com.app.dialogfromservice;

import android.app.AlertDialog;
import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.view.WindowManager;
import androidx.annotation.Nullable;

public class BackgroundDialogService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Service Message", "Service Created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("Service Message", "Service Started");

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                builder.setTitle("Hello").setMessage("This dialog is created from service.").setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                int layout_params;

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                {
                    layout_params = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
                }

                else {
                    layout_params = WindowManager.LayoutParams.TYPE_PHONE;
                }

                final AlertDialog alert = builder.create();
                alert.getWindow().setType(layout_params);

                alert.show();
            }
        }, 10000);

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Service Message", "Service Destroyed");
    }
}
