package com.example.rabson.ea.AcademicYear;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rabson.ea.R;

import java.util.ArrayList;

/**
 * Created by Rabson on 10/8/2016.
 */
public class AcademicAdapter extends RecyclerView.Adapter<AcademicAdapter.AcademicViewHolder> {

    private ArrayList<AcademicData> arrayList = new ArrayList<>();
    Context context;

    public AcademicAdapter(ArrayList<AcademicData> arrayList,Context context){
        this.arrayList = arrayList;
        this.context = context;
    }
    @Override
    public AcademicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.academic_card_layout,parent,false);

        AcademicViewHolder academicViewHolder = new AcademicViewHolder(view,context);
        return academicViewHolder;
    }

    @Override
    public void onBindViewHolder(AcademicViewHolder holder, int position) {
         AcademicData academicData = arrayList.get(position);
         holder.academicImage.setImageResource(academicData.getImg_res());
         holder.academicText.setText(academicData.getTitle());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class AcademicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView academicImage;
        TextView academicText;
        Context context;
        public AcademicViewHolder(View view,Context context){
            super(view);
            this.context = context;
            view.setOnClickListener(this);
            academicImage = (ImageView) view.findViewById(R.id.iv_academic_logo);
            academicText = (TextView) view.findViewById(R.id.tv_academic_name);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(this.context,SetAcademicYearActivity.class);
            this.context.startActivity(intent);
        }
    }
}
