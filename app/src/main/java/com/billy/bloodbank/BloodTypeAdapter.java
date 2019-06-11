package com.billy.bloodbank;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

public class BloodTypeAdapter extends RecyclerView.Adapter<BloodTypeAdapter.BloodTypeViewHolder> {

    private Context mCtx;
    private List<BloodType> BloodTypeList;

    public BloodTypeAdapter(Context mCtx, List<BloodType> BloodTypeList) {
        this.mCtx = mCtx;
        this.BloodTypeList = BloodTypeList;
    }

    @Override
    public BloodTypeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.bloodgroup_cardlayout, null);
        return new BloodTypeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BloodTypeViewHolder holder, int position) {
        //getting the product of the specified position
        BloodType BloodType = BloodTypeList.get(position);

        //binding the data with the viewholder views
        holder.textViewBlood_type.setText(BloodType.getBlood_type());
        holder.textViewUnits.setText(String.valueOf(BloodType.getUnits()));

    }

    @Override
    public int getItemCount() {
        return BloodTypeList.size();
    }

    class BloodTypeViewHolder extends RecyclerView.ViewHolder {

        TextView textViewBlood_type, textViewUnits;

        private BloodTypeViewHolder(View itemView) {
            super(itemView);

            textViewBlood_type = itemView.findViewById(R.id.textViewBlood_type);
            textViewUnits = itemView.findViewById(R.id.textViewUnits);
        }
    }


}
