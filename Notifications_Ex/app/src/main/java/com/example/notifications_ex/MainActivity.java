package com.example.notifications_ex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    String Channel_Id="Simple Notification";
    int Notification_id=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendNotification(View view) {
        createNotificationChannel();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setContentTitle("Notification");
        builder.setContentText("This is a Simple Notification");
        builder.setPriority(1);
        NotificationManagerCompat notificationManagerCompat =
                NotificationManagerCompat.from(MainActivity.this);
        notificationManagerCompat.notify(Notification_id,builder.build());

    }

    private void createNotificationChannel() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            CharSequence name = "Simple Notification";
            String description = "This is a simple Notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel =new
                    NotificationChannel(Channel_Id,name,importance);
            NotificationManager notificationManager =(NotificationManager)
                    getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);

        }
    }

}