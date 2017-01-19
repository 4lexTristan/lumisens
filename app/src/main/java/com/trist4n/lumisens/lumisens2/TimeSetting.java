package com.trist4n.lumisens.lumisens2;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

/**
 * Created by trist4n on 15/08/2016.
 */
public class TimeSetting extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String TAG = "TimeSettingActivity";

    public static TimeSetting newInstance(int sectionNumber) {
        TimeSetting fragment = new TimeSetting();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.timesetting,container,false);

        final Switch verticalMode = (Switch) v.findViewById(R.id.verticalModeSwitch);
        Button setTimeBtn = (Button) v.findViewById(R.id.pickTimeBtn);
        Button setDateBtn = (Button) v.findViewById(R.id.pickDateBtn);

        verticalMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    //Log.d(TAG, "send : Z");
                    BluetoothService.write("Z");
                    //communicationThread.write("Z");
                }else{
                    //Log.d(TAG, "send : Z");
                    BluetoothService.write("Z");
                    //communicationThread.write("Z");
                }
            }
        });

        setDateBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                DialogFragment newFragment = new TimePickerFragment();
                newFragment.show(getFragmentManager(), "timePicker");
            }
        });

        setTimeBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getFragmentManager(), "datePicker");
            }
        });

        return v;
    }
}
