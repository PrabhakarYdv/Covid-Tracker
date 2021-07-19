package com.prabhakar.covidtracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button loginButton;
    private String email_pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        email = findViewById(R.id.email_box);
        password = findViewById(R.id.password_box);
        loginButton = findViewById(R.id.login_btn);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (emailValidation() && passwordValidation()) {
                    Intent intent = new Intent(MainActivity.this, HomeScreenActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean emailValidation() {
        if (email.getText().toString().matches(email_pattern)) {
            return true;
        } else {
            email.setError("InValid Email");
            return false;

        }
    }

    private boolean passwordValidation() {
        if (password.getText().toString().length() < 6) {
            password.setError("Password is very short");
            return false;
        } else {
            return true;
        }
    }

}