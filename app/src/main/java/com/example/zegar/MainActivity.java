package com.example.zegar;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class MainActivity extends Activity {
    private TextView alarmTextView;
    private EditText timeInput;
    private View viewBackground;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmTextView = findViewById(R.id.alarm);
        timeInput = findViewById(R.id.timeInput);
        viewBackground = findViewById(R.id.zegar);

        // Uruchomienie sprawdzania czasu co sekundę
        handler.postDelayed(checkAlarmRunnable, 1000);
    }

    private Runnable checkAlarmRunnable = new Runnable() {
        @Override
        public void run() {
            String currentTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(Calendar.getInstance().getTime());
            String alarmTime = timeInput.getText().toString();

            if (currentTime.equals(alarmTime)) {
                alarmTextView.setText("ALARM!!!!");
                viewBackground.setBackgroundColor(Color.RED);

            } else {
                alarmTextView.setText("NIC SIE NIE DZIEJE");
                viewBackground.setBackgroundColor(Color.WHITE);
            }

            handler.postDelayed(this, 1000);
        }
    };
}
