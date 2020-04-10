package com.studiomasteguh.yourfirstinteractiveui.support.libraries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.studiomasteguh.yourfirstinteractiveui.R;

import java.util.Random;

public class SupportLibraries extends AppCompatActivity {
    // deklarasi textview
    private TextView tvStudio;
    // array list color
    private String[] arrayColor = {
            "red", "pink", "purple", "deep purple", "indigo",
            "blue", "light_blue", "cyan", "teal", "green",
            "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
            "brown", "grey", "blue_grey", "black"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support_libraries);
        // inisialisasi id pada tv studio mas teguh
        tvStudio = findViewById(R.id.tv_studio);

        // mengembalikan save instance color
        if (savedInstanceState != null) {
            tvStudio.setTextColor(savedInstanceState.getInt("color"));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // simpan text color disini
        outState.putInt("color", tvStudio.getCurrentTextColor());
    }

    public void ChangeColor(View view) {
        // get a random color name from the array color(20 colors)
        Random random = new Random();
        String colorName = arrayColor[random.nextInt(20)];

        // get the color inditifier
        int colorResourceName = getResources().getIdentifier(colorName, "color",
                getApplicationContext().getPackageName());

        // get color ID from the resources
        int colorRes = ContextCompat.getColor(this, colorResourceName);

        // set text this on color
        tvStudio.setTextColor(colorRes);
    }
}
