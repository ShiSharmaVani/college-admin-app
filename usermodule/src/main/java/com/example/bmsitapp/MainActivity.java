//package com.example.bmsitapp;
//
//import androidx.appcompat.app.ActionBar;
//import androidx.appcompat.app.ActionBarDrawerToggle;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.drawerlayout.widget.DrawerLayout;
//import androidx.navigation.NavController;
//import androidx.navigation.Navigation;
//import androidx.navigation.fragment.NavHostFragment;
//import androidx.navigation.ui.NavigationUI;
//import android.app.Application;
//import android.content.Intent;
//import android.content.pm.ApplicationInfo;
//import android.net.Uri;
//import android.os.Bundle;
//import androidx.annotation.NonNull;
//import android.os.Bundle;
//import android.view.MenuItem;
//import android.widget.Toast;
//
//
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//import com.google.android.material.navigation.NavigationView;
//
//import java.io.File;
//import java.util.Objects;
//
//public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
//
//
//    BottomNavigationView bottomNavigationView;
//    NavController navController;
//    DrawerLayout drawerLayout;
//    ActionBarDrawerToggle toggle;
//    NavigationView navigationView;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        bottomNavigationView=findViewById(R.id.bottomNavigationView);
//        navController= Navigation.findNavController(this,R.id.navHostFragment);
//        drawerLayout=findViewById(R.id.drawerLayout);
//        navigationView=findViewById(R.id.navigation_view);
//
//        toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.start,R.string.close);
//
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();
//
//        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
//        navigationView.setNavigationItemSelectedListener(this);
//
//        NavigationUI.setupWithNavController(bottomNavigationView, navController);
//    }
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        if (toggle.onOptionsItemSelected(item)) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){
//        switch (menuItem.getItemId()){
//            case R.id.video:
//                Toast.makeText(this,"Video Lectures",Toast.LENGTH_SHORT).show();
//                break;
//
//            case R.id.ebook:
//                Toast.makeText(this,"Ebooks",Toast.LENGTH_SHORT).show();
//                break;
//
//            case R.id.website:
//                Intent i=new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse("https://bmsit.ac.in/"));
//                startActivity(i);
//
//                break;
//
//
//            case R.id.rate:
//                Uri uri=Uri.parse("https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
//                Intent intent1=new Intent(Intent.ACTION_VIEW,uri);
//                startActivity(intent1);
//                break;
//
//            case R.id.share:
//                Intent intent=new Intent(Intent.ACTION_SEND);
//                intent.setType("text/plain");
//                intent.putExtra(Intent.EXTRA_SUBJECT,"Sharing apk");
//                intent.putExtra(Intent.EXTRA_TEXT,"https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
//                startActivity(Intent.createChooser(intent,"Share with "));
//                break;
//        }
//        return true;
//    }
//
//
//}

package com.example.bmsitapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import android.app.Application;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.io.File;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    BottomNavigationView bottomNavigationView;
    NavController navController;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        navController= Navigation.findNavController(this,R.id.navHostFragment);
        drawerLayout=findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.navigation_view);

        toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.start,R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);

        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.video:
                Toast.makeText(this,"Video Lectures",Toast.LENGTH_SHORT).show();
                break;

            case R.id.ebook:
                Toast.makeText(this,"Ebooks",Toast.LENGTH_SHORT).show();
                break;

            case R.id.website:
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://bmsit.ac.in/"));
                startActivity(i);

                break;


            case R.id.rate:
                Uri uri=Uri.parse("https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
                Intent intent1=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent1);
                break;

            case R.id.share:
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT,"Sharing apk");
                intent.putExtra(Intent.EXTRA_TEXT,"https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
                startActivity(Intent.createChooser(intent,"Share with "));
                break;
        }
        return true;
    }


}