package com.example.lesson_6_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("MissingInflatedId")
public class MainActivity extends AppCompatActivity {

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btn_enter);
        EditText email = findViewById(R.id.ed_email);
        EditText password = findViewById(R.id.ed_password);
        TextView enter = findViewById(R.id.tv_enter);
        TextView register = findViewById(R.id.tv_register);

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.isEmpty(s)) {
                    button.setBackgroundColor(getColor(R.color.orange));
                } else {
                    button.setBackgroundColor(getColor(R.color.gray));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        button.setOnClickListener(v -> {
            if (email.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
                button.setVisibility(View.INVISIBLE);
                email.setVisibility(View.INVISIBLE);
                password.setVisibility(View.INVISIBLE);
                enter.setVisibility(View.INVISIBLE);
                register.setVisibility(View.INVISIBLE);
            } else {
                Toast.makeText(MainActivity.this, "Не верный логин и пароль", Toast.LENGTH_SHORT).show();
            }
        });


    }
}