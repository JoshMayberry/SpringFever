package com.example.android.springfever;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.springfever.databinding.ActivityGaleryBinding;


/**
 * Displays gallery images.
 * Use: https://stackoverflow.com/questions/15833889/options-for-replacing-the-deprecated-gallery/20293885#20293885
 */
public class GaleryActivity extends AppCompatActivity {
    ActivityGaleryBinding binding;

    int[] imageIdList = new int[]{R.drawable.gallery_1, R.drawable.gallery_2, R.drawable.gallery_3, R.drawable.gallery_4, R.drawable.gallery_5, R.drawable.gallery_6, R.drawable.gallery_7, R.drawable.gallery_8, R.drawable.gallery_9};
    int[] descriptionIdList = new int[]{R.string.gallery_description_1, R.string.gallery_description_2, R.string.gallery_description_3, R.string.gallery_description_4, R.string.gallery_description_5, R.string.gallery_description_6, R.string.gallery_description_7, R.string.gallery_description_8, R.string.gallery_description_9};
    int[] imageScaleTypeList = new int[]{1, 0, 1, 0, 0, 1, 1, 1, 0};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //See: https://developer.android.com/training/implementing-navigation/ancestral#up
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //See: https://codelabs.developers.google.com/codelabs/android-databinding/index.html?index=..%2F..index#4
        binding = DataBindingUtil.setContentView(this, R.layout.activity_galery);

        ViewPager pager = binding.galleryImages.getViewPager();
        pager.setAdapter(new MyPagerAdapter());
        pager.setOffscreenPageLimit(imageIdList.length);
        pager.setPageMargin(16);
        pager.addOnPageChangeListener(onPageChangeListener);

        binding.galleryDescription.setText(descriptionIdList[0]);
    }

    /**
     * This updates the description text to what text accompanies the current image.
     */
    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//            Log.v("GalleryActivity", "@onPageScrolled " + position);
        }

        @Override
        public void onPageSelected(int position) {
//            Log.v("GalleryActivity", "@onPageSelected " + position);
            binding.galleryDescription.setText(descriptionIdList[position]);
        }

        @Override
        public void onPageScrollStateChanged(int position) {
//            Log.v("GalleryActivity", "@onPageScrollStateChanged " + position);

        }
    };

    /**
     * This populates the gallery with the gallery images.
     */
    private class MyPagerAdapter extends PagerAdapter {

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            ImageView view = new ImageView(GaleryActivity.this);
            view.setImageResource(imageIdList[position]);
            switch (imageScaleTypeList[position]) {
                case 0:
                    view.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    break;
                case 1:
                    view.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    break;
                default:
                    Log.e("BirdCall", "Unknown scale type " + imageScaleTypeList[position]);
                    view.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    break;
            }
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return imageIdList.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return (view == object);
        }
    }
}