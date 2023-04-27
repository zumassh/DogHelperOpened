package com.example.doghelper;

public class BD_identify {
    public String id, chip_num, chip_date, chip_location, tatoo_num, tatoo_date, kleimo_num, kleimo_date;

    public BD_identify() {
    }

    public BD_identify(String id, String chip_num, String chip_date, String chip_location, String tatoo_num, String tatoo_date, String kleimo_num, String kleimo_date) {
        this.id = id;
        this.chip_num = chip_num;
        this.chip_date = chip_date;
        this.chip_location = chip_location;
        this.tatoo_num = tatoo_num;
        this.tatoo_date = tatoo_date;
        this.kleimo_num = kleimo_num;
        this.kleimo_date = kleimo_date;
    }
}
