package com.example.android.springfever;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.android.springfever.databinding.ActivityAboutBinding;

public class AboutActivity extends AppCompatActivity {

    ActivityAboutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //See: https://codelabs.developers.google.com/codelabs/android-databinding/index.html?index=..%2F..index#4
        binding = DataBindingUtil.setContentView(this, R.layout.activity_about);

        binding.aboutPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
    			//Use: https://developer.android.com/guide/components/intents-common?utm_source=udacity&utm_medium=course&utm_campaign=android_basics#Phone
                Intent intent = new Intent(Intent.ACTION_DIAL);
			    intent.setData(Uri.parse("tel:2082703759"));
			    if (intent.resolveActivity(getPackageManager()) != null) {
			        startActivity(intent);
			    }
            }
        });

        binding.aboutEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
    			//Use: https://developer.android.com/guide/components/intents-common?utm_source=udacity&utm_medium=course&utm_campaign=android_basics#Email
				Intent intent = new Intent(Intent.ACTION_SEND);
			    intent.setType("*/*");
			    intent.putExtra(Intent.EXTRA_EMAIL, "springfevercustomcalls@gmail.com");
			    intent.putExtra(Intent.EXTRA_SUBJECT, "Hi There!");
			    intent.putExtra(Intent.EXTRA_TEXT, "Lorem ipsum dolor sit amet");
			    if (intent.resolveActivity(getPackageManager()) != null) {
			        startActivity(intent);
			    }
            }
        });

        binding.aboutLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
    			//Use: https://developer.android.com/guide/components/intents-common?utm_source=udacity&utm_medium=course&utm_campaign=android_basics#ViewMap
    			Intent intent = new Intent(Intent.ACTION_VIEW);
			    intent.setData(Uri.parse("geo:0,0?q=spring+fever+custom+calls"));
			    if (intent.resolveActivity(getPackageManager()) != null) {
			        startActivity(intent);
			    }
            }
        });

        binding.aboutFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
    			//Use: https://stackoverflow.com/questions/4810803/open-facebook-page-from-android-app/28608297#28608297
                Intent intent;
                try {
				    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/245226122337928"));
				} catch (Exception e) {
				    intent =  new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/245226122337928"));
				}
			    if (intent.resolveActivity(getPackageManager()) != null) {
			        startActivity(intent);
			    }
            }
        });
    }
}
