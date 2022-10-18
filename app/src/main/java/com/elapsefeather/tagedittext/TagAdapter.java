package com.elapsefeather.tagedittext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class TagAdapter extends BaseTagAdapter {
    private final Context mContext;
    private final int mResourceId;

    public TagAdapter(@NonNull Context context, int resource, List<TagData> items) {
        super(context, resource, items);
        mContext = context;
        mResourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (convertView == null) {
            view = LayoutInflater.from(mContext).inflate(mResourceId, parent, false);
        }
        TagData model = (TagData) getItem(position);
        ((TextView) view.findViewById(R.id.name)).setText(model.getName());
        return view;
    }
}
