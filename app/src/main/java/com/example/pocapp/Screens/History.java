package com.example.pocapp.Screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.pocapp.Adapter.HistoryRecyclerAdapter;
import com.example.pocapp.Common.GetDataService;
import com.example.pocapp.Common.RetrofitClientInstance;
import com.example.pocapp.Model.HistoryModelRefund;
import com.example.pocapp.Model.HistoryModel;
import com.example.pocapp.Model.HistoryModelAmountLadst4Digit;
import com.example.pocapp.R;
import com.google.android.material.card.MaterialCardView;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ProgressDialog progressDoalog = new ProgressDialog(this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<HistoryModel> call = service.createhistorysuccess();
       call.enqueue(new Callback<HistoryModel>() {
           @Override
           public void onResponse(Call<HistoryModel> call, Response<HistoryModel> response) {
               progressDoalog.dismiss();
               HistoryModel responseUser = response.body();
               Log.e("TAG", "Gson" + new Gson().toJson(responseUser));

               //  Toast.makeText(DonationLabelsActivity.this, "Something went wrong...Please try later!" + responseUser.getData(), Toast.LENGTH_SHORT).show();

               Log.e("TAG", "msg"+ responseUser.getData()) ;
               makerecyclerview(responseUser.getData());

           }

           @Override
           public void onFailure(Call<HistoryModel> call, Throwable t) {
               Toast.makeText(History.this, "Something went wrong...Please try later!" + t.getMessage(), Toast.LENGTH_SHORT).show();
               Log.e("TAG", "msg"+ t.getMessage()) ;

           }
       });
    }
    private void makerecyclerview(ArrayList<HistoryModelAmountLadst4Digit> historyModelAmountLadst4Digits) {
        HistoryRecyclerAdapter historyRecyclerAdapter = new HistoryRecyclerAdapter(historyModelAmountLadst4Digits,this);
        RecyclerView history = findViewById(R.id.historyrecycler);
        history.setAdapter(historyRecyclerAdapter);


    }
    public void RefundClick(View view) {
        ProgressDialog progressDoalog = new ProgressDialog(this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<HistoryModelRefund> call = service.createhistoryrefundsuccess();
        call.enqueue(new Callback<HistoryModelRefund>() {
            @Override
            public void onResponse(Call<HistoryModelRefund> call, Response<HistoryModelRefund> response) {
                progressDoalog.dismiss();
                HistoryModelRefund responseUser = response.body();
                Toast.makeText(History.this, "Response is"+ responseUser.getData(), Toast.LENGTH_SHORT).show();
                //Log.e("TAG", "msg"+ t.getMessage()) ;
            }

            @Override
            public void onFailure(Call<HistoryModelRefund> call, Throwable t) {
                Log.e("TAG", "msg"+ t.getMessage()) ;

            }
        });


    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
    }
    public void onoptionsclick(){
        MaterialCardView optionsbox = findViewById(R.id.optionsbox);
        optionsbox.setVisibility(View.VISIBLE);


    }
    public void showmoredetails(View view) {
        MaterialCardView showfield = findViewById(R.id.showfields);
        showfield.setVisibility(View.VISIBLE);
    }

}