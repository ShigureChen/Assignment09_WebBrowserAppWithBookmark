package edu.temple.webbrowserapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class BookmarkActivity extends AppCompatActivity {

    ArrayList<String> bookmarks;
    ArrayList<String> markTitle;
    CustomAdapter adapter;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);

        Intent intent = getIntent();
        bookmarks = intent.getStringArrayListExtra("Bookmarks");
        markTitle = intent.getStringArrayListExtra("Title");
        Button close = findViewById(R.id.closeButton);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        if(bookmarks != null)
        {
            ListView listView = (ListView)findViewById(R.id.listView);
            adapter = new CustomAdapter(context, markTitle);
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