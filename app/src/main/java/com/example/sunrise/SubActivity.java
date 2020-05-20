package com.example.sunrise;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

import java.net.MalformedURLException;

public class SubActivity extends AppCompatActivity {

    Search search;

    SharedPreferences preferences;

    EditText searchEditText;
    RecyclerView recyclerView;
    TextView textView ;
    Context context;

    SearchAdapter adapter;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        ActionBar ab = getSupportActionBar() ;
//        ab.setTitle("") ;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getPreferences(MODE_PRIVATE);
        searchEditText = findViewById(R.id.edit_search);
        recyclerView = findViewById(R.id.recycler_search);

        adapter = new SearchAdapter(this, preferences);
        try {
            search = new Search(preferences);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        // 기본 결과를 표시함
        adapter.items = search.search(null);
        adapter.notifyDataSetChanged();


        // 텍스트가 바뀔 때마다 검색해서 결과를 표시함.
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            // 텍스트가 변경될 때 호출되는 함수
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.items = search.search(s.toString());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
