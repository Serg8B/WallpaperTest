package app.sergio8.com.wallpapertest;

import android.app.WallpaperManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.IOException;

public class MainActivity extends FragmentActivity {

    ViewPager pager;
    PagerAdapter pagerAdapter;

    private int[] images = new int[] {R.drawable.im1,
            R.drawable.im2, R.drawable.im3, R.drawable.im4,
            R.drawable.im5, R.drawable.im6, R.drawable.im7,
            R.drawable.im8};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button setWlpBtn = (Button) findViewById(R.id.setWlpBtn);
        setWlpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WallpaperManager wallpaperManager =
                        WallpaperManager.getInstance(getApplicationContext());
                try {

                    wallpaperManager.setResource(images[pager.getCurrentItem()]);

                    Context context = getApplicationContext();
                    CharSequence text = getString(R.string.resultSet);
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        pager = (ViewPager) findViewById(R.id.viewPager);
        pagerAdapter = new MyFragmentPageAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    private class MyFragmentPageAdapter extends FragmentPagerAdapter {

        private int[] images = new int[] {R.drawable.im1,
                R.drawable.im2, R.drawable.im3, R.drawable.im4,
                R.drawable.im5, R.drawable.im6, R.drawable.im7,
                R.drawable.im8};

        private int imagesCount = images.length;

        public MyFragmentPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return PageFragment.newInstance(images[i]);
        }

        @Override
        public int getCount() {
            return imagesCount;
        }

    }
}
