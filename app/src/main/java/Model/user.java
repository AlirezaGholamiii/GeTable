package Model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class user {
    //Updated Attributes
    private int id;
    public String fullName, email, password, country;

    //Constructors


    public user(String uniqueId, String name, String password, String email, String country) {
        this.fullName = name;
        this.email = email;
        this.password = password;
        this.country =country;

    }

    public user() {

    }


    //Getters&Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public  String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    //Methods

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}