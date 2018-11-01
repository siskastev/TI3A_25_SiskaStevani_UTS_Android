package com.stevanigmail.siska.uts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.stevanigmail.siska.uts.Login.SessionManagement;

import java.util.HashMap;

public class HomeActivity extends AppCompatActivity {

    TextView user;
    Button database;

    SessionManagement sessionManagement;
    HashMap<String,String> loginUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        user=findViewById(R.id.textUsername);
        database=findViewById(R.id.button);

        sessionManagement= new SessionManagement(this);
        loginUser=sessionManagement.getUserInformation();

        Toast.makeText(this,sessionManagement.isLoggedIn()+"",Toast.LENGTH_LONG).show();

        user.setText("SELAMAT DATANG, "+ loginUser.get(sessionManagement.KEY_USER));

        database.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HomeActivity.this,InputActivity.class );
                startActivity(intent);

            }
        });



    }
}
