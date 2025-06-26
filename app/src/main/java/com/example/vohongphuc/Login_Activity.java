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

                String txtPhone = objPhone.getText().toString().trim();
                String txtPass = objPass.getText().toString().trim();

                // Kiểm tra mật khẩu có phải là số hay không
                if (!txtPass.matches("\\d+")) {
                    Toast.makeText(getApplicationContext(), "Mật khẩu phải là số!", Toast.LENGTH_LONG).show();
                    return;
                }

                // So sánh với thông tin gán cứng
                if (txtPhone.equals("phucboygo@gmail.com") && txtPass.equals("123")) {
                    Toast.makeText(getApplicationContext(), "Login success!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Login_Activity.this, Home_Activity.class);
                    startActivity(intent);
                    finish(); // Đóng màn hình login
                } else {
                    Toast.makeText(getApplicationContext(), "Password or Email not default!", Toast.LENGTH_LONG).show();
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
