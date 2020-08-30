package com.example.gadsassignment1;

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

import java.util.List;

public class TopLearnerCustomAdapter extends ArrayAdapter<TopLearnerModel> {

    private Context context;
    private List<TopLearnerModel> topLearnerModelList;

    /**
     * Constructor
     *
     * @param context  The current context.
     * @param //resource The resource ID for a layout file containing a TextView to use when
     */
    public TopLearnerCustomAdapter(@NonNull Context context, List<TopLearnerModel>topLearnerModelList)  {
        super(context, R.layout.row_layout,topLearnerModelList);
        this.context = context;
        this.topLearnerModelList = topLearnerModelList;
    }

    ImageView ivPlaceHolder;
    TextView tvTopName,tvActivity,tvCountry;
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,null,true);

        ivPlaceHolder = view.findViewById(R.id.ivPlaceHolder);
        tvTopName=view.findViewById(R.id.tvTopName);
        tvActivity = view.findViewById(R.id.tvActivity);
        tvCountry= view.findViewById(R.id.tvCountry);

        tvTopName.setText(topLearnerModelList.get(position).getName());
        tvActivity.setText(topLearnerModelList.get(position).getHours()+"\t Learning Hours"+"\t ,");
        tvCountry.setText(topLearnerModelList.get(position).getCountry());
        Glide.with(context).load(topLearnerModelList.get(position).getBadge());

       /* ivPlaceHolder.setImageResource(topLearnerModelList.get(position).getBadge());*/


        return view/*super.getView(position, convertView, parent)*/;
    }

    @Override
    public int getCount() {
        return topLearnerModelList.size();
    }

    @Nullable
    @Override
    public TopLearnerModel getItem(int position) {
        return topLearnerModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
