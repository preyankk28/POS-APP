package com.example.pocapp.Screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.pocapp.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
   TextView calculatingtext, setDate,dateView;
   TextView recurringdonationtext;
   TextView setNum;
   Context context;
    int mYear, mMonth, mDay;
    TabLayout tabLayout;
    ViewPager viewPager;
    MaterialCardView cadrdview, setforscheduledonatiom , setforrecurringdonation;
    MaterialCardView reccurrigschedulebox;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setforrecurringdonation = findViewById(R.id.setforrecurringdonation);
        setforscheduledonatiom = findViewById(R.id.setforscheduledonation);
        reccurrigschedulebox = findViewById(R.id.recurringschedulebox);
        setContentView(R.layout.activity_main);
        calculatingtext = findViewById(R.id.calculatingtext);
        recurringdonationtext = findViewById(R.id.recurringdonationtext);
        setNum = findViewById(R.id.setnum);
        setDate = findViewById(R.id.setdatetext);
        cadrdview = findViewById(R.id.card);

        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        Spinner donationtype = findViewById(R.id.DonationType);
        donationtype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                           @Override
                           public void onItemSelected(AdapterView<?> parentView,
                                                      View selectedItemView, int position, long id) {
                                                       try {
                                                           String businesstypestring = donationtype.getSelectedItem().toString();
                                                           Log.e("TAG", "ITEM" + businesstypestring);

                                                           if (position == 1) {

                                                               onRecurrinfDonationsClick();



                                                           } else if (position ==2){
                                                               //   etName.setHint("Business Name");


                                                               onScheduleDonationClick();
                                                           }


                                                       } catch (Exception e) {

                                                       }

                                                   }

                                                   @Override
                                                   public void onNothingSelected(AdapterView<?> parent) {
                                                       reccurrigschedulebox.setVisibility(View.GONE);

                                                   }
                                               });

            dateView = (TextView) findViewById(R.id.setdatetext);
        dateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dpd = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int day) {
                                c.set(year, month, day);
                                String date = new SimpleDateFormat("MM/dd/yyyy").format(c.getTime());
                                dateView.setText(date);

                                mYear = c.get(Calendar.YEAR);
                                mMonth = c.get(Calendar.MONTH);
                                mDay = c.get(Calendar.DAY_OF_MONTH);
                            }
                        }, mYear, mMonth, mDay);
                dpd.show();
            }
        });
    }
    private void updateLabel() {
        final Calendar myCalendar = Calendar.getInstance();
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        TextView edittext= (TextView) findViewById(R.id.setdatetext);
        edittext.setText(sdf.format(myCalendar.getTime()));
    }
    public void on1click(View view) {
        calculatingtext = findViewById(R.id.calculatingtext);
        String calculatingtextvalue = calculatingtext.getText().toString().trim();
        calculatingtext.setText(calculatingtextvalue + "1");
    }

    public void on2click(View view) {
        calculatingtext = findViewById(R.id.calculatingtext);
        String calculatingtextvalue = calculatingtext.getText().toString().trim();
        calculatingtext.setText(calculatingtextvalue + "2");
    }

    public void on3click(View view) {
        calculatingtext = findViewById(R.id.calculatingtext);
        String calculatingtextvalue = calculatingtext.getText().toString().trim();
        calculatingtext.setText(calculatingtextvalue + "3");
    }

    public void on4click(View view) {
        calculatingtext = findViewById(R.id.calculatingtext);
        String calculatingtextvalue = calculatingtext.getText().toString().trim();
        calculatingtext.setText(calculatingtextvalue + "4");
    }

    public void on5click(View view) {
        calculatingtext = findViewById(R.id.calculatingtext);
        String calculatingtextvalue = calculatingtext.getText().toString().trim();
        calculatingtext.setText(calculatingtextvalue + "5");
    }

    public void on6click(View view) {
        calculatingtext = findViewById(R.id.calculatingtext);
        String calculatingtextvalue = calculatingtext.getText().toString().trim();
        calculatingtext.setText(calculatingtextvalue + "6");
    }

    public void on7click(View view) {
        calculatingtext = findViewById(R.id.calculatingtext);
        String calculatingtextvalue = calculatingtext.getText().toString().trim();
        calculatingtext.setText(calculatingtextvalue + "7");
    }

    public void on8click(View view) {
        calculatingtext = findViewById(R.id.calculatingtext);
        String calculatingtextvalue = calculatingtext.getText().toString().trim();
        calculatingtext.setText(calculatingtextvalue + "8");
    }

    public void on9click(View view) {
        calculatingtext = findViewById(R.id.calculatingtext);
        String calculatingtextvalue = calculatingtext.getText().toString().trim();
        calculatingtext.setText(calculatingtextvalue + "9");
    }

    public void on0click(View view) {
        calculatingtext = findViewById(R.id.calculatingtext);
        String calculatingtextvalue = calculatingtext.getText().toString().trim();
        calculatingtext.setText(calculatingtextvalue + "0");
    }

    public void on000click(View view) {
        calculatingtext = findViewById(R.id.calculatingtext);
        String calculatingtextvalue = calculatingtext.getText().toString().trim();


        calculatingtext.setText(calculatingtextvalue + "000");
    }

    public void onclearclick(View view) {
        calculatingtext = findViewById(R.id.calculatingtext);


        String calculatingtextvalue = calculatingtext.getText().toString().trim();
        if (calculatingtextvalue.equals("")){
            return;

        }
        String finalafterclear =calculatingtextvalue.substring(0,calculatingtextvalue.length() - 1);
        calculatingtext.setText(finalafterclear);

    }

    public void on00click(View view) {
        calculatingtext = findViewById(R.id.calculatingtext);
        String calculatingtextvalue = calculatingtext.getText().toString().trim();
        calculatingtext.setText(calculatingtextvalue + "00");

    }

    public void onojcclick(){
        setforrecurringdonation = findViewById(R.id.setforrecurringdonation);
        setforscheduledonatiom = findViewById(R.id.setforscheduledonation);
        setforscheduledonatiom.setVisibility(View.GONE);
        setforrecurringdonation.setVisibility(View.GONE);
        MaterialCardView ojc = findViewById(R.id.ojccard);
        ojc.setVisibility(View.VISIBLE);
        MaterialCardView reccurrigschedulebox = findViewById(R.id.recurringschedulebox);
        reccurrigschedulebox.setVisibility(View.VISIBLE);
        TextView onScheduleDonationText = findViewById(R.id.onScheduleDonationtext);
        onScheduleDonationText.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        recurringdonationtext = findViewById(R.id.recurringdonationtext);
        recurringdonationtext.setBackgroundColor(Color.parseColor("#FF03DAC5"));
        MaterialCardView setDate , scheduledonation;
        setDate = findViewById(R.id.setdate);
        scheduledonation = findViewById(R.id.scheduledonation);
        setDate.setVisibility(View.GONE);
        LinearLayout daily2 = findViewById(R.id.linearlayoutdaily);
        daily2.setVisibility(View.VISIBLE);
        calculatingtext = findViewById(R.id.calculatingtext);
        String calculatingtextvalue = calculatingtext.getText().toString().trim();
        setNum.setText(calculatingtextvalue);

        Spinner donationtype = findViewById(R.id.DonationType);
        donationtype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView,
                                       View selectedItemView, int position, long id) {
                try {
                    String businesstypestring = donationtype.getSelectedItem().toString();
                    Log.e("TAG","ITEM" + businesstypestring);
                    if (position ==1){
                        //   etName.setHint("University");
                    }else{
                        //   etName.setHint("Business Name");
                    }


                } catch (Exception e) {

                }

            }



            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });


    }


    public void onRecurrinfDonationsClick() {
        MaterialCardView ojc = findViewById(R.id.ojccard);
        ojc.setVisibility(View.GONE);
        setforrecurringdonation = findViewById(R.id.setforrecurringdonation);
        setforscheduledonatiom = findViewById(R.id.setforscheduledonation);
        setforscheduledonatiom.setVisibility(View.GONE);
        setforrecurringdonation.setVisibility(View.VISIBLE);
        MaterialCardView reccurrigschedulebox = findViewById(R.id.recurringschedulebox);
         reccurrigschedulebox.setVisibility(View.VISIBLE);
        TextView onScheduleDonationText = findViewById(R.id.onScheduleDonationtext);
        onScheduleDonationText.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        recurringdonationtext = findViewById(R.id.recurringdonationtext);
        recurringdonationtext.setBackgroundColor(Color.parseColor("#FF03DAC5"));
        MaterialCardView setDate , scheduledonation;
        setDate = findViewById(R.id.setdate);
        scheduledonation = findViewById(R.id.scheduledonation);
        setDate.setVisibility(View.GONE);
        LinearLayout daily2 = findViewById(R.id.linearlayoutdaily);
        daily2.setVisibility(View.VISIBLE);
        calculatingtext = findViewById(R.id.calculatingtext);
        String calculatingtextvalue = calculatingtext.getText().toString().trim();
        setNum.setText(calculatingtextvalue);

        Spinner donationtype = findViewById(R.id.DonationType);
        donationtype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView,
                                       View selectedItemView, int position, long id) {
                try {
             String businesstypestring = donationtype.getSelectedItem().toString();
                    Log.e("TAG","ITEM" + businesstypestring);
                    if (position ==1){
                     //   etName.setHint("University");
                    }else{
                     //   etName.setHint("Business Name");
                    }


                } catch (Exception e) {

                }

            }



            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });





    }


    public void onScheduleDonationClick() {
        MaterialCardView ojc = findViewById(R.id.ojccard);
        ojc.setVisibility(View.GONE);
        setforrecurringdonation = findViewById(R.id.setforrecurringdonation);
        setforscheduledonatiom = findViewById(R.id.setforscheduledonation);
        setforrecurringdonation.setVisibility(View.GONE);
        setforscheduledonatiom.setVisibility(View.VISIBLE);
        MaterialCardView reccurrigschedulebox = findViewById(R.id.recurringschedulebox);
        reccurrigschedulebox.setVisibility(View.VISIBLE);
        recurringdonationtext = findViewById(R.id.recurringdonationtext);
        recurringdonationtext.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        TextView onScheduleDonationText = findViewById(R.id.onScheduleDonationtext);
        onScheduleDonationText.setBackgroundColor(Color.parseColor("#FF03DAC5"));
        calculatingtext = findViewById(R.id.calculatingtext);
        String calculatingtextvalue = calculatingtext.getText().toString().trim();
        setNum.setText(calculatingtextvalue);
        MaterialCardView setDate , scheduledonation;
        setDate = findViewById(R.id.setdate);
        scheduledonation = findViewById(R.id.scheduledonation);
        setDate.setVisibility(View.VISIBLE);
        LinearLayout daily = findViewById(R.id.linearlayoutdaily);
        daily.setVisibility(View.GONE);




    }

    public void screen2go(View view) {
        Intent intent = new Intent(this, Screen2Activity.class);
        //  intent.putExtra()
//        intent.putExtra("Email",Email.getText().toString().trim());
//        intent.putExtra("Password",Password.getText().toString().trim());
        TextView calculatingtext = findViewById(R.id.calculatingtext);
        intent.putExtra("Amount",calculatingtext.getText().toString().trim());
        intent.putExtra("Date",dateView.getText().toString().trim());

        startActivity(intent);

        finish();
    }

    public void selectdate(View view) {


    }


    public void MDTClick(View view2) {
//        Intent intent = new Intent(this,Screen3Activity.class);
//        startActivity(intent);
//
//        Dialog view=new Dialog(MainActivity.this);
//

  Intent intent = new Intent(MainActivity.this, MDTActivity.class);
  startActivity(intent);
  finish();

    }

    public void historyclick(View view) {
        Intent intent = new Intent(MainActivity.this, History.class);
        startActivity(intent);
        finish();
    }


    public void settingsclick(View view) {
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
        finish();


    }

    public void donationlabelsclick(View view) {
        Intent intent = new Intent(MainActivity.this, DonationLabelsActivity.class);
        startActivity(intent);
        finish();
    }

    public void screen2goforrecurring(View view) {
        Intent intent = new Intent(MainActivity.this, Screen2RecurrDonActivity.class);
        intent.putExtra("Amount",calculatingtext.getText().toString().trim());
        startActivity(intent);
        finish();
    }


    public void onojcclick(View view) {
//        TextView ojc = findViewById(R.id.ojc);
//        ojc.setBackgroundColor(Color.parseColor("#FF03DAC5"));
//        reccurrigschedulebox.setVisibility(View.VISIBLE);
//
       onojcclick();
    }


    public void screen2goforojc(View view) {
        Intent intent = new Intent(MainActivity.this, Screen2RecurrDonActivity.class);
        intent.putExtra("Amount",calculatingtext.getText().toString().trim());
        startActivity(intent);
        finish();

    }
}
