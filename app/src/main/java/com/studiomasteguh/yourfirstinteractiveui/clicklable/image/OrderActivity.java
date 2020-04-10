package com.studiomasteguh.yourfirstinteractiveui.clicklable.image;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.studiomasteguh.yourfirstinteractiveui.R;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public static final String EXTRA_MESSAGE = "eztra_message";
    private static final String TAG = OrderActivity.class.getSimpleName();

    RadioButton rbGojek, rbAnteraja, rbSicepat, rbNinja, rbWahana;
    Spinner sp;
    EditText phone;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        String name = getIntent().getStringExtra(EXTRA_MESSAGE);
        TextView tvResult = findViewById(R.id.tv_order);

        String text = "Your order  " + name;
        tvResult.setText(text);

        // create an spinner
        sp = findViewById(R.id.spinner);
        if (sp != null){
            sp.setOnItemSelectedListener(this);
        }

        // set on adapter and call string array list from resource string
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_name,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (sp !=null){
            sp.setAdapter(adapter);
        }

        phone = findViewById(R.id.edt_phone);
        if (phone != null){
            phone.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    boolean handled = false;
                    if (actionId == EditorInfo.IME_ACTION_SEND){
                        dialNumber();
                        handled = true;
                    }
                    return handled;
                }
            });
        }
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

    public void dialNumber(){
        phone = findViewById(R.id.edt_phone);
        String phoneNum = null;
        if (phone != null)phoneNum = "tel : " + phone.getText().toString();

        Log.d(TAG, "dialNumber: " + phoneNum);

        Intent i = new Intent(Intent.ACTION_DIAL);

        i.setData(Uri.parse(phoneNum));
        if (i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        } else {
            Log.d(TAG, "Implicit Intens : Can't handle this!");
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        String spinnerlabel = adapterView.getItemAtPosition(position).toString();
        displayToast(spinnerlabel);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
