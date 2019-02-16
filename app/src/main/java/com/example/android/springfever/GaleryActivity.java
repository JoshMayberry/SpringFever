package com.example.android.springfever;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/**
 * Displays gallery images.
 * Use: https://stackoverflow.com/questions/15833889/options-for-replacing-the-deprecated-gallery/20293885#20293885
 */
public class GaleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galery);
    }

//    private ViewPager gallery;
//    gallery = (ViewPager) findViewById(R.id.gallery_item);
//
//    gallery = (ViewPager) findViewById(R.id.gallery_item);
//    lista_galeria = new ArrayList<ObjectVerGaleria>();
//
//    int i=0;
//    for(i=0;i<listImages.length;i++)
//    {
//        ObjectVerGaleria objV = new ObjectVerGaleria();
//        objV.setUrlImg(listImages[i]);
//        lista_galeria.add(objV);
//    }
//    gallery.setAdapter(new AdapterVerGaleria(ctx, lista_galeria));
//
//    gallery.setOnPageChangeListener(new OnPageChangeListener()
//    {
//
//        public void onPageSelected(int pos)
//        {
//            String pathImage = listImages[pos].toString();
//
//            currentPosFront = pos;
//            Log.d("setOnItemSelectedListener>>","path:"+pathImage);
//
//        }
//
//        public void onPageScrolled(int arg0, float arg1, int arg2)
//        {
//            // TODO Auto-generated method stub
//
//        }
//
//        public void onPageScrollStateChanged(int arg0)
//        {
//            // TODO Auto-generated method stub
//
//        }
//    });
}
