package com.example.sunrise;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try{
            Thread.sleep(2000); //대기초
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        // MainActivity.class 자리에 다음에 넘어갈 액티비티를 넣어주기
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
//        Intent intent = new Intent(this, MainActivity.class);
//        intent.putExtra("state", "launch");
//        startActivity(new Intent(this,MainActivity.class));
//        finish();
    }

}