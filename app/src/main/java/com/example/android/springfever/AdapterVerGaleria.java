package com.example.android.springfever;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

/**
 * Displays gallery images.
 * Use: https://stackoverflow.com/questions/15833889/options-for-replacing-the-deprecated-gallery/20293885#20293885
 */
public class AdapterVerGaleria extends PagerAdapter {
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return false;
    }

//    private Activity ctx;
//    private ArrayList<ObjectVerGaleria> dataList;
//
//    public AdapterVerGaleria(Activity act, ArrayList<ObjectVerGaleria> lista) {
//
//        ctx = act;
//        dataList = lista;
//    }
//
//    public int getCount() {
//        return dataList.size();
//    }
//
//    public Object getItem(int pos) {
//        return pos;
//    }
//
//    @Override
//    public Object instantiateItem(View collection, int pos) {
//        ImageView foto = new ImageView(ctx);
//
//
//        //foto.setLayoutParams(new ViewPager.LayoutParams(Gallery.LayoutParams.FILL_PARENT, Gallery.LayoutParams.FILL_PARENT));
//        foto.setScaleType(ImageView.ScaleType.FIT_XY);
//        Utils.fetchDrawableOnThread(Utils.getPath(ctx) + "/" + dataList.get(pos).getUrlImg(), foto, true);
//        ((ViewPager) collection).addView(foto);
//
//
//        return foto;
//    }
//
//    @Override
//    public void destroyItem(View collection, int position, Object view) {
//        ((ViewPager) collection).removeView((ImageView) view);
//
//    }
//
//    public long getItemId(int pos) {
//        return pos;
//    }
//
//
//    @Override
//    public boolean isViewFromObject(View view, Object object) {
//        // TODO Auto-generated method stub
//        return view == ((ImageView) object);
//    }
}
