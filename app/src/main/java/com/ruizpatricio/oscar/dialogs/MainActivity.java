package com.ruizpatricio.oscar.dialogs;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {

    private Button errorDialog, timeDialog, dateDialog, fullScreenDialog;
    private Dialogs dialogs;
    private TimePickerDialog timePickerDialog;
    private DatePickerDialog datepickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getViews();
        setListeners();
    }

    private void getViews() {
        errorDialog = (Button)findViewById(R.id.error_dialog_button);
        timeDialog = (Button)findViewById(R.id.time_picker_dialog_button);
        dateDialog = (Button)findViewById(R.id.date_picker_dialog_button);
        fullScreenDialog = (Button)findViewById(R.id.full_screen_dialog_button);
    }

    private void setListeners() {
        //Show error dialog
        errorDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogs = new Dialogs(MainActivity.this);
                AlertDialog alertDialog = dialogs.showErrorDialog("Prueba", getString(R.string.description), "Aceptar");
                alertDialog.show();
            }
        });

        fullScreenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogs = new Dialogs(MainActivity.this);
                Dialog dialog = dialogs.showfullScreenErrorDialog("Prueba", getString(R.string.description), "Aceptar");
                dialog.show();
            }
        });

        //Show time picker dialog
        //Activity must implements TimePickerDialog.OnTimeSetListener
        timeDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogs = new Dialogs(MainActivity.this);
                timePickerDialog = dialogs.showTimeDialog();
                timePickerDialog.show();
            }
        });

        //Show Date Picker dialog
        //Activity must implements DatePickerDialog.OnTimeSetListener
        dateDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogs = new Dialogs(MainActivity.this);
                datepickerDialog = dialogs.showDatePickerDialog();
                datepickerDialog.show();
            }
        });
    }

    //Do something with time set on time picker dialog
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Toast.makeText(this, "Se ha elegido las " + hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();
    }

    //Do something with date set on date picker dialog
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Toast.makeText(this, "Se ha elegido el día " + dayOfMonth + " del mes " + month + " del año " + year, Toast.LENGTH_SHORT).show();
    }
}
