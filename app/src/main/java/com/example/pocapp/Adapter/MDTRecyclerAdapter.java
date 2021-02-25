package com.example.pocapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pocapp.Model.MDTRecyclerModel;
import com.example.pocapp.R;

import java.util.ArrayList;
import java.util.List;

public class MDTRecyclerAdapter extends RecyclerView.Adapter<MDTRecyclerAdapter.myViewHolder> {

private ArrayList<MDTRecyclerModel> MDTModelList;
Context context;

    public MDTRecyclerAdapter(ArrayList<MDTRecyclerModel> MDTModelList, Context context) {
        this.MDTModelList = MDTModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mdtrowlayout, parent, false);
        // set the view's size, margins, paddings and layout parameters

        myViewHolder vh = new myViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        MDTRecyclerModel cartModel = MDTModelList.get(position);
        holder.temmember.setText(cartModel.getTeamMember());
        holder.textprivate.setText(cartModel.getPrivateText());
        holder.amount.setText(cartModel.getAmount());


    }


    @Override
    public int getItemCount() {
        return MDTModelList.size();
    }
    public  class myViewHolder extends RecyclerView.ViewHolder {
        TextView no, temmember, amount , textprivate, Action;

        public myViewHolder(@NonNull View itemView) {

            super(itemView);
            no = itemView.findViewById(R.id.number);
            temmember = itemView.findViewById(R.id.team);
            amount = itemView.findViewById(R.id.amount);
            textprivate = itemView.findViewById(R.id.privatetext);
            Action = itemView.findViewById(R.id.action);

        }
    }
}
