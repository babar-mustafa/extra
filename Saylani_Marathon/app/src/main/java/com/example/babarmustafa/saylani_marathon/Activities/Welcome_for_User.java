package com.example.babarmustafa.saylani_marathon.Activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.babarmustafa.saylani_marathon.Adapters.Tabadapter;
import com.example.babarmustafa.saylani_marathon.Fragments.A;
import com.example.babarmustafa.saylani_marathon.Fragments.B;
import com.example.babarmustafa.saylani_marathon.Fragments.C;
import com.example.babarmustafa.saylani_marathon.MainActivity;
import com.example.babarmustafa.saylani_marathon.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class Welcome_for_User extends AppCompatActivity {
    Tabadapter tabadapter;
    ArrayList<Fragment> mfragmentArrayListl;
    ViewPager viewPager;
    TabLayout tabLayout;
    A first;
    B second;
    C third;
FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_for__user);

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
mauth = FirebaseAuth.getInstance();
        Toast.makeText(this, ""+mauth.getCurrentUser().getUid(), Toast.LENGTH_SHORT).show();
        first = new A();
        second = new B();
        third = new C();
         mfragmentArrayListl = new ArrayList<>();
        mfragmentArrayListl.add(first);
        mfragmentArrayListl.add(second);
        mfragmentArrayListl.add(third);

        tabLayout.addTab(tabLayout.newTab().setText("first"));
        tabLayout.addTab(tabLayout.newTab().setText("second"));
        tabLayout.addTab(tabLayout.newTab().setText("third"));

        tabadapter = new Tabadapter(getSupportFragmentManager(),mfragmentArrayListl);
viewPager.setAdapter(tabadapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setOffscreenPageLimit(0);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
            viewPager.setCurrentItem(tab.getPosition());
                switch(tab.getPosition()){
                    case 0:
                        new A();
                        break;
                    case 1:
                        new B();
                        break;
                    case 2:
                        new C();
                        break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.me_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            FirebaseAuth.getInstance().signOut();
            Intent call = new Intent(Welcome_for_User.this, MainActivity.class);
            startActivity(call);
        }
        return super.onOptionsItemSelected(item);
    }
}
