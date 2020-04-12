package com.studiomasteguh.yourfirstinteractiveui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;
    TextView result;
    private int resultshow = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn_count);
        btn2 = findViewById(R.id.btn_toast);
        btn3 = findViewById(R.id.btn_subtract);
        result = findViewById(R.id.textView);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Ini adalah Toast", Toast.LENGTH_SHORT).show();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++resultshow;
                if (result != null)
                    result.setText(Integer.toString(resultshow));
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                --resultshow;
                if (result != null)
                    result.setText(Integer.toString(resultshow));
            }
        });
    }

}

