package com.example.sunrise;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SearchViewHolder
    extends RecyclerView.ViewHolder
{
    TextView title, text;
    ImageView like;


    public SearchViewHolder(@NonNull View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.text_title);
        text = itemView.findViewById(R.id.text_content);
        like  = itemView.findViewById(R.id.btn_like);
    }
}