package com.example.vohongphuc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Shopcat_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shopcat); // Đảm bảo file layout tên là activity_shopcat.xml

        // Đổi R.id.main nếu bạn đã sửa lại ID container theo hướng dẫn trước
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.layoutCart), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Xử lý nút quay về trang chủ
        Button btnBack = findViewById(R.id.btnBackHome);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Shopcat_Activity.this, Home_Activity.class);
                startActivity(intent);
                finish(); // Đóng Shopcat để tránh chồng nhiều activity
            }
        });
    }
}
