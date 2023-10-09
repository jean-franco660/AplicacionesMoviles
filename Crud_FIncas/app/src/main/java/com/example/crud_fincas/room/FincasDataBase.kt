package com.example.crud_fincas.room

import androidx.room.Database

import androidx.room.RoomDatabase

import com.example.crud_fincas.models.Fincas




@Database(
    entities = [Fincas::class],
    version = 1,
    exportSchema = false
)
abstract class FincasDataBase : RoomDatabase() {
    abstract fun fincasDao(): FincasDatabaseDao
}
