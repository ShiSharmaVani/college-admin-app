package com.example.admincollegeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.admincollegeapp.ebook.UploadPDFActivity;
import com.example.admincollegeapp.faculty.updateFaculty;
import com.example.admincollegeapp.notice.DeleteNoticeActivity;
import com.example.admincollegeapp.notice.UploadNotice;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView uploadNotice,addGalleryImage,addEbook,addFaculty,deleteNotice,logout;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sharedPreferences = this.getSharedPreferences("login",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if(sharedPreferences.getString("isLogin","false").equals("false")){
            openLogin();
        }

        uploadNotice = findViewById(R.id.addNotice);
        addGalleryImage = findViewById(R.id.addGalleryImage);
        addEbook = findViewById(R.id.addEbook);
        addFaculty = findViewById(R.id.addFaculty);
        deleteNotice = findViewById(R.id.deleteNotice);
        logout = findViewById(R.id.logout);

        uploadNotice.setOnClickListener(this);
        addGalleryImage.setOnClickListener(this);
        addEbook.setOnClickListener(this);
        addFaculty.setOnClickListener(this);
        deleteNotice.setOnClickListener(this);
        logout.setOnClickListener(this);
    }

    private void openLogin() {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        finish();
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.addNotice:
                intent = new Intent(MainActivity.this, UploadNotice.class);
                startActivity(intent);
                break;
            case R.id.addGalleryImage:
                intent = new Intent(MainActivity.this, UploadImage.class);
                startActivity(intent);
                break;
            case R.id.addEbook:
                intent = new Intent(MainActivity.this, UploadPDFActivity.class);
                startActivity(intent);
                break;
            case R.id.addFaculty:
                intent = new Intent(MainActivity.this, updateFaculty.class);
                startActivity(intent);
                break;
            case R.id.deleteNotice:
                intent = new Intent(MainActivity.this, DeleteNoticeActivity.class);
                startActivity(intent);
                break;
            case R.id.logout:
                editor.putString("isLogin","false");
                editor.commit();
                intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                openLogin();
                break;



        }
    }
}