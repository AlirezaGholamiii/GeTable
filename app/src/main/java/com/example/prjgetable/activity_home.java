package com.example.prjgetable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Model.restaurant;
import Model.user;

public class activity_home extends AppCompatActivity  implements ChildEventListener, View.OnClickListener,ValueEventListener {


    TextView tvshowUser;
    ListView lvRestaurant;
    ArrayList<restaurant> listRestaurant;
    ArrayAdapter<restaurant> lvAdapter;
    restaurant ares;
    user auser;
    String userEmail;
    DatabaseReference restaurantDB,restaurantChild;


    Button btnResturant1,btnResturant2,btnResturant3,btnResturant4,btnResturant5,btnResturant6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        initialize();
    }

    private void initialize() {

        tvshowUser =findViewById(R.id.tvProfile);
        Intent intent = getIntent();
        userEmail = intent.getStringExtra("username");
        tvshowUser.setText("Welcome " + userEmail +"\n"+"Resturants We Have");


        /*Intent intent1 = new Intent(this, activity_restaurant_profile.class);
        intent.putExtra("username",username);
        startActivity(intent1);*/

        ares = new restaurant();
        auser = new user();
        restaurantDB = FirebaseDatabase.getInstance().getReference("restaurants");
       // restaurantChild = restaurantDB.child("200");
        restaurantDB.addChildEventListener(this);
        lvRestaurant  = findViewById(R.id.tvRestaurantList);
        listRestaurant = new ArrayList<restaurant>();
        lvAdapter = new ArrayAdapter<restaurant>(this, android.R.layout.simple_list_item_1,listRestaurant);

        lvRestaurant.setAdapter(lvAdapter);
        //restaurantChild.addChildEventListener(this);

        btnResturant1 = findViewById(R.id.btnRes1);
        btnResturant2 = findViewById(R.id.btnRes2);
        btnResturant3 = findViewById(R.id.btnRes3);


        btnResturant1.setOnClickListener(this);
        btnResturant2.setOnClickListener(this);
        btnResturant3.setOnClickListener(this);







    }



    @Override
    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
        if(snapshot.exists()){
            try {
                int restaurantId = Integer.valueOf(snapshot.child("id").getValue().toString());
                String restaurantName = snapshot.child("name").getValue().toString();
                String restaurantAddrress = snapshot.child("address").getValue().toString();
                String restauranttype = snapshot.child("type").getValue().toString();
                String restaurantoffer = snapshot.child("offer").getValue().toString();
                String restaurantPhone = snapshot.child("phone").getValue().toString();
                String restaurantDescription = snapshot.child("description").getValue().toString();
                restaurant Restaurant = new restaurant( restaurantId,restaurantAddrress,restaurantoffer,restaurantName,restauranttype,restaurantPhone,restaurantDescription);
                listRestaurant.add(Restaurant);
                lvAdapter.notifyDataSetChanged();

            }catch (Exception e){
                Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
            }

        }
        else {
            Toast.makeText(this, "wrong", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

    }

    @Override
    public void onChildRemoved(@NonNull DataSnapshot snapshot) {

    }

    @Override
    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

    }


    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {

    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch(id){
            case R.id.btnRes1:

                intentnext1();

                break;
            case R.id.btnRes2:
                intentnext2();
                ;break;

            case R.id.btnRes3:
                intentnext3();
                ;break;



        }
    }

    private void intentnext2() {

        String name2 = "Hélicoptère";
        String type2 = "Quebecoise";
        String des2 = "Expect a menu of colourful, creative plates spotlighting plenty of seasonal fare from chef David Ollu";
        String offer2 = "Thursdays 5-7pm: 2x1 On Mocktails";
        Intent intent2 = new Intent(this, activity_restaurant_profile.class);
        intent2.putExtra("name2",name2);
        intent2.putExtra("type2",type2);
        intent2.putExtra("des2",des2);
        intent2.putExtra("username",userEmail);
        intent2.putExtra("offer2",offer2);
        startActivity(intent2);
        this.finish();
    }

    private void intentnext1() {
        String name = "Antonietta";
        String type = "Italian";
        String des = "Two-year-old Papineau Street Italian eatery Antonietta excels at all manner of pasta and pizza";
        String offer = "10% Discount on Birthday Celebrations";
        Intent intent = new Intent(this, res_profile2.class );
        intent.putExtra("name",name);
        intent.putExtra("type",type);
        intent.putExtra("des",des);
        intent.putExtra("username",userEmail);

        intent.putExtra("offer",offer);
        startActivity(intent);
        this.finish();

    }
    private void intentnext3() {
        String name = "Kwizinn";
        String type = "Haitian";
        String des = "Kwizinn has won the hearts of many with its griot (fried pork cubes), tassot cabrit (goat marinated with herbs and spices), and créole lambi";
        String offer = "No Offers Available";
        Intent intent3 = new Intent(this, res_profile3.class );
        intent3.putExtra("name3",name);
        intent3.putExtra("type3",type);
        intent3.putExtra("des3",des);
        intent3.putExtra("offer3",offer);
        startActivity(intent3);
        this.finish();

    }
}

