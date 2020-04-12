package com.studiomasteguh.yourfirstinteractiveui.intentandactivities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.studiomasteguh.yourfirstinteractiveui.R;

public class OneActivity extends AppCompatActivity {

    private static final String LOG_TAG = OneActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    public static int INT_REQUEST = 1;
    EditText edt1;
    TextView tvreply, tvhead;

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (tvhead.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            outState.putString("reply_text", edt1.getText().toString());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        edt1 = findViewById(R.id.edt_result);
        tvreply = findViewById(R.id.tv_message_one);
        tvhead = findViewById(R.id.tv_header_one);

        Log.d(LOG_TAG, "--------");
        Log.d(LOG_TAG, "onCreate");

        if (savedInstanceState != null) {
            boolean isVisible = savedInstanceState.getBoolean("reply_visible");
            if (isVisible) {
                tvhead.setVisibility(View.VISIBLE);
                tvreply.setText(savedInstanceState.getString("reply_text"));
                tvreply.setVisibility(View.VISIBLE);
            }
        }
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

    public void launchTwoActivity(View view) {
        Log.d(LOG_TAG, "launchTwoActivity: Button Clicked!");
        // berpindah dari activity satu ke activity lain
        Intent pindah = new Intent(this, TwoActivity.class);
        String message = edt1.getText().toString();
        pindah.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(pindah, INT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == INT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(TwoActivity.EXTRA_REPLY);
                tvhead.setVisibility(View.VISIBLE);
                tvreply.setText(reply);
                tvreply.setVisibility(View.VISIBLE);
            }
        }
    }
}
