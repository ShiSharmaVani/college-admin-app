package com.example.admincollegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {
    private EditText admin_email, admin_password;
    private TextView txt_show;
    private RelativeLayout loginButton;

    private String email,pswrd;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = this.getSharedPreferences("login",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if(sharedPreferences.getString("isLogin","false").equals("yes")){
            openDash();
        }

        admin_email = findViewById(R.id.admin_email);
        admin_password = findViewById(R.id.admin_password);
        txt_show = findViewById(R.id.txt_show);
        loginButton = findViewById(R.id.login_button);

        txt_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(admin_password.getInputType() == 144){
                    admin_password.setInputType(129);
                    txt_show.setText("Show");
                }else{
                    admin_password.setInputType(144);
                    txt_show.setText("Hide");
                }
                admin_password.setSelection(admin_password.getText().length());
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();
            }
        });
    }

    private void validateData() {

        email = admin_email.getText().toString();
        pswrd = admin_password.getText().toString();

        if(email.isEmpty()){
            admin_email.setError("Required");
            admin_email.requestFocus();
        }else if(pswrd.isEmpty()){
            admin_password.setError("Required");
            admin_password.requestFocus();
        }else if(email.equals("admin@gmail.com") && pswrd.equals("12345")){
            editor.putString("isLogin","yes");
            editor.commit();
        openDash();
    }else {
            Toast.makeText(LoginActivity.this,"Please check email and password again!",Toast.LENGTH_LONG).show();
        }
    }

    private void openDash() {

        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }
}