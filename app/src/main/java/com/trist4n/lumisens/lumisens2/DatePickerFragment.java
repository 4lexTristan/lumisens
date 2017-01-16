package com.trist4n.lumisens.lumisens2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    private static final String TAG = "DatePickerFragmentActivity";
    public static String dateString;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        String monthStg;
        String dayStg;
        month = month + 1;
        if (month < 10) {
            monthStg = "0" + month;
        } else {
            monthStg = Integer.toString(month);
        }
        if (day < 10) {
            dayStg = "0" + day;
        } else {
            dayStg = Integer.toString(day);
        }
        dateString = dayStg + monthStg + Integer.toString(year);
        //Toast.makeText(this, dateString, Toast.LENGTH_LONG).show();
        if (TimePickerFragment.timeString != null && !TimePickerFragment.timeString.isEmpty()) {
            //communicationThread.write("T" + timeString + "0" + dateString);
        }

    }
}
