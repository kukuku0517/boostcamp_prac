package com.example.android.boostcamp_week01_practice;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv;
    EditText et;
    Button btn;
    ImageView iv;
    CheckBox cb;
    ToggleButton tb;
    Switch sw;
    RadioButton rb;
    RadioGroup rg;
    Spinner sp;
    SeekBar sb;
    AutoCompleteTextView ac;
    MultiAutoCompleteTextView mc;

    TimePicker tp;
    DatePicker dp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CompoundButton.OnCheckedChangeListener checkListener;

        tv = (TextView) findViewById(R.id.textView);
        et = (EditText) findViewById(R.id.editText);
        btn = (Button) findViewById(R.id.button);
        iv = (ImageView) findViewById(R.id.imageView);
        cb = (CheckBox) findViewById(R.id.checkBox);
        tb = (ToggleButton) findViewById(R.id.toggleButton);
        sw = (Switch) findViewById(R.id.switch1);
        rb = (RadioButton) findViewById(R.id.radioButton1);
        rg = (RadioGroup) findViewById(R.id.radioGroup);
        sp = (Spinner) findViewById(R.id.spinner);
        sb = (SeekBar) findViewById(R.id.seekBar);
        ac = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        mc = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView);
        tp = (TimePicker) findViewById(R.id.timePicker);
        dp = (DatePicker) findViewById(R.id.datePicker);


        tv.setOnClickListener(this);
        et.setOnClickListener(this);
        btn.setOnClickListener(this);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton1:
                        Toast.makeText(getApplicationContext(), rb.getText().toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton2:
                        Toast.makeText(getApplicationContext(), String.valueOf(checkedId), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton3:
                        Toast.makeText(getApplicationContext(), String.valueOf(checkedId), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });


        checkListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switch (buttonView.getId()) {
                    case R.id.checkBox:
                        if (isChecked) {
                            Toast.makeText(getApplicationContext(), "checkbox 0", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "checkbox 1", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.toggleButton:
                        if (isChecked) {
                            Toast.makeText(getApplicationContext(), "toggle checked", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "toggle not checked", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.switch1:
                        if (isChecked) {
                            Toast.makeText(getApplicationContext(), "switch checked", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "switch not checked", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }


            }
        };


        cb.setOnCheckedChangeListener(checkListener);
        tb.setOnCheckedChangeListener(checkListener);
        sw.setOnCheckedChangeListener(checkListener);

        sp.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sb.setProgress(50);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        String[] items = {"SM3", "SM5", "SM7", "SONATA", "AVANTE", "SOUL", "K5",
                "K7"};
        ac.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, items));

        mc.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        mc.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, items));

        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                tv.setText(hourOfDay+"시"+minute);
            }
        });
        dp.init(2017, 7, 6, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                tv.setText(year+"년"+monthOfYear+"월"+dayOfMonth+"일");
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.textView:
                Toast.makeText(this, tv.getText().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.editText:
                Toast.makeText(this, et.getText().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.button:
                Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show();
                break;


            case R.id.spinner:
            case R.id.seekBar:
            case R.id.autoCompleteTextView:
            case R.id.multiAutoCompleteTextView:
        }
    }
}
