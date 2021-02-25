package com.example.pocapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pocapp.Model.DonationLabelModelcustomamount;
import com.example.pocapp.R;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import retrofit2.http.Url;

public class DonationLabelAdapter extends RecyclerView.Adapter<DonationLabelAdapter.myViewHolder>{
    private ArrayList<DonationLabelModelcustomamount> dataList;
    private Context context;

    public DonationLabelAdapter(ArrayList<DonationLabelModelcustomamount> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.donationlabellistrecycler, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.txtTitle.setText(dataList.get(position).getName());
        holder.amount.setText(dataList.get(position).getAmount());
        //Url url = new Url(dataList.get(position).getImage());
        Glide.with(holder.coverImage.getContext())
                .load(dataList.get(position).getImage())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.coverImage);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle, amount;
        private ImageView coverImage;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.text);
            amount = itemView.findViewById(R.id.amount);
            coverImage = itemView.findViewById(R.id.image);

        }
    }
}
