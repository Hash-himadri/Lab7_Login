package com.himadri_parikh.lab7_login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    EditText edtUser, edtPass;
    Button btnLogin;

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUser = findViewById(R.id.edtUsername);
        edtPass = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        bottomNavigationView=findViewById(R.id.bottom);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, new Home());


        bottomNavigationView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {


            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case  R.id.homes:
                        fragmentTransaction.replace(R.id.fragmentContainerView, new Home());
                        break;
                    case  R.id.login:
                        fragmentTransaction.replace(R.id.fragmentContainerView, new Login());
                        break;

                }
            }
        });
    }
}