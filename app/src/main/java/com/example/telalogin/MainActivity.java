package com.example.telalogin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editUsername;
    private EditText editPassword;
    private TextView textResult;

    private static final String RESULT_LOGIN = "LoginResult";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        textResult = findViewById(R.id.textResult);
        Button btnSubmit = findViewById(R.id.btnSubmit);

        View.OnClickListener onClickListener = new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                login(editUsername.getText().toString(), editPassword.getText().toString());
            }
        };

        btnSubmit.setOnClickListener(onClickListener);
    }

    @SuppressLint("SetTextI18n")
    private void login(String user, String password) {
        if(user.equals("adm") && password.equals("adm")) {
            textResult.setText("Login efetuado com sucesso!");
        }else {
            textResult.setText("Usuário ou senha inválido.");
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        assert savedInstanceState != null;
        textResult.setText(savedInstanceState.getString(RESULT_LOGIN));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        String resultText = textResult.getText().toString();

        outState.putString(RESULT_LOGIN, resultText);

        super.onSaveInstanceState(outState);
    }
}