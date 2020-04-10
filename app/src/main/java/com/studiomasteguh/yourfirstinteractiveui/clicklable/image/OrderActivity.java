package com.studiomasteguh.yourfirstinteractiveui.clicklable.image;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.studiomasteguh.yourfirstinteractiveui.R;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "eztra_message";

    RadioButton rbGojek, rbAnteraja, rbSicepat, rbNinja, rbWahana;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        String name = getIntent().getStringExtra(EXTRA_MESSAGE);
        TextView tvResult = findViewById(R.id.tv_order);

        String text = "Your order  " + name;
        tvResult.setText(text);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void onRadioButtonClicked(View view) {
        // cek this button
        boolean checked = ((RadioButton) view).isChecked();

        // click this button on delivery
        switch (view.getId()) {
            case R.id.rb_gojek:
                if (checked)
                    displayToast(getString(R.string.gojek));
                break;
            case R.id.rb_anter_aja:
                if (checked)
                    displayToast(getString(R.string.anteraja));
                break;
            case R.id.rb_ninja:
                if (checked)
                    displayToast(getString(R.string.ninja));
                break;
            case R.id.rb_wahana:
                if (checked)
                    displayToast(getString(R.string.wahana));
                break;
            case R.id.rb_sicepat:
                if (checked)
                    displayToast(getString(R.string.sicepat));
                break;
            default:
                // Do anything
                break;
        }
    }
}
