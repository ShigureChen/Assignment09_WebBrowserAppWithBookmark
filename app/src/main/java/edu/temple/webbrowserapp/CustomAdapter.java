package edu.temple.webbrowserapp;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    ArrayList<String> bookmarks;
    Context context;
    public CustomAdapter(Context context, ArrayList<String> bookmarks)
    {
        this.context = context;
        this.bookmarks = bookmarks;
    }

    @Override
    public int getCount() {
        return bookmarks.size();
    }

    @Override
    public Object getItem(int i) {
        return bookmarks.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = new TextView(context);
        textView.setText(bookmarks.get(i));
        textView.setPadding(5, 5, 5, 5);
        textView.setTextSize(22);
        return textView;
    }
}
