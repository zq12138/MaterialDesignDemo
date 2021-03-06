package com.example.admin.materialdesigndemo.fragment.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.admin.materialdesigndemo.R;

import java.util.List;

/**
 * Created by zq on 2017/9/18.
 */

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ViewHolder> {


    public List<String> listString;
    public boolean[] flag;

    public ProjectAdapter(List<String> list) {
        this.listString = list;
        flag = new boolean[listString.size()];
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_item_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.checkBox.setOnCheckedChangeListener(null);
        holder.checkBox.setChecked(flag[position]);
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                flag[position] = isChecked;
            }
        });
        holder.textView.setText(listString.get(position));

    }

    @Override
    public int getItemCount() {
        return listString.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);
        }
    }


}
