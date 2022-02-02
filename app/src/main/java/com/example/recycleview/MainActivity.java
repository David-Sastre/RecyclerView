package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    private LinkedList<String> mWordList;
    private FloatingActionButton mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWordList = new LinkedList<String>();

        // Adding elements to the linked list
        for(int i = 0; i < 21; i++){
            mWordList.addLast("Word"+i);
        }
        mRecyclerView = findViewById(R.id.recyclerview);
        mAdapter = new WordListAdapter(this, mWordList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mButton = findViewById(R.id.floatingbutton);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int newRow = mWordList.size();
                mWordList.addLast("+ Word" + newRow);
                mAdapter.notifyItemInserted(mWordList.size());
                mRecyclerView.smoothScrollToPosition(mWordList.size());
            }
        });
    }
}
