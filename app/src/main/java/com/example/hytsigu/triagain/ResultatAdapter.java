package com.example.hytsigu.triagain;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.List;

/**
 * Created by Hytsigu on 08/01/2018.
 */

public class ResultatAdapter extends BaseAdapter {
    private List<Dechet> dechetList;
    private boolean[] resultatsQuestions;
    private Context context;
    private LayoutInflater inflater;
    private TextView nomView;
    private TextView poubelleView;

    public ResultatAdapter(Context context, List<Dechet> dechetList, boolean[] resultatsQuestions){
        this.context=context;
        this.dechetList=dechetList;
        this.resultatsQuestions=resultatsQuestions;
        this.inflater= LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return this.dechetList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.dechetList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public Context getContext() {
        return this.context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if(convertView==null){
            view = inflater.inflate(R.layout.resultat_list_item,parent,false);
        }
        else{
            view =convertView;
        }
        LinearLayout layoutItem = (LinearLayout)view.findViewById(R.id.resultat_list_item);

        this.nomView = (TextView) view.findViewById(R.id.nomView);
        this.poubelleView = (TextView) view.findViewById(R.id.poubelleView);
        String poubelle = "";

        if(dechetList.get(position).getType().equals("recyclable")){
            this.poubelleView.setText(context.getResources().getString(R.string.poubelleJaune));
        }else{
            this.poubelleView.setText(context.getResources().getString(R.string.poubelleMenagere));
        }
        if(!resultatsQuestions[position]){
            this.nomView.setTextColor(ContextCompat.getColor(context,R.color.holo_red_dark));
            this.poubelleView.setTextColor(ContextCompat.getColor(context,R.color.holo_red_dark));
        }
        else if(resultatsQuestions[position]){
            this.nomView.setTextColor(ContextCompat.getColor(context,R.color.holo_green_dark));
            this.poubelleView.setTextColor(ContextCompat.getColor(context,R.color.holo_green_dark));
        }
        this.nomView.setText(dechetList.get(position).getNomFr());


        return view;
    }
}
