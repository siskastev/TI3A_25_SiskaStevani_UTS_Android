package com.stevanigmail.siska.uts.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Kota {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "kota")
    private String kota;

    public Kota(String kota) {
        this.kota = kota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }
}
