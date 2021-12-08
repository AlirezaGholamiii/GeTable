package com.example.prjgetable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Model.user;
import Model.userreserve;

public class res_profile2 extends AppCompatActivity implements View.OnClickListener{
    TextView edDate,tvRestaurantName,tvRestaurantType, tvRestaurantDescription, tvRestaurantOffer,tvshowUser1,edName;
    Button btnConfirm;
    String userEmail1;
    DatabaseReference userdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_profile2);
        initialize();
    }

    private void initialize() {
        tvRestaurantType =findViewById(R.id.type1);
        tvRestaurantDescription = findViewById(R.id.Description1);
        tvRestaurantName = findViewById(R.id.restaurantName1);
        tvRestaurantOffer = findViewById(R.id.Offer1);
        edName = findViewById(R.id.editTextTextPersonName1);
        edDate = findViewById(R.id.edDate1);

        btnConfirm = findViewById(R.id.btnRequestTable1);

        btnConfirm.setOnClickListener( this);

        userdatabase = FirebaseDatabase.getInstance().getReference("reservation");


        String name = getIntent().getStringExtra("name");
        String type = getIntent().getStringExtra("type");
        String des = getIntent().getStringExtra("des");
        String offer = getIntent().getStringExtra("offer");
        tvRestaurantName.setText(name);
        tvRestaurantType.setText(type);
        tvRestaurantDescription.setText(des);
        tvRestaurantOffer.setText(offer);

        tvshowUser1 =findViewById(R.id.tvShowUser1);
        Intent intent1 = getIntent();
        userEmail1 = intent1.getStringExtra("username");
        tvshowUser1.setText("Welcome " + userEmail1 );


    }

    @Override
    public void onClick(View view) {
        int name = view.getId();
        switch(name) {
            case R.id.btnRequestTable1:
                Confirm();
                break;

        }

    }


    private void Confirm() {

        String Date = edDate.getText().toString();
        String ResName = tvRestaurantName.getText().toString();
        String ResDes = tvRestaurantDescription.getText().toString();
        String ResOffer = tvRestaurantOffer.getText().toString();
        String UserName = edName.getText().toString();

        userreserve auser = new userreserve(UserName,Date,ResName,ResDes,ResOffer);
        userdatabase.child(UserName).setValue(auser);
        Intent intent = new Intent(this, activity_reservation_confirmation.class);
        startActivity(intent);


        Toast.makeText(this, "user:"+UserName+"is reserved  successfully!！", Toast.LENGTH_SHORT).show();

    }

}