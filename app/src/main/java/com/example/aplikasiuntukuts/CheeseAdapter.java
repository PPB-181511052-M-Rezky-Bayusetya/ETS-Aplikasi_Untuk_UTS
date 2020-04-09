package com.example.aplikasiuntukuts;

import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aplikasiuntukuts.data.Cheese;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CheeseAdapter extends RecyclerView.Adapter<CheeseAdapter.ViewHolder> {

    private Cursor mCursor;
    private List<Cheese> mCheese;

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (mCheese != null) {
            Cheese current = mCheese.get(position);
            holder.mText.setText(current.name);
        } else {
            holder.mText.setText("kosong");
        }
    }

    @Override
    public int getItemCount() {
        return mCursor == null ? 0 : mCursor.getCount();
    }

    public void setCheeses(List<Cheese> cheeses) {
        mCheese = cheeses;
        notifyDataSetChanged();
    }

    public void setCheesesCursor(Cursor cursor) {
        mCursor = cursor;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView mText;

        ViewHolder(ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(
                    android.R.layout.simple_list_item_1, parent, false));
            mText = itemView.findViewById(android.R.id.text1);
        }

    }
}

