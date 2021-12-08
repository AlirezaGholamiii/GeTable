package com.example.prjgetable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class activity_reservation_confirmation extends AppCompatActivity implements View.OnClickListener{

    TextView tvshowResReserved,tvShowDate;
    Button btnGotoHome, btnLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_reservation_confirmation);

        initialize();

    }

    private void initialize() {
btnGotoHome = findViewById(R.id.btnComfirm);
btnGotoHome.setOnClickListener(this);
        btnLogOut = findViewById(R.id.btnLogOut);
        btnLogOut.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {

            case R.id.btnComfirm: {
                Intent intent = new Intent(this, activity_home.class);
                startActivity(intent);
            }
            break;
            case R.id.btnLogOut: {
                Intent intent = new Intent(this, WelcomeActivity.class);
                startActivity(intent);
            }
            break;

        }
    }
}