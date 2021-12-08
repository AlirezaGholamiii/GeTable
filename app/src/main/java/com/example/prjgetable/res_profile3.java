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

import Model.userreserve;

public class res_profile3 extends AppCompatActivity implements View.OnClickListener {
    TextView tvRestaurantName,tvRestaurantType,edDate,tvshowuser2, edName,tvRestaurantDescription, tvRestaurantOffer;
    Button btnRequestTable;

    String userEmail2;
    DatabaseReference userdatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_profile3);
        initialize();

    }

    private void initialize() {
        tvRestaurantType =findViewById(R.id.type2);
        tvRestaurantDescription = findViewById(R.id.Description2);
        tvRestaurantName = findViewById(R.id.restaurantName2);
        tvRestaurantOffer = findViewById(R.id.Offer2);
        edName = findViewById(R.id.editTextTextPersonName2);
        edDate = findViewById(R.id.edDate2);

        btnRequestTable = findViewById(R.id.btnRequestTable2);

        btnRequestTable.setOnClickListener(this);

        userdatabase = FirebaseDatabase.getInstance().getReference("reservation");


        String name = getIntent().getStringExtra("name3");
        String type = getIntent().getStringExtra("type3");
        String des = getIntent().getStringExtra("des3");
        String offer = getIntent().getStringExtra("offer3");
        tvRestaurantName.setText(name);
        tvRestaurantType.setText(type);
        tvRestaurantDescription.setText(des);
        tvRestaurantOffer.setText(offer);


        tvshowuser2=findViewById(R.id.tvShowUser1);
        Intent intent2 = getIntent();
        userEmail2 = intent2.getStringExtra("username");
       // tvshowuser2.setText("Welcome " + userEmail2 );
    }

    @Override
    public void onClick(View view) {
        int name = view.getId();
        switch(name) {
            case R.id.btnRequestTable2:
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