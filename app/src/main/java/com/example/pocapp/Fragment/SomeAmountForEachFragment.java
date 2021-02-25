package com.example.pocapp.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pocapp.Adapter.MDTRecyclerAdapter;
import com.example.pocapp.Common.MainApplication;
import com.example.pocapp.Model.AddPosMtdDonationModel;
import com.example.pocapp.Model.AddPostMTDSomeDonationModel;
import com.example.pocapp.Model.Api;
import com.example.pocapp.Model.MDTRecyclerModel;
import com.example.pocapp.Model.MTDTScreenFixedModel;
import com.example.pocapp.Model.pOSMTDDonationVMsModel;
import com.example.pocapp.Model.pOSMTDDonationVMsModelforSome;
import com.example.pocapp.R;
import com.example.pocapp.Screens.Screen3Activity;
import com.google.android.material.card.MaterialCardView;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SomeAmountForEachFragment extends Fragment {
    private Context context;
    View view;
    String teammemberstring;


    ArrayList<String> amount = new ArrayList<String>();
    ArrayList<String> textprivate = new ArrayList<String>();
    RecyclerView recyclerView;
    String privatetext;
    EditText amounttext;
    EditText commentcustom;
    ArrayList<MDTRecyclerModel> cartModelList;
    ArrayList<String> mtdarraylist;
    Button continuebutton;
    ArrayList<pOSMTDDonationVMsModelforSome> arrayforcontinueList;
    ProgressBar mProgressBar;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.mdtsomeamount,container,false);
        init();
        return view;
    }

    private void init() {
        initElements();
        initListeners();
        initActions();

    }

    private void initActions() {
        continuebutton = view.findViewById(R.id.continuebutton);
        continuebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MakeAPIcallContinueButton();



            }
        });
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


    private void MakeAPIcallContinueButton() {
        mProgressBar = view.findViewById(R.id.progressbar);
        showProgressBar();
        mProgressBar.setVisibility(View.VISIBLE);
        AddPostMTDSomeDonationModel addPosMtdDonationModel = new AddPostMTDSomeDonationModel(665, "0123","4242424242424242",
                "123",100,"0821856517",0,arrayforcontinueList);
        MainApplication.apiManager.createMtdtcontinuesuccessforsome(addPosMtdDonationModel, new Callback<AddPostMTDSomeDonationModel>() {
            @Override
            public void onResponse(Call<AddPostMTDSomeDonationModel> call, Response<AddPostMTDSomeDonationModel> response) {
                AddPostMTDSomeDonationModel responseUser = response.body();
                Log.e("TAG", "Gson" + new Gson().toJson(responseUser));
                if (response.isSuccessful() && responseUser != null) {
                    hideProgressBar();
                    mProgressBar.setVisibility(View.INVISIBLE);
                    //  Toast.makeText(Screen2Activity.this,
//                            String.format("User %s with job %s was created at %s with id %s",
                    responseUser.getMessage();
                    responseUser.getDonationId();

                    Log.e("TAG", "Msg" + responseUser.getMessage());
                    Log.e("TAG", "Msg" + responseUser.getDonationId());
                    Intent intent1 = new Intent(context, Screen3Activity.class);
                    intent1.putExtra("DonationId", responseUser.getDonationId());

                    startActivity(intent1);
                    Toast.makeText(context,
                            responseUser.getMessage(),Toast.LENGTH_LONG).show();
//                                    responseUser.getCreatedAt(),
//                                    responseUser.getId()
//                                   ),
//                            Toast.LENGTH_LONG)
//                            .show();
                } else {
                    Toast.makeText(context,
                            String.format("Response is %s", String.valueOf(response.code()))
                            , Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<AddPostMTDSomeDonationModel> call, Throwable t) {

            }
        });
    }


    private void initListeners() {
    }

    private void initElements() {
        arrayforcontinueList = new ArrayList<>();
        pOSMTDDonationVMsModelforSome pOSMTDDonationVMsModel= new pOSMTDDonationVMsModelforSome("288", "100","80");
        arrayforcontinueList.add(pOSMTDDonationVMsModel);


        cartModelList = new ArrayList<>();
        MTDTScreenFixedModel mtdtScreenFixedModel = new MTDTScreenFixedModel(665);
        Log.e("TAG", "Model"+ new Gson().toJson(mtdtScreenFixedModel));
        mtdarraylist = new ArrayList<>();
        MainApplication.apiManager.createMtdtsuccess(mtdtScreenFixedModel, new Callback<MTDTScreenFixedModel>() {
            @Override
            public void onResponse(Call<MTDTScreenFixedModel> call, Response<MTDTScreenFixedModel> response) {

                Log.e("TAG", "Msg" + response);
                MTDTScreenFixedModel    responseUser = response.body();
                if(response.body().getData().contains("")) {
                    // here you are getting item which matches inside your list

                }

                Log.e("TAG", "Gson" + new Gson().toJson(responseUser));
                Log.e("TAG", "Gson" + new Gson().toJson(responseUser.getData()));
                ArrayList<Api> array = responseUser.getData();


                for(int i=0 ; i<array.size() ; i++){

                    Api object = array.get(i);  //getting single object from Arraylist
                    String fname =   object.getfName();
                    String teamname =   object.getTeamName();
                    mtdarraylist.add(teamname);
                    Log.e("TAG", "MYD"+ mtdarraylist);


                    Spinner spin = (Spinner) view.findViewById(R.id.daily);
                    ArrayAdapter<String> adapter =
                            new ArrayAdapter<String>(context.getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, mtdarraylist);
                    adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);

                    spin.setAdapter(adapter);
                    // spin.setOnItemSelectedListener(context);

                    //Creating the ArrayAdapter instance having the country list
                    //   ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item, );
                    //   ArrayAdapter aa = new ArrayAdapter(context,R.layout.support_simple_spinner_dropdown_item,);
                    //aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    //Setting the ArrayAdapter data on the Spinner
                    //spin.setAdapter(aa);
                    Log.e("TAG", "Msg" + fname);
                    Log.e("TAG", "Msg" + teamname);

                }

                for (int i=0; i<responseUser.getData().size(); i++){

                    //   if (responseUser.getData().containsAll())
                }
                if (response.isSuccessful() && responseUser != null) {
                    response.body();






                } else {
                    Toast.makeText(context,
                            String.format("Response is %s", String.valueOf(response.code()))
                            , Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<MTDTScreenFixedModel> call, Throwable t) {
                //progressBar.setVisibility(View.GONE);

                Toast.makeText(context,
                        "Error is " + t.getMessage()
                        , Toast.LENGTH_LONG).show();
            }
        });





//        MaterialCardView addTeamButton = view.findViewById(R.id.addteambutton);
//        addTeamButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                recyclerView = (RecyclerView) view.findViewById(R.id.table);
//                // set a LinearLayoutManager with default vertical orientation
//
//                //  call the constructor of CustomAdapter to send the reference and data to Adapter
//                // set the Adapter to RecyclerView
//                amounttext = view.findViewById(R.id.amountmdtcustom);
//                amount.add(amounttext.getText().toString().trim());
//                commentcustom = view.findViewById(R.id.commentcustom);
//                Spinner daily = view.findViewById(R.id.daily);
//                daily.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                    @Override
//                    public void onItemSelected(AdapterView<?> parentView,
//                                               View selectedItemView, int position, long id) {
//                        try {
////                    businesstypestring = Businesstype.getSelectedItem().toString();
////
////                    int userChoice = Businesstype.getSelectedItemPosition();
////                    SharedPreferences sharedPref = getSharedPreferences("FileName",0);
////                    SharedPreferences.Editor prefEditor = sharedPref.edit();
////                    prefEditor.putInt("userChoiceSpinner",userChoice);
////                    prefEditor.commit();
////
////                    if (position ==1){
////                        etName.setHint("University");
////                    }else{
////                        etName.setHint("Business Name");
////                    }
//
//                        } catch (Exception e) {
//
//                        }
//
//                    }
//
//
//
//                    @Override
//                    public void onNothingSelected(AdapterView<?> parentView) {
//
//                    }
//
//                });
//
//
//
//                CheckBox checkBox = view.findViewById(R.id.checkbox);
//                if (checkBox.isChecked()){
//                    privatetext = "Private";
//                }else{
//                    privatetext = "Not Private";
//                }
//                textprivate.add(privatetext);
//
//                MDTRecyclerModel mdtRecyclerModel = new MDTRecyclerModel("TT","200","2");
//                cartModelList.add(mdtRecyclerModel);
//                MDTRecyclerAdapter customAdapter = new MDTRecyclerAdapter(cartModelList,context);
//                recyclerView.setAdapter(customAdapter);
//
//            }
//        });
        MaterialCardView addTeamButton = view.findViewById(R.id.addteambutton);
        addTeamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView = (RecyclerView) view.findViewById(R.id.table);
                // set a LinearLayoutManager with default vertical orientation

                //  call the constructor of CustomAdapter to send the reference and data to Adapter
                // set the Adapter to RecyclerView
                amounttext = view.findViewById(R.id.amountmdtcustom);
                amount.add(amounttext.getText().toString().trim());
                commentcustom = view.findViewById(R.id.commentcustom);
                Spinner daily = view.findViewById(R.id.daily);
                daily.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parentView,
                                               View selectedItemView, int position, long id) {
                        try {
                            teammemberstring = daily.getSelectedItem().toString();

                        } catch (Exception e) {

                        }

                    }



                    @Override
                    public void onNothingSelected(AdapterView<?> parentView) {

                    }

                });



                CheckBox checkBox = view.findViewById(R.id.checkbox);
                if (checkBox.isChecked()){
                    privatetext = "Private";
                }else{
                    privatetext = "Not Private";
                }
                textprivate.add(privatetext);
                EditText privatetext = view.findViewById(R.id.commentcustom);
                String comment = privatetext.getText().toString().trim();
                String amount = amounttext.getText().toString().trim();
                MDTRecyclerModel mdtRecyclerModel = new MDTRecyclerModel(teammemberstring,amount,comment);
                cartModelList.add(mdtRecyclerModel);
                MDTRecyclerAdapter customAdapter = new MDTRecyclerAdapter(cartModelList,context);
                recyclerView.setAdapter(customAdapter);

            }
        });



    }
}
