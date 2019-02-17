package com.example.android.springfever;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.springfever.databinding.ListItemBinding;

import java.util.List;

//Use: https://github.com/udacity/ud839_CustomAdapter_Example/blob/master/app/src/main/java/com/example/android/flavor/AndroidFlavorAdapter.java
public class ViewCallsAdapter extends ArrayAdapter<BirdCall> {
    public ViewCallsAdapter(@NonNull Context context, @NonNull List<BirdCall> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View scrapView, @NonNull ViewGroup parent) {
        //See: https://stackoverflow.com/questions/33943717/android-data-binding-with-custom-adapter/36175205#36175205
        ListItemBinding binding;
        if (scrapView == null) {
            binding = DataBindingUtil.inflate( LayoutInflater.from(getContext()), R.layout.list_item, parent, false);
            scrapView = binding.getRoot();
        }
        else {
            binding = (ListItemBinding) scrapView.getTag();
        }

        binding.setBirdCall(getItem(position));

        scrapView.setTag(binding);
        return scrapView;
    }
}
