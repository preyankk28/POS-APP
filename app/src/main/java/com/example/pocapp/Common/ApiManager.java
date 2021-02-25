package com.example.pocapp.Common;

import com.example.pocapp.Model.AddPosMtdDonationModel;
import com.example.pocapp.Model.AddPostMTDSomeDonationModel;
import com.example.pocapp.Model.DonationLabelModel;
import com.example.pocapp.Model.MTDTScreenFixedModel;
import com.example.pocapp.Model.OJCModel;
import com.example.pocapp.Model.Screen2Model;
import com.example.pocapp.Model.Screen2RecurringDonationModel;
import com.example.pocapp.Model.SyncDonationModel;
import com.example.pocapp.Screens.DonationLabelsActivity;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    private static JsonPlaceHolderAPI service;
    private static ApiManager apiManager;

    private ApiManager() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.helpmefund.org/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(JsonPlaceHolderAPI.class);
        //https://api.helpmefund.org/api/Teams/GetTeamList
    }

    public static ApiManager getInstance() {
        if (apiManager == null) {
            apiManager = new ApiManager();
        }
        return apiManager;
    }

    public void screen2apicreatework(Screen2Model screen2Model, Callback<Screen2Model> callback) {
        Call<Screen2Model> userCall = service.createscreen2success(screen2Model);
        userCall.enqueue(callback);

    }
    public void createMtdtsuccess(MTDTScreenFixedModel mtdtScreenFixedModel, Callback<MTDTScreenFixedModel> callback){
        Call<MTDTScreenFixedModel> usercall = service.createsmtdtsuccess(mtdtScreenFixedModel);
        usercall.enqueue(callback);
    }
    public void createMtdtcontinuesuccess(AddPosMtdDonationModel addPosMtdDonationModell, Callback<AddPosMtdDonationModel> callback){
        Call<AddPosMtdDonationModel> usercall = service.createsmtdtconyinuefixedsuccess(addPosMtdDonationModell);
        usercall.enqueue(callback);
    }
    public void createMtdtcontinuesuccessforsome(AddPostMTDSomeDonationModel addPosMtdDonationModell, Callback<AddPostMTDSomeDonationModel> callback){
        Call<AddPostMTDSomeDonationModel> usercall = service.createsmtdtcontinuesomesuccess(addPosMtdDonationModell);
        usercall.enqueue(callback);
    }
    public void createscreen2Successforrecurringdonation(Screen2RecurringDonationModel addPosMtdDonationModell, Callback<Screen2RecurringDonationModel> callback){
        Call<Screen2RecurringDonationModel> usercall = service.createscreen2successforrecurring(addPosMtdDonationModell);

        usercall.enqueue(callback);
    }
    public void createojcSuccessforrecurringdonation(OJCModel addPosMtdDonationModell, Callback<OJCModel> callback){
        Call<OJCModel> usercall = service.createojcsuccess(addPosMtdDonationModell);

        usercall.enqueue(callback);
    }
    public void createscreen3done(SyncDonationModel addPosMtdDonationModell, Callback<SyncDonationModel> callback){
        Call<SyncDonationModel> usercall = service.createscreen3success(addPosMtdDonationModell);

        usercall.enqueue(callback);
    }

}