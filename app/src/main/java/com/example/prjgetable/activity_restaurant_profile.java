package com.example.prjgetable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Model.userreserve;

public class activity_restaurant_profile extends AppCompatActivity implements View.OnClickListener {

    TextView tvRestaurantName,edDate, tvRestaurantType, tvRestaurantDescription, tvRestaurantOffer,tvshowUser,edName;
    Button btnRequestTable;
    DatabaseReference restaurantDB, restaurantChild;
    String userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_restaurant_profile);

        initialize();

    }

    private void initialize() {
        tvRestaurantType = findViewById(R.id.type);
        tvRestaurantDescription = findViewById(R.id.Description);
        tvRestaurantName = findViewById(R.id.restaurantName);
        tvRestaurantOffer = findViewById(R.id.Offer);
        edDate = findViewById(R.id.edDate);
        btnRequestTable = findViewById(R.id.btnRequestTable);
        edName = findViewById(R.id.editTextTextPersonName);

        btnRequestTable.setOnClickListener(this);
        restaurantDB = FirebaseDatabase.getInstance().getReference("reservation");


        String name = getIntent().getStringExtra("name2");
        String type = getIntent().getStringExtra("type2");
        String des = getIntent().getStringExtra("des2");
        String offer = getIntent().getStringExtra("offer2");
        tvRestaurantName.setText(name);
        tvRestaurantType.setText(type);
        tvRestaurantDescription.setText(des);
        tvRestaurantOffer.setText(offer);
        tvshowUser =findViewById(R.id.tvShowUser);
        Intent intent = getIntent();
        userEmail = intent.getStringExtra("username");
        tvshowUser.setText("Welcome " + userEmail );

    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        switch (id) {
            case R.id.btnRequestTable:
                gotoNext();
                break;
        }
        //String name2 = getIntent().getStringExtra("name2");
        //Toast.makeText(this,name2,Toast.LENGTH_LONG).show();


    }

    private void gotoNext() {


        String Date = edDate.getText().toString();
        String ResName = tvRestaurantName.getText().toString();
        String ResDes = tvRestaurantDescription.getText().toString();
        String ResOffer = tvRestaurantOffer.getText().toString();
        String UserName = edName.getText().toString();

        userreserve auser = new userreserve(UserName,Date,ResName,ResDes,ResOffer);
        restaurantDB.child(UserName).setValue(auser);
        Intent intent = new Intent(this, activity_reservation_confirmation.class);
        startActivity(intent);


        Toast.makeText(this, "user:"+UserName+"is reserved  successfully!！", Toast.LENGTH_SHORT).show();


    }
}


