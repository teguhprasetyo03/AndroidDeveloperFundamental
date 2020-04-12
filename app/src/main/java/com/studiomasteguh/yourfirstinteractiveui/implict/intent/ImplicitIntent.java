package com.studiomasteguh.yourfirstinteractiveui.implict.intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import com.studiomasteguh.yourfirstinteractiveui.R;

public class ImplicitIntent extends AppCompatActivity {
    private EditText edtWeb;
    private EditText locM;
    private EditText shareTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        edtWeb = findViewById(R.id.edt_web);
        locM = findViewById(R.id.edt_location);
        shareTxt = findViewById(R.id.edt_text_show);
    }

    public void OpenWebsite(View view) {

        // get the URL Website
        String url = edtWeb.getText().toString();

        // Define URi and create intent
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntens", "Can't handle this intent");
        }
    }

    public void OpenLocation(View view) {
        // get location from URL
        String loc = locM.getText().toString();

        // define Uri from location and create intent to location
        Uri addressloc = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressloc);
        intent.setPackage("com.google.android.apps.maps");

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntens", "Can't handle this intent");
        }
    }

    public void ShareText(View view) {
        String txt = shareTxt.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(R.string.share_text_with)
                .setText(txt)
                .startChooser();

    }
}
