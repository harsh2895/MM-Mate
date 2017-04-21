package com.example.admin.manimate.Adptr;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.admin.manimate.DL.DLViewbug;
import com.example.admin.manimate.Model.ViewBug;
import com.example.admin.manimate.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deep Joshi on 14-04-2017.
 */

public class BugAdptr extends BaseAdapter {
    List<ViewBug> vb=new ArrayList<>();
    Context context;
    public BugAdptr(Context context, List<ViewBug> vb) {
        this.context=context;
        this.vb=vb;
    }

    @Override
    public int getCount() {
        return vb.size();
    }

    @Override
    public Object getItem(int position) {
        return vb.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    static class ViewListHolder{
        TextView bug1,bug2,bug3;


    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewListHolder listholder = new ViewListHolder();
        if (convertView == null){

            convertView = LayoutInflater.from(context).inflate(R.layout.viewbug,parent,false);
            listholder.bug1 = (TextView)convertView.findViewById(R.id.PrName);
            listholder.bug2 = (TextView)convertView.findViewById(R.id.Bug);
            listholder.bug3 = (TextView)convertView.findViewById(R.id.BugDis);

            convertView.setTag(listholder);
        }else

        {
            listholder = (ViewListHolder)convertView.getTag();
        }


listholder.bug1.setText(vb.get(position).getBugTypes());
        listholder.bug2.setText(vb.get(position).getBugName());
        listholder.bug3.setText(vb.get(position).getBugDesc());

        return convertView;
    }
}
