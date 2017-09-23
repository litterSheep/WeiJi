package com.ly.weiji.ui;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;

import com.appeaser.sublimepickerlibrary.datepicker.SelectedDate;
import com.appeaser.sublimepickerlibrary.helpers.SublimeOptions;
import com.appeaser.sublimepickerlibrary.recurrencepicker.SublimeRecurrencePicker;
import com.ly.weiji.R;
import com.ly.weiji.view.SublimePickerFragment;
import com.orhanobut.logger.Logger;

import java.util.Calendar;

public class MainActivity extends BaseTitleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findFragment(HomeFragment.class) == null) {
            loadRootFragment(R.id.fl_container, HomeFragment.newInstance());
        }

        findViewById(R.id.tv_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SublimePickerFragment pickerFrag = SublimePickerFragment.getInstance();
                pickerFrag.setCallback(new SublimePickerFragment.Callback() {
                    @Override
                    public void onCancelled() {

                    }

                    @Override
                    public void onDateTimeRecurrenceSet(SelectedDate selectedDate, int hourOfDay, int minute, SublimeRecurrencePicker.RecurrenceOption recurrenceOption, String recurrenceRule) {
                        int year = selectedDate.getStartDate().get(Calendar.YEAR);
                        int month = selectedDate.getStartDate().get(Calendar.MONTH);
                        int day = selectedDate.getStartDate().get(Calendar.DAY_OF_MONTH);

                        Logger.i(">>>>>>>year:" + year + " month:" + month + " day:" + day + " recurrenceRule:" + recurrenceRule);
                    }
                });

                SublimeOptions options = new SublimeOptions();

                Calendar startCal = Calendar.getInstance();
                startCal.set(startCal.get(Calendar.YEAR) - 10, startCal.get(Calendar.MONTH), startCal.get(Calendar.DAY_OF_MONTH));
                Calendar endCal = Calendar.getInstance();
                endCal.set(endCal.get(Calendar.YEAR), endCal.get(Calendar.MONTH), endCal.get(Calendar.DAY_OF_MONTH));
                //range
                options.setDateParams(startCal, endCal);
                // Enable/disable the date range selection feature
                options.setCanPickDateRange(false);
                options.setPickerToShow(SublimeOptions.Picker.DATE_PICKER);
                options.setDisplayOptions(SublimeOptions.ACTIVATE_DATE_PICKER);

                Bundle bundle = new Bundle();
                bundle.putParcelable("SUBLIME_OPTIONS", options);
                pickerFrag.setArguments(bundle);

                pickerFrag.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
                pickerFrag.show(getSupportFragmentManager(), "SUBLIME_PICKER");
            }
        });
    }

    @Override
    public void onBackPressedSupport() {

        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            pop();
        } else {
            moveTaskToBack(true);
        }
    }

}
