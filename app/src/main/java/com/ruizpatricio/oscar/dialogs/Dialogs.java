package com.ruizpatricio.oscar.dialogs;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Calendar;

/**
 * Created by Oscar on 26/06/2017.
 */

public class Dialogs extends Dialog{

    //Local variables
    private Context context;
    private AlertDialog errorDialog;
    private Dialog eDialog;

    //Constructor
    public Dialogs(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    //Create error dialog (custom)
    public AlertDialog showErrorDialog (String title, String description, String closeButton) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        //Inflate dialog xml
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.error_dialog, null);

        builder.setView(v);
        builder.setCancelable(false);

        //set views
        TextView titleTV = (TextView)v.findViewById(R.id.title);
        TextView descriptionTV = (TextView)v.findViewById(R.id.description);
        Button button = (Button)v.findViewById(R.id.accept);

        //set info
        titleTV.setText(title);
        descriptionTV.setText(description);
        button.setText(closeButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                errorDialog.dismiss();
            }
        });
        errorDialog = builder.create();
        return errorDialog;
    }

    //Create time picker dialog
    public TimePickerDialog showTimeDialog() {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(context, (TimePickerDialog.OnTimeSetListener)(Activity)context, hour, minute, true);
    }

    //Create Date Picker Dialog
    public DatePickerDialog showDatePickerDialog() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(context, (DatePickerDialog.OnDateSetListener)(Activity)context, year, month, day);
    }

    //Create full screen error dialog (custom)
    public Dialog showfullScreenErrorDialog (String title, String description, String closeButton) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(context, android.R.style.Theme_NoTitleBar_Fullscreen);

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.error_dialog, null);

        builder.setView(v);
        builder.setCancelable(false);

        TextView titleTV = (TextView)v.findViewById(R.id.title);
        TextView descriptionTV = (TextView)v.findViewById(R.id.description);
        Button button = (Button)v.findViewById(R.id.accept);

        titleTV.setText(title);
        descriptionTV.setText(description);
        button.setText(closeButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eDialog.dismiss();
            }
        });
        eDialog = builder.create();

        return eDialog;
    }
}
