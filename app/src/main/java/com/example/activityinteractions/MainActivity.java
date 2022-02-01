package com.example.activityinteractions;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String MESSAGE_EXTRA = "com.example.activityinteractions.MESSAGE_EXTRA";
    private final static String LOG_TAG = MainActivity.class.getSimpleName();

    ActivityResultLauncher<Intent> mGetContent = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    if (result.getResultCode() == Activity.RESULT_OK) {

                        Intent data = result.getData();
                        Log.d(LOG_TAG, data.getStringExtra(SecondActivity.EXTRA_RETURN_MESSAGE));

                    }
                }
            });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // GetContent creates an ActivityResultLauncher<String> to allow you to pass
// in the mime type you'd like to allow the user to select


//        View button = findViewById(R.id.button_main);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent changeActivity = new Intent(MainActivity.this, SecondActivity.class);
//                startActivity(changeActivity);
//            }
//        });


    }


    public void launchSecondActivity(View view) {


        //Extract the text
        TextView inputText = (TextView) findViewById(R.id.editTextTextPersonName);
        String textToSend = inputText.getText().toString();
        //Log.d(LOG_TAG, textToSend);

        Intent changeActivityIntent = new Intent(MainActivity.this, SecondActivity.class);
        //Put the extracted text in the intent as Extra
        changeActivityIntent.putExtra(MESSAGE_EXTRA, textToSend);

        mGetContent.launch(changeActivityIntent);


    }

}