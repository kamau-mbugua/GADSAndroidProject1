package com.example.gadsassignment1.topSkill;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.gadsassignment1.R;
import com.example.gadsassignment1.TopLearnerModel;

import java.util.List;

public class TopSkillCustomAdapter extends ArrayAdapter<TopSkillModel> {

    private Context context;
    private List<TopSkillModel> topSkillModelList;

    /**
     * Constructor
     *
     * @param context  The current context.
     * @param //resource The resource ID for a layout file containing a TextView to use when
     */
    public TopSkillCustomAdapter(@NonNull Context context, List<TopSkillModel>topSkillModelList) {
        super(context,  R.layout.row_layout_skills,topSkillModelList);
        this.context= context;
        this.topSkillModelList = topSkillModelList;


    }

    ImageView ivPlaceHolder;
    TextView tvTopName,tvActivity,tvCountry;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout_skills,null,true);

        ivPlaceHolder = view.findViewById(R.id.ivPlaceHolder1);
        tvTopName=view.findViewById(R.id.tvTopName1);
        tvActivity = view.findViewById(R.id.tvActivity1);
        tvCountry= view.findViewById(R.id.tvCountry1);

        tvTopName.setText(topSkillModelList.get(position).getName());
        tvActivity.setText(topSkillModelList.get(position).getSkill()+"\t Skill IQ Score"+"\t ,");
        tvCountry.setText(topSkillModelList.get(position).getCountry());
        Glide.with(context).load(topSkillModelList.get(position).getBadge());
        return view;
    }

    @Override
    public int getCount() {
        return topSkillModelList.size();
    }

    @Nullable
    @Override
    public TopSkillModel getItem(int position) {
        return topSkillModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
