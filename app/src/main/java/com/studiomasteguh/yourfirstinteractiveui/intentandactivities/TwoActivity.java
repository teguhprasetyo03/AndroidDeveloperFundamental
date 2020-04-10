package com.studiomasteguh.yourfirstinteractiveui.intentandactivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.studiomasteguh.yourfirstinteractiveui.R;

public class TwoActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "EXTRA_REPLY";
    private static final String LOG_TAG = TwoActivity.class.getSimpleName();
    EditText mReply;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        mReply = findViewById(R.id.edt_reply);
        Intent intent = getIntent();
        String message = intent.getStringExtra(OneActivity.EXTRA_MESSAGE);
        TextView tv = findViewById(R.id.tv_header);
        tv.setText(message);

        Log.d(LOG_TAG, "--------");
        Log.d(LOG_TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    public void returnReply(View view){
        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        Log.d(LOG_TAG, "End TwoActivity");
        finish();
    }
}