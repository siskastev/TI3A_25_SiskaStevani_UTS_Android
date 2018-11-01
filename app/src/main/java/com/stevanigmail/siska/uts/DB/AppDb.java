package com.stevanigmail.siska.uts.DB;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.stevanigmail.siska.uts.Dao.DaoKota;
import com.stevanigmail.siska.uts.Model.Kota;

@Database(entities = {Kota.class}, version = 1)
public abstract class AppDb extends RoomDatabase {
    public abstract DaoKota daoKota();
}
