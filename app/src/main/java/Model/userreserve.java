package Model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class userreserve {
    //Updated Attributes
    private String UserName, restaurantname, date,ResDes,ResOffer;

    //Constructor

    public userreserve() {
    }

    @Override
    public String toString() {
        return "userreserve{" +
                "UserName='" + UserName + '\'' +
                ", restaurantname='" + restaurantname + '\'' +
                ", date='" + date + '\'' +
                ", ResDes='" + ResDes + '\'' +
                ", ResOffer='" + ResOffer + '\'' +
                '}';
    }

    public userreserve(String userName, String restaurantname, String date, String resDes, String resOffer) {
        this.UserName = userName;
        this.restaurantname = restaurantname;
        this.date = date;
        this.ResDes = resDes;
        this.ResOffer = resOffer;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getRestaurantname() {
        return restaurantname;
    }

    public void setRestaurantname(String restaurantname) {
        this.restaurantname = restaurantname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getResDes() {
        return ResDes;
    }

    public void setResDes(String resDes) {
        ResDes = resDes;
    }

    public String getResOffer() {
        return ResOffer;
    }

    public void setResOffer(String resOffer) {
        ResOffer = resOffer;
    }
}