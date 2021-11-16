package com.example.prjgetable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Initialize();
    }


    private void Initialize() {

        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
       int id = view.getId();
        switch (id){
            case R.id.btnSignUp: {
                Intent intent = new Intent(this, activity_reservation_time.class);
                startActivity(intent);
            }
            break;
        }

    }


}



