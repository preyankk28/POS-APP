package com.example.pocapp.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pocapp.Common.MainApplication;
import com.example.pocapp.Model.Screen2Model;
import com.example.pocapp.Model.Screen2RecurringDonationModel;
import com.example.pocapp.R;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Screen2RecurrDonActivity extends AppCompatActivity {
    EditText expirydate,cvv;

    ProgressBar mProgressBar;
    EditText  cardno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
        expirydate = findViewById(R.id.expirydate);
        expirydate.setText("0222");
        cardno = findViewById(R.id.cardno);
        cardno.setText("4242424242424242");
        mProgressBar = findViewById(R.id.progressbar);
        cvv= findViewById(R.id.cvv);
        cvv.setText("123");




    }
    public void processclick(View view) {

        showProgressBar();
        mProgressBar.setVisibility(View.VISIBLE);
        Intent intent = getIntent();


        String amount=  intent.getStringExtra("Amount");
        Screen2RecurringDonationModel screen2RecurringDonationModel = new Screen2RecurringDonationModel("0821856517",3,"day",
                true,Integer.parseInt(amount),expirydate.getText().toString().trim(),cardno.getText().toString().trim(),cvv.getText().toString().trim()
        ,"2021-02-19T08:45:24.281Z",false);

        Log.e("TAG", "Model"+ new Gson().toJson(screen2RecurringDonationModel));
        Retrofit builder = new Retrofit.Builder()
                .baseUrl("https://api.helpmefund.org/api/cases/665/donations/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MainApplication.apiManager.createscreen2Successforrecurringdonation(screen2RecurringDonationModel, new Callback<Screen2RecurringDonationModel>() {
            @Override
            public void onResponse(Call<Screen2RecurringDonationModel> call, Response<Screen2RecurringDonationModel> response) {
                hideProgressBar();
                mProgressBar.setVisibility(View.INVISIBLE);
                //  progressBar.setVisibility(View.GONE);
                Log.e("TAG", "Msg" + response);
                Screen2RecurringDonationModel responseUser = response.body();
                Log.e("TAG", "Gson" + new Gson().toJson(responseUser));
                if (response.isSuccessful() && responseUser != null) {
                    //  Toast.makeText(Screen2Activity.this,
//                            String.format("User %s with job %s was created at %s with id %s",
                    responseUser.getMessage();
                    responseUser.getDonationId();

                    Log.e("TAG", "Msg" + responseUser.getMessage());
                    Log.e("TAG", "Msg" + responseUser.getDonationId());
                    Intent intent1 = new Intent(Screen2RecurrDonActivity.this, Screen3Activity.class);
                    intent1.putExtra("DonationId", responseUser.getDonationId());

                    startActivity(intent1);
//                                    responseUser.getCreatedAt(),
//                                    responseUser.getId()
//                                   ),
                } else {
                    Toast.makeText(Screen2RecurrDonActivity.this,
                            String.format("Response is %s", String.valueOf(response.code()))
                            , Toast.LENGTH_LONG).show();
                }
            }


            @Override
            public void onFailure(Call<Screen2RecurringDonationModel> call, Throwable t) {

            }
        });


    }
    public void setProgressBar(ProgressBar progressBar) {
        mProgressBar = progressBar;
    }

    public void showProgressBar() {
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

    public void hideProgressBar() {
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.INVISIBLE);
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
    }
}

