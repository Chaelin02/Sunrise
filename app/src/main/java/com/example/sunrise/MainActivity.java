package com.example.sunrise;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewflipperActivity.ViewFlipperCallback {

    //뷰플리퍼
    ViewFlipper flipper;
    //인덱스
    List<ImageView> indexes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //UI
        flipper = (ViewFlipper)findViewById(R.id.flipper);
        ImageView index0 = (ImageView)findViewById(R.id.imgIndex0);
        ImageView index1 = (ImageView)findViewById(R.id.imgIndex1);
        ImageView index2 = (ImageView)findViewById(R.id.imgIndex2);

        //인덱스리스트
        indexes = new ArrayList<>();
        indexes.add(index0);
        indexes.add(index1);
        indexes.add(index2);

        //xml을 inflate 하여 flipper view에 추가하기
        //inflate
        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View view1 = inflater.inflate(R.layout.viewflipper1, flipper, false);
        View view2 = inflater.inflate(R.layout.viewflipper2, flipper, false);
        View view3 = inflater.inflate(R.layout.viewflipper3, flipper, false);
        //inflate 한 view 추가
        flipper.addView(view1);
        flipper.addView(view2);
        flipper.addView(view3);

        //리스너설정 - 좌우 터치시 화면넘어가기
        flipper.setOnTouchListener(new ViewflipperActivity(this, flipper));
    }

    //인덱스 업데이트
    @Override
    public void onFlipperActionCallback(int position) {
        Log.d("ddd", ""+position);
        for(int i=0; i<indexes.size(); i++){
            ImageView index = indexes.get(i);
            //현재화면의 인덱스 위치면 녹색
            if(i == position){
                index.setImageResource(R.drawable.benu_icon2);
            }
            //그외
            else{
                index.setImageResource(R.drawable.benu_icon1);
            }
        }
    }
}