package com.elapsefeather.tagedittext;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    public List<String> list = new ArrayList<>();
    public List<TagData> tags = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tagText.setTags(tags);
        holder.tagText.setText(list.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.item_list;
    }

    @Override
    public int getItemCount() {
        return (list == null) ? 0 : list.size();
    }

    public void setTagsList(List<TagData> tags) {
        this.tags = new ArrayList<>(tags);
        notifyDataSetChanged();
    }

    public void setList(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TagTextView tagText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setTag(this);
            tagText = itemView.findViewById(R.id.tagText);
        }
    }
}
