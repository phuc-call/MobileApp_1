package com.example.vohongphuc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//import để lấy thông tu register
import android.content.Context;
import android.content.SharedPreferences;

import android.content.Intent;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnHome = findViewById(R.id.button5);
        Button btnRegister=findViewById(R.id.button6);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText objPhone = findViewById(R.id.editTextTextEmailAddress2);
                EditText objPass = findViewById(R.id.editTextTextPassword2);

                String txtPhone = objPhone.getText().toString();
                String txtPass = objPass.getText().toString();
                // Lấy thông tin đã lưu từ SharedPreferences
                SharedPreferences prefs = getSharedPreferences("UserData", Context.MODE_PRIVATE);
                String savedEmail = prefs.getString("email", "");
                String savedPassword = prefs.getString("password", "");

                if (txtPhone.equals(savedEmail) && txtPass.equals(savedPassword)) {
                    Toast.makeText(getApplicationContext(), "Login success!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Login_Activity.this, Home_Activity.class);
                    startActivity(intent);
                    finish(); // Đóng màn login
                } else {
                    Toast.makeText(getApplicationContext(), "Login fail!", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent R=new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(R);
            }
        });
    }
}
