package com.example.android.springfever;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

//Modified code from: https://github.com/udacity/ud839_CustomAdapter_Example/blob/master/app/src/main/java/com/example/android/flavor/AndroidFlavorAdapter.java
public class ViewCallsAdapter extends ArrayAdapter<BirdCall> {
    public ViewCallsAdapter(@NonNull Context context, @NonNull List<BirdCall> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View scrapView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        if (scrapView == null) {
            scrapView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        BirdCall listItem = getItem(position);

        TextView view_textTop = scrapView.findViewById(R.id.list_item_top);
        assert listItem != null;
        view_textTop.setText(listItem.getName());

        return scrapView;
    }
}
