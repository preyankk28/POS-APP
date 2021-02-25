package com.example.pocapp.Screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.pocapp.Adapter.DonationLabelAdapter;
import com.example.pocapp.Adapter.HistoryRecyclerAdapter;
import com.example.pocapp.Common.ApiManager;
import com.example.pocapp.Common.GetDataService;
import com.example.pocapp.Common.JsonPlaceHolderAPI;
import com.example.pocapp.Common.MainApplication;
import com.example.pocapp.Common.RetrofitClientInstance;
import com.example.pocapp.Model.DonationLabelModel;
import com.example.pocapp.Model.DonationLabelModelcustomamount;
import com.example.pocapp.Model.HistoryModelAmountLadst4Digit;
import com.example.pocapp.Model.Screen2Model;
import com.example.pocapp.R;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DonationLabelsActivity extends AppCompatActivity {
   ArrayList<DonationLabelModelcustomamount> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_labels);
        arrayList = new ArrayList<>();
       ProgressDialog progressDoalog = new ProgressDialog(this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        /*Create handle for the RetrofitInstance interface*/
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<DonationLabelModel> call = service.createdonationlabelsuccess();
       call.enqueue(new Callback<DonationLabelModel>() {
           @Override
           public void onResponse(Call<DonationLabelModel> call, Response<DonationLabelModel> response) {
               progressDoalog.dismiss();
               DonationLabelModel responseUser = response.body();

             //  Toast.makeText(DonationLabelsActivity.this, "Something went wrong...Please try later!" + responseUser.getData(), Toast.LENGTH_SHORT).show();

              // Log.e("TAG", "obj"+ obj) ;
               Log.e("TAG", "msg"+ responseUser.getData()) ;
               Log.e("TAG", "msg"+ responseUser.getData().getAsJsonArray("customAmounts")) ;
               Log.e("TAG", "msg"+ responseUser.getData().getAsJsonArray("customAmounts")) ;
             //  JSONObject jsonObject = responseUser.getData();
               ArrayList<DonationLabelModelcustomamount> listdata = new ArrayList<>();
               JsonArray jArray = (JsonArray) responseUser.getData().getAsJsonArray("customAmounts");
               if (jArray != null) {
                   for (int i=0;i<jArray.size();i++){
                     //  listdata.add(DonationLabelModelcustomamount);
                   }
               }
               Gson gson = new Gson();
               Type type = new TypeToken<List<DonationLabelModelcustomamount>>(){}.getType();
               List<DonationLabelModelcustomamount> contactList = gson.fromJson(responseUser.getData().getAsJsonArray("customAmounts"), type);
               for (DonationLabelModelcustomamount contact : contactList){
                   Log.i("Contact Details", contact.getAmount()+ "-" + contact.getImage()+ "-" + contact.getName());
                   DonationLabelModelcustomamount donationLabelModelcustomamount = new DonationLabelModelcustomamount(contact.getName(),contact.getAmount(),contact.getImage());
                   arrayList.add(donationLabelModelcustomamount);
               }
               generateRecyclerView(arrayList);

               //  Log.e("TAG", "obj"+   responseUser.getData().
               
           }

           @Override
           public void onFailure(Call<DonationLabelModel> call, Throwable t) {
               progressDoalog.dismiss();
               Toast.makeText(DonationLabelsActivity.this, "Something went wrong...Please try later!" + t.getMessage(), Toast.LENGTH_SHORT).show();
               Log.e("TAG", "msg"+ t.getMessage()) ;
           }
       });
    }

    private void generateRecyclerView(ArrayList<DonationLabelModelcustomamount> arrayList) {
        RecyclerView recyclerView = findViewById(R.id.customRecyclerView);
        DonationLabelAdapter donationLabelAdapter = new DonationLabelAdapter(arrayList,this);
        recyclerView.setAdapter(donationLabelAdapter);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
    }
}