package com.example.admin.materialdesigndemo.fragment.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.materialdesigndemo.R;
import com.example.admin.materialdesigndemo.data.CardVo;

import java.util.List;

/**
 * Created by 14537 on 2017/10/16.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {


    private CardVo[] cardVos;

    public RecyclerAdapter(CardVo[] cardVos) {
        Log.d("tag", "test");
        this.cardVos = cardVos;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder viewHolder, int i) {
        viewHolder.textView.setText(cardVos[i].getName());
        viewHolder.imageView.setImageResource(cardVos[i].getImg());
    }

    @Override
    public int getItemCount() {
        return cardVos.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
            imageView = (ImageView) itemView.findViewById(R.id.fruit_image);
        }
    }
}
