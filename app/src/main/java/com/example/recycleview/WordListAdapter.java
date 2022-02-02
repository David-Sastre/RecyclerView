package com.example.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.LinkedList;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WordListAdapter extends  RecyclerView.Adapter<WordListAdapter.WordViewHolder>{

    private  LinkedList<String> mWordList;
    private  LayoutInflater mInflater;

    public WordListAdapter(Context context, LinkedList<String> wordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate an item view.
        View mItemView = mInflater.inflate(R.layout.rows, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        // Retrieve the data for that position
        String mCurrent = mWordList.get(position);
        // Add the data to the view
        holder.wordItemView.setText(mCurrent);

    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    public static class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView wordItemView;
        private final WordListAdapter mAdapter;

        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            wordItemView.setText("Clicked! "+ wordItemView.getText());
        }
    }
}
