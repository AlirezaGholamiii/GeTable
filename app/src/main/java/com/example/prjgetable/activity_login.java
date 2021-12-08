package com.example.prjgetable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class activity_login extends AppCompatActivity implements View.OnClickListener, ValueEventListener {

    TextView edEmail, edPass ;
    Button tvLogin, tvSignUp;
    DatabaseReference userDatabase, userChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        initialize();
    }

    private void initialize() {
        edEmail = findViewById(R.id.edEmail);
        edPass = findViewById(R.id.edPass);
        tvSignUp = findViewById(R.id.tvSignUp);
        tvLogin = findViewById(R.id.tvLogin);

        userDatabase = FirebaseDatabase.getInstance().getReference("users");

        tvSignUp.setOnClickListener(this);
        tvLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.tvSignUp: signup(); break;
            case R.id.tvLogin: login(); break;
        }
    }

    private void signup() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    private void login() {
        try {

            String id = "200";
            userChild = FirebaseDatabase.getInstance().getReference().child("users").child(id);
            userChild.addValueEventListener(this);
        }catch (Exception e) {
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        if (dataSnapshot.exists()) {
            //True
            String id = dataSnapshot.child("id").getValue().toString();
            String email = dataSnapshot.child("email").getValue().toString();
            String password = dataSnapshot.child("password").getValue().toString();

            edEmail.setText(email);
            edPass.setText(password);
            String username = edEmail.getText().toString();

            Intent intent = new Intent(this, activity_home.class);
            intent.putExtra("username",username);
            startActivity(intent);
        }
        else {
            //False
            Toast.makeText(this, "The User with Email : " + edEmail.getText().toString() + " does not exists, please check your info", Toast.LENGTH_SHORT).show();

            edEmail.setText(null);
            edPass.setText(null);
            edEmail.requestFocus();
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
}