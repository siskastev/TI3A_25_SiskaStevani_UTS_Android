package com.stevanigmail.siska.uts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.stevanigmail.siska.uts.Login.SessionManagement;

public class MainActivity extends AppCompatActivity {

    EditText user, pass;
    Button login;
    SessionManagement sessionManagement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user=findViewById(R.id.edituser);
        pass=findViewById(R.id.editPassword);
        login=findViewById(R.id.buttonLogin);
        sessionManagement=new SessionManagement(this);

        if (sessionManagement.isLoggedIn()) {
            goToActivity();
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String guser= user.getText().toString();
                String gpass= pass.getText().toString();

                if (guser.matches("")|| guser.trim().isEmpty() || gpass.matches("") || gpass.trim().isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Username & Password tidak boleh kosong/ Spasi",Toast.LENGTH_LONG).show();
                }
                else {
                    sessionManagement.createLoginSession(user.getText().toString(), pass.getText().toString());
                    goToActivity();
                }
            }
        });
    }

    private void goToActivity() {
        Intent mIntent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(mIntent);
    }
}
