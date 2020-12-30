package com.hv.dlt22;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.List;

import static android.widget.RadioGroup.*;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ClubViewHolder> {

    List<Club> clubs;
    Context context;

    public RecyclerViewAdapter(List<Club> clubs,Context context) {
        this.clubs = clubs;
        this.context=context;
    }


    public class ClubViewHolder extends ViewHolder {
        CardView cardView;
        TextView clubName;
        TextView clubTitle;
        RadioGroup radioGroup;

        @SuppressLint("ResourceType")
        ClubViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
            clubName = (TextView) itemView.findViewById(R.id.subtitle);
            clubTitle = (TextView) itemView.findViewById(R.id.title);
           radioGroup =(RadioGroup) itemView.findViewById(R.id.radio);

        }

    }

    @NonNull
    @Override
    public ClubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout, parent, false);
        ClubViewHolder cvh = new ClubViewHolder(view);
        return cvh;
    }

    @Override
    public void onBindViewHolder(ClubViewHolder holder, int position) {

        RadioGroup radioGroup;
        RadioButton rb1,rb2;

        holder.clubName.setText(clubs.get(position).name);
        holder.clubTitle.setText(clubs.get(position).title);

        radioGroup = new RadioGroup(RecyclerViewAdapter.this.context);

        rb1 = new RadioButton(RecyclerViewAdapter.this.context);
        rb2 = new RadioButton(RecyclerViewAdapter.this.context);

        rb1.setText("Male");
        rb2.setText("Female");

        radioGroup.addView(rb1);
        radioGroup.addView(rb2);

    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
       return;
    }

    @Override
    public int getItemCount() {
        return clubs.size();
    }


}
