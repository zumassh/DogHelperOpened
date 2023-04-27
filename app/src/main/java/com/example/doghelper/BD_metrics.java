package com.example.doghelper;

public class BD_metrics {
    public String id;
    public String puppy_breed;
    public String puppy_name;
    public String father_name;
    public String puppy_birthday;
    public String puppy_sex;
    public String puppy_color;
    public String puppy_kleimo;
    public String RKF_father;
    public String mother_name;
    public String RKF_mother;
    public String breeder_FIO;
    public String breeder_address;
    public String owner_FIO;
    public String owner_address;
    public String reason;
    public String radio_yes;
    public String radio_no;

    public BD_metrics() {
    }

    public BD_metrics(String id, String puppy_breed, String puppy_name, String father_name, String puppy_birthday, String puppy_sex, String puppy_color, String puppy_kleimo, String RKF_father, String mother_name, String RKF_mother, String breeder_FIO, String breeder_address, String owner_FIO, String owner_address, String reason, String radio_yes, String radio_no) {
        this.id = id;
        this.puppy_breed = puppy_breed;
        this.puppy_name = puppy_name;
        this.father_name = father_name;
        this.puppy_birthday = puppy_birthday;
        this.puppy_sex = puppy_sex;
        this.puppy_color = puppy_color;
        this.puppy_kleimo = puppy_kleimo;
        this.RKF_father = RKF_father;
        this.mother_name = mother_name;
        this.RKF_mother = RKF_mother;
        this.breeder_FIO = breeder_FIO;
        this.breeder_address = breeder_address;
        this.owner_FIO = owner_FIO;
        this.owner_address = owner_address;
        this.reason = reason;
        this.radio_yes = radio_yes;
        this.radio_no = radio_no;
    }
}
