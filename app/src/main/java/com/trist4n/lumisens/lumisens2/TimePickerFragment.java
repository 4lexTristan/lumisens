/**
 * Created by trist4n on 15/08/2016.
 */
package com.trist4n.lumisens.lumisens2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;


public class TimePickerFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {

    private static final String TAG = "TimePickerFragmentActivity";

    public static String timeString;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        String min;
        String hour;
        if (minute < 10) {
            min = "0" + minute;
        } else {
            min = Integer.toString(minute);
        }
        if (hourOfDay < 10) {
            hour = "0" + hourOfDay;
        } else {
            hour = Integer.toString(hourOfDay);
        }
        timeString = "00" + min + hour;
        if (DatePickerFragment.dateString != null && !DatePickerFragment.dateString.isEmpty()) {
            //communicationThread.write("T" + timeString + "0" + dateString);
        }

    }
}

