package com.example.doghelper;

public class BD_owner {
    public String id, name, surname, country, city, street, house, flat, index;

    public BD_owner() {
    }

    public BD_owner(String id, String name, String surname, String country, String city, String street, String house, String flat, String index) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
        this.index = index;
    }
}
