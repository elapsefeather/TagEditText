package com.elapsefeather.tagedittext;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class BaseTagAdapter<T> extends ArrayAdapter<TagInterface> {
    private List<TagInterface> mList, mTempList, mSuggestionList;

    public BaseTagAdapter(@NonNull Context context, int resource, List<T> items) {
        super(context, resource, (List<TagInterface>) items);
        mList = (List<TagInterface>) items;
        mTempList = new ArrayList<TagInterface>((List<TagInterface>) items);
        mSuggestionList = new ArrayList<>();
    }

    @NonNull
    @Override
    public TagInterface getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return filter;
    }

    private final Filter filter = new Filter() {

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            TagInterface model = (TagInterface) resultValue;
            return model.getTag();
        }

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            if (charSequence != null) {
                String query = charSequence.toString().toLowerCase();
                mSuggestionList.clear();
                for (TagInterface model : mTempList) {
                    // Use can filter yourself Id here
                    /*
                    if (model.getId() == Self.get().getID()) {
                        continue;
                    }
                    */
                    if (model.getLabel().toLowerCase().contains(query)
                            || ("@" + model.getLabel()).toLowerCase().contains(query)) {
                        mSuggestionList.add(model);
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mSuggestionList;
                filterResults.count = mSuggestionList.size();
                return filterResults;
            } else {
                return new FilterResults();
            }
        }

        @Override
        @SuppressWarnings("unchecked")
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            clear();
            if (filterResults != null && filterResults.count > 0) {
                BaseTagAdapter.this.addAll((ArrayList<TagInterface>) filterResults.values);
                notifyDataSetChanged();
            } else {
                notifyDataSetInvalidated();
            }
        }
    };
}
