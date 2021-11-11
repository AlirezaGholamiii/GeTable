package com.example.prjgetable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.navigation.findNavController;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;
//import net.onefivefour.android.ebtimetracker.R;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class activity_home extends AppCompatActivity implements View.OnClickListener, NavigationBarView.OnItemSelectedListener {
    BottomNavigationView navigationView;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_home);


        navigationView = findViewById(R.id.bottomNavigationView);
        //navigationView.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) this);
    }

    @Override
    public void onClick(View view) {

    }

    @Deprecated
    public void onNavigationItemReselected(MenuItem item) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.activity_profileTab:
                Toast.makeText(this, "MAHAN HASTAM", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, activity_profile.class);
                startActivity(intent);
                break;
            default:
                return false;
        }

        return true;
    }
}