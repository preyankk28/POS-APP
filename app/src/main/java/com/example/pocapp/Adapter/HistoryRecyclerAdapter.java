package com.example.pocapp.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pocapp.Model.DonationLabelModelcustomamount;
import com.example.pocapp.Model.HistoryModelAmountLadst4Digit;
import com.example.pocapp.R;
import com.example.pocapp.Screens.History;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class HistoryRecyclerAdapter  extends RecyclerView.Adapter<HistoryRecyclerAdapter.myViewHolder>{
    private ArrayList<HistoryModelAmountLadst4Digit> dataList;
    private Context context;
    History history;

    public HistoryRecyclerAdapter(ArrayList<HistoryModelAmountLadst4Digit> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.historyrecycler, parent, false);

        return new HistoryRecyclerAdapter.myViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        //holder.amount.setText((int) dataList.get(position).getAmount());
          Double amount = dataList.get(position).getAmount();

        String s=String.valueOf(amount);
        holder.amount.setText(s);
        Log.e("TTAG", "m"+dataList.get(position) );
        holder.last4digit.setText(dataList.get(position).getCardLastFourDigit());
//        holder.options.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                history.onoptionsclick();
//            }
//        });
       //
       int num = dataList.size();
//       for(int i =0; i<num; i++ ){
//           holder.num.setText(i);
//
//       }

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView last4digit, amount, num;
        MaterialCardView options;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
         last4digit = itemView.findViewById(R.id.last4digit);
         options = itemView.findViewById(R.id.optionsMaterialcared);

         num = itemView.findViewById(R.id.number);

         amount =itemView.findViewById(R.id.amounthistory);

        }
    }
}
