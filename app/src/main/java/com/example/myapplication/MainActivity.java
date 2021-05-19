package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;



public class MainActivity extends AppCompatActivity {
   MeowBottomNavigation bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 bottomNavigation=findViewById(R.id.bottomNavigation);
 bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.ic_out_dark));
 bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.ic_filles_gray));
 bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.ic_final));

 bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
     @Override
     public void onShowItem(MeowBottomNavigation.Model item) {
         Fragment fragment=null;
         switch (item.getId())
         {
             case 1:
                 fragment=new First();
                 break;
             case 2:
                 fragment=new Second();
                 break;
             case 3:
                 fragment=new Third();
                 break;

         }
         loadFragment(fragment);
     }
 });
 bottomNavigation.setCount(1,"10");
 bottomNavigation.show(2,true);

 bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
     @Override
     public void onClickItem(MeowBottomNavigation.Model item) {
         Toast.makeText(MainActivity.this, "You Clicked"+item.getId(), Toast.LENGTH_SHORT).show();
         if (item.getId()==1)
             bottomNavigation.setVisibility(View.GONE);
     }
 });
bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
    @Override
    public void onReselectItem(MeowBottomNavigation.Model item) {
        Toast.makeText(MainActivity.this, "You Reselected"+item.getId(), Toast.LENGTH_SHORT).show();
        bottomNavigation.setSelectedIconColor(R.color.black);
    }
});
    }

    private void loadFragment(Fragment fragment) {
    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();
    }
}