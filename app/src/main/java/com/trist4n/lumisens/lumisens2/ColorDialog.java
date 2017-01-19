package com.trist4n.lumisens.lumisens2;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import yuku.ambilwarna.AmbilWarnaDialog;

/**
 * Created by trist4n on 15/08/2016.
 */
public class ColorDialog{

    public static int comingHourColor = 0xFF00FF00;
    public static int pastHourColor = 0xFFFF0000;
    public static int transitionColor = 0xFF000000;
    public static int lightColor;

    public static final String TAG = "ColorDialog";
    private Context activityContext;

    public ColorDialog(Context activity){
        activityContext = activity;
    }

    final AmbilWarnaDialog pastHourColorDialog = new AmbilWarnaDialog(activityContext, pastHourColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
        @Override
        public void onOk(AmbilWarnaDialog dialog, int color) {
            pastHourColor = color;
            String colorInt = formatIntColor(color);
            //communicationThread.write("V"+colorInt);
            //Toast.makeText(getApplicationContext(), "past hours color:"+ colorInt, Toast.LENGTH_LONG).show();
            // color is the color selected by the user.
        }

        @Override
        public void onCancel(AmbilWarnaDialog dialog) {
            // cancel was selected by the user
        }


    });


     final AmbilWarnaDialog comingHourColorDialog = new AmbilWarnaDialog(activityContext, comingHourColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
        @Override
        public void onOk(AmbilWarnaDialog dialog, int color) {
            comingHourColor = color;
            String colorInt = formatIntColor(color);
            //communicationThread.write("W"+colorInt);
            //Toast.makeText(getApplicationContext(), "coming hours color:"+ colorInt, Toast.LENGTH_LONG).show();
            // color is the color selected by the user.
        }

        @Override
        public void onCancel(AmbilWarnaDialog dialog) {
            // cancel was selected by the user
        }


    });



     final AmbilWarnaDialog transitionColorDialog = new AmbilWarnaDialog(activityContext, transitionColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
        @Override
        public void onOk(AmbilWarnaDialog dialog, int color) {
            transitionColor = color;
            String colorInt = formatIntColor(color);
            //communicationThread.write("X"+colorInt);
            //Toast.makeText(getApplicationContext(), "transition color:"+ colorInt, Toast.LENGTH_LONG).show();
            // color is the color selected by the user.
        }

        @Override
        public void onCancel(AmbilWarnaDialog dialog) {
            // cancel was selected by the user
        }


    });



     final AmbilWarnaDialog lightColorDialog = new AmbilWarnaDialog(activityContext, lightColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
        @Override
        public void onOk(AmbilWarnaDialog dialog, int color) {
            lightColor = color;
            String colorInt = formatIntColor(color);
            //communicationThread.write("M"+colorInt);
            //Toast.makeText(getApplicationContext(), "light color:"+ colorInt, Toast.LENGTH_LONG).show();
            // color is the color selected by the user.
        }

        @Override
        public void onCancel(AmbilWarnaDialog dialog) {
            // cancel was selected by the user
        }


    });

    /*
    setColorLight.setOnClickListener(new View.OnClickListener(){
        public  void onClick(View v){
            lightColorDialog.show();
        }

    });
    */

    private  String formatIntColor(int color){
        // splitting the color formatted in hex
        String hexColor = Integer.toHexString(color);
        String red = hexColor.substring(2,4);
        String green = hexColor.substring(4,6);
        String blue = hexColor.substring(6);

        //convert the hex of each color into hex
        int redInt = Integer.valueOf(red,16);
        int greenInt = Integer.valueOf(green,16);
        int blueInt = Integer.valueOf(blue,16);
        String redStg;
        String greenStg;
        String blueStg;

        //red formatting
        if (redInt<10){
            redStg = "00"+redInt;
        }else if (redInt>=10 && redInt< 100){
            redStg = "0"+ redInt;
        }else{
            redStg = Integer.toString(redInt);
        }
        // blue formatting
        if (blueInt<10){
            blueStg = "00"+blueInt;
        }else if (blueInt>=10 && blueInt< 100){
            blueStg = "0"+ blueInt;
        }else{
            blueStg = Integer.toString(blueInt);
        }
        // green formatting
        if (greenInt<10){
            greenStg = "00"+greenInt;
        }else if (greenInt>=10 && greenInt< 100){
            greenStg = "0"+ greenInt;
        }else{
            greenStg = Integer.toString(greenInt);
        }
        return redStg + greenStg + blueStg;
    }
}
