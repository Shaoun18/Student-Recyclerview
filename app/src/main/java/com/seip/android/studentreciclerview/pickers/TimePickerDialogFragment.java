package com.seip.android.studentreciclerview.pickers;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.timepicker.TimeFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.SimpleTimeZone;

public class TimePickerDialogFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener  {
    private TimePickerDialogFragment.OnTimePickListener listener;
    public TimePickerDialogFragment(TimePickerDialogFragment.OnTimePickListener listener) {
        this.listener = listener;
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance(Locale.getDefault());
        final int hour = calendar.get(Calendar.HOUR);
        final int  minute = calendar.get(Calendar.MINUTE);
        return new TimePickerDialog(getActivity(),this,hour, minute,true);
    }
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        final Calendar calendar = Calendar.getInstance();
        calendar.set(hourOfDay,minute);
//        final TimeFormat sdf = new TimeFormat("hh:mm");
//        final String selectedTime = sdf.format(calendar.getTime());
//        listener.onDatePicked(selectedTime);
//        Log.d("TIME_PICKER", selectedTime);
    }
    public interface OnTimePickListener{
        void onDatePicked(String Date);
    }
}
