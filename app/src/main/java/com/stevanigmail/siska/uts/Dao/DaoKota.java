package com.stevanigmail.siska.uts.Dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.stevanigmail.siska.uts.Model.Kota;

import java.util.List;

@Dao
public interface DaoKota {

    @Query("SELECT * FROM kota")
    List<Kota> getAll();

    @Insert
    void insertAll(Kota... kotas);


}
