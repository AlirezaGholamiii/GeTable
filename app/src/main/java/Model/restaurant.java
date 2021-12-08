package Model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class restaurant {
    //Updated Attributes
    private int id;
    private String name;
    private String address;
    private String phone;
    private String type;
    private String description;
    private String offer;

    //Constructor
    public restaurant() {

    }
    public restaurant(int id, String name, String address, String phone, String type, String description, String offer) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.type = type;
        this.description = description;
        this.offer = offer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }
    @NonNull
    @Override
    public String toString() {
        return
"                                                       "+ '\n'+
                name + '\n' +
                 address + '\n' +
                phone + '\n' +
                 type + '\n' +
                 description + '\n'
                ;
    }
}