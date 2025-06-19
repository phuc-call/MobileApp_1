package com.example.vohongphuc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    EditText email, password, confirmPassword;
    Button btnRegisterSubmit, btnBackLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.register_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        email = findViewById(R.id.editTextRegisterEmail);
        password = findViewById(R.id.editTextRegisterPassword);
        confirmPassword = findViewById(R.id.editTextRegisterConfirmPassword);
        btnRegisterSubmit = findViewById(R.id.btnRegisterSubmit);
        btnBackLogin = findViewById(R.id.btnBackLogin);

        btnRegisterSubmit.setOnClickListener(v -> {
            String txtEmail = email.getText().toString().trim();
            String txtPass = password.getText().toString();
            String txtConfirm = confirmPassword.getText().toString();

            if (txtEmail.isEmpty() || txtPass.isEmpty() || txtConfirm.isEmpty()) {
                Toast.makeText(this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!txtPass.equals(txtConfirm)) {
                Toast.makeText(this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                return;
            }

            // Lưu dữ liệu đăng ký
            SharedPreferences prefs = getSharedPreferences("UserData", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("email", txtEmail);
            editor.putString("password", txtPass);
            editor.apply();

            Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();

            // Chuyển về login
            startActivity(new Intent(this, Login_Activity.class));
            finish();
        });

        // Nút quay lại Login
        btnBackLogin.setOnClickListener(v -> {
            startActivity(new Intent(RegisterActivity.this, Login_Activity.class));
            finish();
        });
    }
}
