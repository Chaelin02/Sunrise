package com.example.sunrise;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class SearchAdapter
extends RecyclerView.Adapter<SearchViewHolder>{

    Context context;
    TextView textView;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    ArrayList<SearchItem> items = new ArrayList<>();
    private CardView cardView;
    Activity activity;


    public SearchAdapter(Context context, SharedPreferences preferences) {
        this.context = context;
        this.preferences = preferences;
        this.editor = preferences.edit();
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_search, parent, false);
        SearchViewHolder holder = new SearchViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final SearchViewHolder holder, int position) {
        final SearchItem item = items.get(position);

        holder.text.setText(item.text);
        holder.title.setText(item.title);
        if (item.like) {
            holder.like.setImageResource(R.drawable.empty_heart);
        } else {
            holder.like.setImageResource(R.drawable.heart);
        }

        // 찜하기 버튼 눌렀을 때 반응W
        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // like 라는 이름으로 Set을 저장했음.
                // 이 Set에는 찜하기가 등록된 SearchItem들의 ID가 저장되어있음.
                HashSet<String> data = new HashSet<>();
                data.addAll(preferences.getStringSet("like", new HashSet<String>()));

                if (item.like) {
                    // Set에서 제거
                    data.remove(item.id);
                    item.like = false;
                    holder.like.setImageResource(R.drawable.heart);
                } else {
                    // Set에 추가
                    data.add(item.id);

                    item.like = true;
                    holder.like.setImageResource(R.drawable.empty_heart);
                }

                // 결과 저장
                editor.putStringSet("like", data);
                editor.apply();
            }
        });

        textView = (TextView) holder.itemView.findViewById(R.id.text_title);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(v.getContext());

                alertDialogBuilder.setTitle("이 장학금에 대해 더 알아보고 싶으신가요?");
                alertDialogBuilder.setMessage("보다 정확한 정보를 위해 재단사이트로 이동합니다.").setCancelable(false).setPositiveButton("더 알아보기", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, item.url);
                        holder.itemView.getContext().startActivity(intent);
                    }
                }).setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(context, "취소", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
    } //onBind

    public String calDateBetweenAandB(String date)
    {

        try{
            SimpleDateFormat simpleDateFormat  = new SimpleDateFormat("yyyy-MM-dd");
            long now = System.currentTimeMillis(); //현재시각 구하기
            Date todaCal = new Date(now); //now에 들어있는 현재시각을 Date 타입에 넣어주기
            Date SecondDate = simpleDateFormat.parse(date); // date2 날짜를 parse()를 통해 Date형으로 변환.
            long calDate =   SecondDate.getTime() - todaCal.getTime();  //차이 구하기  // Date.getTime() 은 해당날짜를 기준으로1970년 00:00:00 부터 몇 초가 흘렀는지를 반환해준다.
            long calDateDays = calDate / ( 24*60*60*1000);// 24*60*60*1000(각 시간값에 따른 차이점) 을 나눠주면 일수가 나온다.

            String date2;

            if (calDateDays > 0){
                //System.out.println("D - "+calDateDays);
                 date2 = "D - "+calDateDays;
            }
            else if (calDateDays == 0){
                //System.out.println("D - DAY");
                 date2 = "D - DAY";
            }
            else {
                //System.out.println("D + "+calDateDays);
                date2 = "D + "+calDateDays;
            }

            calDateDays = Math.abs(calDateDays);
            return date2;
        }
        catch(ParseException e)
        {
            return date;
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
