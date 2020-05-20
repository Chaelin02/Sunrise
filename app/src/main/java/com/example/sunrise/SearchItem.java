package com.example.sunrise;

import android.net.Uri;

public class SearchItem {

    public String id, title, text, date;
    public boolean like;
    public Uri url;

    public SearchItem(String id, String title, String text, boolean like, Uri url, String date) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.like = like;
        this.url = url;
        this.date = date;
    }
}
