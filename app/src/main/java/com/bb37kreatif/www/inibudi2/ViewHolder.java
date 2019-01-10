package com.bb37kreatif.www.inibudi2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {
    View mView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        mView = itemView;

        //item click
        itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mClickListener.onItemClick(view, getAdapterPosition());
            }
        });

        //itemlongclick
        itemView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View view){
                mClickListener.onItemLongClick(view, getAdapterPosition());
                return true;
            }
        });
    }

    public void setDetails(Context ctx, String title, String description, String image){
        //membuat object untuk setiap widget tampilan dari menucardview
        TextView mTitleView = mView.findViewById(R.id.tahapbudidaya);
        TextView mDetail = mView.findViewById(R.id.penjelasan);
        ImageView mImage = mView.findViewById(R.id.gambartahap);
        //masukan data ke view diatas
        mTitleView.setText(title);
        mDetail.setText(description);
        Picasso.get().load(image).into(mImage);
    }

    private ViewHolder.ClickListener mClickListener;
    //interface to send callback
    public interface ClickListener{
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    public void setOnClickListener(ViewHolder.ClickListener clickListener){
        mClickListener = clickListener;
    }
}
