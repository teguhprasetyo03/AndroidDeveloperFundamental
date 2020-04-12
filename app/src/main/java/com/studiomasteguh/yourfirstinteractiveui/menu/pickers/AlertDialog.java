package com.studiomasteguh.yourfirstinteractiveui.menu.pickers;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.studiomasteguh.yourfirstinteractiveui.R;

public class AlertDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
    }

    public void onClickShowAlert(View view) {
        androidx.appcompat.app.AlertDialog.Builder myAlertBuilder =
                new androidx.appcompat.app.AlertDialog.Builder(AlertDialog.this);

        // set dialog title dan message
        myAlertBuilder.setTitle("Alert");
        myAlertBuilder.setMessage("Click OK to Continue, Click Cancel To Stop");

        // add the dialog button
        myAlertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AlertDialog.this, "Pressed OK", Toast.LENGTH_SHORT).show();
            }
        });

        myAlertBuilder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AlertDialog.this, "Pressed Cancel", Toast.LENGTH_SHORT).show();
            }
        });

        // create alert builder and show
        myAlertBuilder.show();
    }

    public void ShowDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), getString(R.string.datepicker));
    }

    public void ProcessDatePickerResult(int date, int month, int year) {
        String month_string = Integer.toString(month + 1);
        String date_String = Integer.toString(date);
        String year_String = Integer.toString(year);

        String date_message = (date_String + "/" + month_string + "/" + year_String);

        Toast.makeText(this, getString(R.string.date) + date_message, Toast.LENGTH_SHORT).show();
    }

    public void ShowTimePicker(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), getString(R.string.timepicker));
    }

    public void ProcessTimePickerResult(int hourOfDay, int minute) {
        String hour_day = Integer.toString(hourOfDay);
        String minutes = Integer.toString(minute);

        String time_message = (hour_day + ":" + minutes);

        Toast.makeText(this, getString(R.string.time_toast) + time_message, Toast.LENGTH_SHORT).show();
    }


}
