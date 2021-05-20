package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MotionEventCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;


public class MainActivity extends AppCompatActivity implements View.OnTouchListener,GestureDetector.OnGestureListener {
    MeowBottomNavigation bottomNavigation;
    ViewPager2 viewPager;
    GestureDetector gestureDetector;
    static final String DEBUG_TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 bottomNavigation=findViewById(R.id.bottomNavigation);
        viewPager = findViewById(R.id.recyclerView);
        PagerAdapter pager = new PagerAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager.setAdapter(pager);
 bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.ic_out_dark));
 gestureDetector=new GestureDetector(this,this);
bottomNavigation.setOnTouchListener(this::onTouch);
 bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
     @Override
     public void onShowItem(MeowBottomNavigation.Model item) {


     }
 });
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                if (position==2) {
                    bottomNavigation.setVisibility(View.VISIBLE);
                    bottomNavigation.show(1, true);
                }
                else
                    bottomNavigation.setVisibility(View.GONE);
            }
        });
// bottomNavigation.setCount(1,"10");
// bottomNavigation.show(2,true);

 bottomNavigation.setOnClickMenuListener(item -> Toast.makeText(MainActivity.this, "You Clicked"+item.getId(), Toast.LENGTH_SHORT).show());
bottomNavigation.setOnReselectListener(item -> {
    Toast.makeText(MainActivity.this, "You Reselected"+item.getId(), Toast.LENGTH_SHORT).show();
    bottomNavigation.setSelectedIconColor(R.color.black);
});

//    }
//
//    private void loadFragment(Fragment fragment) {
//    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();
//    }

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = MotionEventCompat.getActionMasked(event);

        switch(action) {
            case (MotionEvent.ACTION_DOWN) :
                Log.d(DEBUG_TAG,"Action was DOWN");
                return true;
            case (MotionEvent.ACTION_MOVE) :
                Log.d(DEBUG_TAG,"Action was MOVE");
                return true;
            case (MotionEvent.ACTION_UP) :
                Log.d(DEBUG_TAG,"Action was UP");
                return true;
            case (MotionEvent.ACTION_CANCEL) :
                Log.d(DEBUG_TAG,"Action was CANCEL");
                return true;
            case (MotionEvent.ACTION_OUTSIDE) :
                Log.d(DEBUG_TAG,"Movement occurred outside bounds " +
                        "of current screen element");
                return true;
            default :
                return super.onTouchEvent(event);
        }

    }

    @Override
    public boolean onDown(MotionEvent e) {
        Toast.makeText(this, "onDown method", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Toast.makeText(this, "onShowPress method", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Toast.makeText(this, "onSingleTapUp method", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Toast.makeText(this, "onScroll method", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Toast.makeText(this, "onLongPress method", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Toast.makeText(this, "onFling method", Toast.LENGTH_SHORT).show();
        return false;
    }
}