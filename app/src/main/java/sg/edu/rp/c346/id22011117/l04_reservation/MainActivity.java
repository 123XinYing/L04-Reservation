package sg.edu.rp.c346.id22011117.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button date;
    Button time;
    TextView tvDisplay;
    Button reset;
    Button confirm;
    CheckBox smoke;
    CheckBox non_smoke;
    TextView tvShow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        date = findViewById(R.id.buttonDisplayDate);
        time = findViewById(R.id.buttonDisplayTime);
        tvDisplay = findViewById(R.id.textViewDisplay);
        reset = findViewById(R.id.buttonReset);
        confirm = findViewById(R.id.buttonConfirm);
        smoke = findViewById(R.id.checkBoxSmoke);
        non_smoke = findViewById(R.id.checkBoxNonSmoke);
        tvShow = findViewById(R.id.textViewDisplay);

        tp.setIs24HourView(true);
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = tp.getCurrentHour();
                int min = tp.getCurrentMinute();

                String formattedTime = String.format(Locale.getDefault(), "%02d:%02d", hour, min);

                tvDisplay.setText("Time: " + formattedTime);

            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = dp.getYear();
                int month = dp.getMonth();
                int monthDay = dp.getDayOfMonth();

                String formattedDate = String.format(Locale.getDefault(), "%02d/%02d/%04d", monthDay, month + 1, year);

                tvDisplay.setText("Date: " + formattedDate);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setCurrentHour(7);
                tp.setCurrentMinute(30);

                dp.updateDate(2023, 6, 1);

                Toast.makeText(MainActivity.this, "Reset button clicked", Toast.LENGTH_SHORT).show();


            }
        });

    }
}