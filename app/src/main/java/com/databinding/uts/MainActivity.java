package com.databinding.uts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    //  Attribute yang akan kita pakai
    private TextInputLayout inputUsername;
    private TextInputLayout inputPassword;
    private ConstraintLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Ubah Title pada App Bar Aplikasi
        setTitle("User Login");

        //  Hubungkan variabel dengan view di layoutnya.
        inputUsername = findViewById(R.id.inputLayoutUsername);
        inputPassword = findViewById(R.id.inputLayoutPassword);
        mainLayout = findViewById(R.id.mainLayout);

        Button btnClear = findViewById(R.id.btnClear);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnClear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                inputUsername.getEditText().setText("");
                inputPassword.getEditText().setText("");


                Snackbar.make(mainLayout,"Text Cleared Success",Snackbar.LENGTH_LONG).show();
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean checkLogin = false;
                String username = inputUsername.getEditText().getText().toString();
                String password = inputPassword.getEditText().getText().toString();


                if(username.isEmpty()){
                    inputUsername.setError("Username must be filled with text");
                    checkLogin = false;
                }


                if(password.isEmpty()){
                    inputPassword.setError("Password must be filled with text");
                    checkLogin = false;
                }


                if(username.equals("Alfa") && password.equals("0388"))
                    checkLogin = true;

                if(!checkLogin) return;

                Intent moveHome = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(moveHome);
            }
        });
    }
}