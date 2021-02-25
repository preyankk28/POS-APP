package com.example.pocapp.Common;

import com.example.pocapp.Model.HistoryModelRefund;
import com.example.pocapp.Model.DonationLabelModel;
import com.example.pocapp.Model.HistoryModel;

import retrofit2.Call;
import retrofit2.http.GET;


    public interface GetDataService {

        @GET("Cases/665")//Teams/GetTeamList
        Call<DonationLabelModel> createdonationlabelsuccess();

        @GET("cases/665/donations/GetAllDonationForPOSByPosId?posId=0821856517")
        Call<HistoryModel> createhistorysuccess();
        @GET("Cases/665/Refunds")
        Call<HistoryModelRefund> createhistoryrefundsuccess();

}
