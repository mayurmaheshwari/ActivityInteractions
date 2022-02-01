package com.example.activityinteractions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivity";
    public final static String EXTRA_RETURN_MESSAGE = "com.example.mysampleapp.RETURN_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent receivedIntent = getIntent();

        String message = receivedIntent.getStringExtra(MainActivity.MESSAGE_EXTRA);

        Log.d(TAG, message);

        TextView resultText = (TextView) findViewById(R.id.textView);
        resultText.setText(message);

        View reply_button = findViewById(R.id.reply_button);

        reply_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnActivity = new Intent();
                Log.d(TAG, "returnActivityIntentCreated");
                returnActivity.putExtra(EXTRA_RETURN_MESSAGE, "Return message from Second Activity");
                Log.d(TAG, "returnActivityIntentCreated 2");
                setResult(RESULT_OK, returnActivity);
                Log.d(TAG, "returnActivityIntentCreated 3");
                finish();
            }
        });

    }
}