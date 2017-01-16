/**
 * Created by trist4n on 15/08/2016.
 *
 */


package com.trist4n.lumisens.lumisens2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;


public class ColorSetting extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String TAG = "ColorSettingActivity";

    private Activity context;

    public static ColorSetting newInstance(int sectionNumber) {
        ColorSetting fragment = new ColorSetting();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.color_setting,container,false);

        Button setColorPassedHour = (Button) v.findViewById(R.id.passedHourColorBtn);
        Button setColorComingHour = (Button) v.findViewById(R.id.comingHourColorBtn);
        Button setColorTransition = (Button) v.findViewById(R.id.transitionColorBtn);
        SeekBar luminBar = (SeekBar) v.findViewById(R.id.luminosity);

        luminBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            int progressChanged =0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                progressChanged = progress;
            }
            public void onStartTrackingTouch(SeekBar seekBar){

            }
            public void onStopTrackingTouch(SeekBar seekBar){
                Log.d(TAG, "luminosity:"+ progressChanged);
                //communicationThread.write("L"+Integer.toString(progressChanged));
            }
        });

        setColorTransition.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View v){
                ColorDialog diag = new ColorDialog(context);
                diag.transitionColorDialog.show();
            }

        });

        setColorComingHour.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View v){
                ColorDialog diag = new ColorDialog(getContext());
                diag.comingHourColorDialog.show();
            }

        });

        setColorPassedHour.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View v){
                ColorDialog diag = new ColorDialog(getContext());
                diag.pastHourColorDialog.show();
            }

        });

        return v;
    }
}
