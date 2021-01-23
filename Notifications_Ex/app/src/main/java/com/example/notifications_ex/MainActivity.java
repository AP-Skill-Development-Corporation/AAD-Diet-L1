package com.example.notifications_ex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendNotification(View view) {
        NotificationManager nm = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        String c_id="KriChannel";
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel nc = new
                    NotificationChannel(c_id,"KriChannel",
                    NotificationManager.IMPORTANCE_HIGH);
            nc.enableLights(true);
            nc.enableVibration(true);
            nc.setDescription("Sample Notification");
            nm.createNotificationChannel(nc);
        }
        NotificationCompat.Builder builder = new
                NotificationCompat.Builder(this,c_id);
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setContentTitle("Notification");
        builder.setContentText("Simple Notification");
        Intent i = new Intent(this,MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this,23,
                i,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pi);
        builder.setAutoCancel(true);
        builder.addAction(R.drawable.ic_launcher_background,"Image",pi);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.e);
        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap));
        builder.setPriority(1);
        

        nm.notify(12,builder.build());


    }



}