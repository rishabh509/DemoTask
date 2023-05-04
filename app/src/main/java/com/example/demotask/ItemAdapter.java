package com.example.demotask;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private ArrayList<ModelClass> items;
    private ItemClickListener listener;

    public ItemAdapter(ArrayList<ModelClass> items, ItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textView.setText(items.get(position).name);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(items.get(position).name, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.txt_name);
        }
    }

    public interface ItemClickListener {
        void onItemClick(String item, int pos);
    }

}
