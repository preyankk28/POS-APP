package com.example.pocapp.Common;

import com.example.pocapp.Model.AddPosMtdDonationModel;
import com.example.pocapp.Model.AddPostMTDSomeDonationModel;
import com.example.pocapp.Model.DonationLabelModel;
import com.example.pocapp.Model.MTDTScreenFixedModel;
import com.example.pocapp.Model.OJCModel;
import com.example.pocapp.Model.Scree2ResultModel;
import com.example.pocapp.Model.Screen2Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

import com.example.pocapp.Model.Scree2ResultModel;
import com.example.pocapp.Model.Screen2Model;
import com.example.pocapp.Model.Screen2RecurringDonationModel;
import com.example.pocapp.Model.SyncDonationModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceHolderAPI {


    @POST("cases/665/donations/addposdonation")
    Call<Screen2Model> createscreen2success(@Body Screen2Model screen2Model);
    @POST("cases/665/donations/addposdonation")
    Call<Screen2RecurringDonationModel> createscreen2successforrecurring(@Body Screen2RecurringDonationModel screen2Model);

    @POST("Teams/GetTeamList")//Teams/GetTeamList
    Call<MTDTScreenFixedModel> createsmtdtsuccess(@Body MTDTScreenFixedModel mtdtScreenFixedModel);

    @POST("Cases/665/Donations/AddPosMtdDonation")//Teams/GetTeamList
    Call<AddPosMtdDonationModel> createsmtdtconyinuefixedsuccess(@Body AddPosMtdDonationModel addPosMtdDonationModel);

    @POST("Cases/665/Donations/AddPosMtdDonation")//Teams/GetTeamList
    Call<AddPostMTDSomeDonationModel> createsmtdtcontinuesomesuccess(@Body AddPostMTDSomeDonationModel addPosMtdDonationModel);

    @POST("cases/665/donations/AddPOSDonationOJC")//Teams/GetTeamList
    Call<OJCModel> createojcsuccess(@Body OJCModel addPosMtdDonationModel);

    @POST("cases/665/donations/SynDonationInfo")//Teams/GetTeamList
    Call<SyncDonationModel> createscreen3success(@Body SyncDonationModel addPosMtdDonationModel);




}

