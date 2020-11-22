package edu.temple.webbrowserapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class BookmarkActivity extends AppCompatActivity {

    ArrayList<String> bookmarks;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);

        Intent intent = getIntent();
        bookmarks = intent.getStringArrayListExtra("Bookmarks");
        if(bookmarks != null)
        {
            ListView listView = findViewById(R.id.listView);
            adapter = new ArrayAdapter<String>(this, bookmarks);
            listView.setAdapter(adapter);

        }

        else
        {
            this.setTitle("No Bookmark Added");
        }

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save list of open pages for activity restart
        outState.putSerializable("BOOKMARKS", bookmarks);
    }
}