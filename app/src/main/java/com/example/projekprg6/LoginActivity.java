package com.example.projekprg6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.TextPaint;
import android.graphics.Color;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private Button mBtnLogin;
    private TextView mRegisterText;
    private EditText mUsernameField;
    private EditText mPasswordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsernameField = findViewById(R.id.login_username);
        mPasswordField = findViewById(R.id.login_password);
        mBtnLogin = findViewById(R.id.btn_login);
        mRegisterText = findViewById(R.id.text_register);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String username = mUsernameField.getText().toString().trim();
                String password = mPasswordField.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Username atau password tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                } else {
                    if (username.equals("admin") && password.equals("admin")){
                        Toast.makeText(LoginActivity.this, "Login berhasil!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish(); // agar tidak balik ke halaman login
                    } else {
                        Toast.makeText(LoginActivity.this, "Username atau password salah!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        SpannableString span = new SpannableString("Belum punya Akun? Register");
        ClickableSpan ClickSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE); // Warna biru untuk teks Register
                ds.setUnderlineText(false);
            }
        };

        span.setSpan(ClickSpan, 18, 26, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mRegisterText.setText(span);
        mRegisterText.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
